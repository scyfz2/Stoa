<template>
	<view style="width: calc(100% - 32px);margin:0 16px;position: fixed;left:0;top:0;z-index:60;background: #FFFFFF;overflow: scroll;">
		<!-- 导航栏 -->
		<uni-nav-bar class="navigationBar" :left-text="lang.back" :title="lang.comments" :showLeftIcon="true" :isNavHome="isNavHome"
		 :height="navbarHeight"></uni-nav-bar>
		<view :style="{ height: navbarHeight + 'px' }" style="width: 100%;"></view>
		<!--todo 导航栏替换文字-->

		<commentarea class="comment-area" :commentList="commentList" :commentNum="longArticle.commentNum" @onChange="changeType"
		 @like="swLikeComment" @goToCommentDetail="goToCommentDetail"></commentarea>
		<view style="height: 500px;width: 100%;"></view>

		<view v-if="!isShowInput" @tap='controlShowInput' style="position: fixed;right: 20px;bottom:50px;width: 60px;height: 60px;background-color: rgba(252, 192, 65, 1);display: flex;justify-content: center;align-items:center;border-radius: 50%;">
			<image src="../../static/icon/edit-2c2c2c.png" style="width: 32px;height: 32px;"></image>
		</view>
		<nq-commit-area :isShow="isShowInput" :userInfo="longArticle.userId" @submit="saveComment" @killCommitArea="controlShowInput"
		 :openOrigin="'detail'"></nq-commit-area>
	</view>
</template>

<script>
	import commentarea from '@/components/nq-comment/commentarea.vue';
	import nqCommitArea from '@/components/nq-commitArea/nq-commitArea.vue'
	import {
		mapState,
		mapMutations
	} from 'vuex';
	export default {
		data() {
			return {
				//页面基础变量
				userInfo: "",

				//数据变量
				longArticle: "", //本地化。  评论页为新数据中心
				commentList: [], //返回值，获取评论列表信息
				totalPage: 1, //评论分页属性
				currentPage: 1, //评论分页属性
				type: 0, //查询评论接口参数，0：按时间查询, 1：按热度查询
				//页面内控制变量
				isShowInput: false,
				uploadFlag: false,
				navbarHeight: "",
			}
		},
		components: {
			commentarea,
			nqCommitArea,
		},
		computed: {
			...mapState(['lang'])
		},
		onReachBottom() {
			this.loadMore();
		},
		onLoad(options) {
			//获取全局用户信息
			var userInfo = this.getGlobalUserInfo();
			if (!this.isNull(userInfo)) {
				this.userInfo = this.getGlobalUserInfo();
			} else {
				uni.redirectTo({
					url: '../signin/signin'
				});
				return;
			}

			// 获取传入的文章 ID
			this.longArticle = JSON.parse(options.data);
			console.log(this.longArticle);

			// 导航栏高度
			this.navbarHeight = this.getnavbarHeight().bottom + 5;
			console.log(this.longArticle);
			this.getLongArticleComment(1);
		},
		mounted() {

		},
		methods: {

			controlShowInput() {
				this.isShowInput = !this.isShowInput;
			},
			goToCommentDetail(mainComment) {
				var data = {
					mainComment: mainComment,
					type: "article"
				}
				uni.navigateTo({
					url: '/pages/comment-detail/comment-detail?data=' + encodeURIComponent(JSON.stringify(data))
				});
			},
			changeType(e) {
				this.type = e.type;
				this.getLongArticleComment(1);
			},
			/**
			 * 点赞或取消点赞评论
			 * @param {Object} comment
			 */
			swLikeComment(comment) {
				var mainComment = comment.mainComment;
				if (mainComment.isLike) {
					this.unLikeComment(mainComment);
				} else {
					this.likeComment(mainComment);
				}
				mainComment.isLike = !mainComment.isLike;
				this.$emit('flash long article detail');
			},

			likeComment(comment) {
				console.log('点赞评论');
				var that = this;
				uni.request({
					method: 'POST',
					url: that.$serverUrl + '/social/userLike',
					data: {
						userId: that.userInfo.id,
						targetType: "COMMENT",
						targetId: comment.id,
					},
					header: {
						'content-type': 'application/x-www-form-urlencoded'
					},
					success: res => {
						console.log(res);
						comment.likeNum++;
					}
				});
			},

			unLikeComment(comment) {
				console.log('取消点赞评论');
				var that = this;
				uni.request({
					method: 'POST',
					url: that.$serverUrl + '/social/userUnLike',
					data: {
						userId: that.userInfo.id,
						targetType: "COMMENT",
						targetId: comment.id,
					},
					header: {
						'content-type': 'application/x-www-form-urlencoded'
					},
					success: res => {
						console.log(res);
						comment.likeNum--;
					}
				});
			},

			/**
			 * fromUserId 必填
			 * toUserId 必填
			 * articleId 必填 // 为了计算文章总评论数
			 * underCommentId // 显示在该主评论层ID下
			 * fatherCommentId // 父级评论ID
			 * comment 必填
			 * PS: 父级（一级，给文章评论）评论 无 fatherCommentId, underCommentId;
			 *     子级评论有 fatherCommentId, underCommentId;
			 */
			saveComment: function(content) {
				console.log('conteng =' + content);
				console.log('tragger savecomment');
				// 赋值评论内容
				this.commentContent = content;
				if (this.uploadFlag) {
					console.log('正在上传...');
					return;
				}
				this.uploadFlag = true;
				uni.showLoading({
					title: '正在上传...'
				});

				var submitData = {
					fromUserId: this.userInfo.id,
					toUserId: this.longArticle.userId,
					targetType: "LONGARTICLE",
					targetId: this.longArticle.id,
					comment: content,
				}
				console.log(submitData);
				var that = this;
				if (this.commentContent == '') {
					uni.showToast({
						title: '好像忘写评论了哦~',
						duration: 1000,
						icon: 'none'
					});
				} else {
					uni.request({
						url: that.$serverUrl + '/social/saveComment',
						method: 'POST',
						header: {
							'content-type': 'application/x-www-form-urlencoded'
						},
						data: submitData,
						success: res => {
							uni.hideLoading();
							if (res.data.status == 200) {
								uni.hideLoading();
								that.uploadFlag = false;

								that.controlShowInput();
								// 强制子组件重新刷新

								that.getLongArticleComment(1);
								that.$emit('flash long article detail') // 文章评论数累加
							} else if (res.data.status == 500) {
								that.contentIllegal();
							}
						}
					});
				}
			},
			contentIllegal() {
				
				this.$store.commit('showToast', {
					duration: 1000,
					content: '内容违规',
				});
			},


			getLongArticleComment(page) {
				var that = this;
				uni.showLoading({
					title: '加载中...'
				});
				uni.request({
					method: 'POST',
					url: that.$serverUrl + '/social/getMainComments',
					data: {
						page: page,
						type: that.type,
						targetType: "LONGARTICLE",
						targetId: that.longArticle.id,
						userId: that.userInfo.id,
					},
					header: {
						'content-type': 'application/x-www-form-urlencoded'
					},
					success: async res => {
						if (res.data.status == 200) {
							if (page == 1) {
								that.commentList = [];
							}
							var commentList = [];
							//获取主评论
							var mainComments = res.data.data.rows;
							console.log(mainComments)
							//获取子评论
							// for(let mainComment of mainComments){
							for (var i = 0; i < mainComments.length; i++) {
								var comment;
								var mainComment = mainComments[i];
								await this.getSubComments(mainComment.id, 1).then(subComment => {
									comment = {
										mainComment: mainComment,
										subComment: subComment
									}
									commentList.push(comment);
								})
							}
							// 拼接
							var newCommentList = commentList;
							var oldCommentList = this.commentList;
							this.commentList = oldCommentList.concat(newCommentList);
							this.currentPage = page;
							this.totalPage = res.data.data.total;
							console.log(this.commentList);
						

							//this.control_scroll_butoon(); //获取评论数据后，生成卡片后，判断总页面高度，控制是否显示回到顶部按钮
						} else {
							console.log(res);
						}
						uni.hideLoading();
					}
				});
			},
			getSubComments(mainCommentId, page) {
				return new Promise((resolve, reject) => {
					uni.request({
						method: "POST",
						url: this.$serverUrl + '/social/getSubComments',
						data: {
							underCommentId: mainCommentId,
							userId: this.userInfo.id,
							page: page,
							type: 0,
						},
						header: {
							'content-type': 'application/x-www-form-urlencoded'
						},
						success: (res) => {
							// console.log(res);
							if (res.data.status == 200) {
								var subCommentNum = res.data.data.records;
								var subCommentList;
								if (subCommentNum <= 2) {
									subCommentList = res.data.data.rows;
								} else {
									subCommentList = res.data.data.rows.slice(0, 2);
								}
								var subComment = {
									subCommentList: subCommentList,
									subCommentNum: subCommentNum
								}
								resolve(subComment);
							} else {
								reject("Request fail");
							}
						},
						fail: res => {
							reject("Request fail");
						}
					});
				})
			},
			loadMore: function() {
				var that = this;
				var currentPage = that.currentPage;
				console.log(currentPage);
				var totalPage = that.totalPage;
				console.log(totalPage);
				// 判断当前页数和总页数是否相等
				if (that.commentList.length < 10) {
					return;
				} else if (currentPage == totalPage) {
					// that.showArticles(1);
					uni.showToast({
						title: '没有更多评论了',
						icon: 'none',
						duration: 1000
					});
				} else {
					var page = currentPage + 1;
					that.getComments(page);
				}
			},
		},
	}
</script>

<style>
</style>
