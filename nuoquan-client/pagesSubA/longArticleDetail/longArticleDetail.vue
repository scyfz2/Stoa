<!--
长文章详情页面
todo 跳转到本页面的方法，data=article ID， 同detail, onLoad记得替换
todo 分享海报功能，取消注释并调用
yao

#2020年8月27日 articleID 替换完毕 -Guetta
#2020年8月27日 TODO: 接口全部调用完毕，等待后端修复 cover-image 为必填的 bug，等待大文本解析
-->

<template>
	<view class="detail-page">
		<!-- 导航栏 -->
		<uni-nav-bar class="navigationBar" :left-text="lang.back" :title="lang.detail" :showLeftIcon="true" :isNavHome="isNavHome"
		 :height="navbarHeight"></uni-nav-bar>
		<view :style="{ height: navbarHeight + 'px' }" style="width: 100%;"></view>
		<!--todo 导航栏替换文字-->

		<view style="margin-top: 14px;margin-bottom: 20px;display: flex;flex-direction: column;width: 100%;">
			<!-- todo   isYuanchuan需要替换为卡片数据-->
			<!-- <text selectable="true" class="longArticleDetail-title" :style="{width : '100%'}" :class="{'yuanchuang':isYuanchuang}">{{ thisLongArticle.title }}</text> -->
			<text v-if="thisLongArticle.title !== null" selectable="true" class="longArticleDetail-title" :style="{width : '100%'}">{{ thisLongArticle.title }}</text>
			<text v-if="thisLongArticle.subTitle !== null" selectable="true" class="longArticleDetail-subTitle" :style="{width : '100%'}">{{ thisLongArticle.subTitle }}</text>
			<!--标题-->
			<!--作者信息，头像名字时间-->
			<view class="author-info-bar">
				<image :src="pathFilter(thisLongArticle.faceImg)" class="touxiang" @click="goToPersonPublic()"></image>
				<text selectable="true" class="name" @tap="goToPersonPublic()">{{ thisLongArticle.nickname }}</text>
				<view class="time">发布于{{ timeDeal(thisLongArticle.createDate) }}</view>
			</view>
		</view>

		<!--内容-->
		<longArticleComponent style="width: 100%;height: auto;" v-for="(i,index) in savedArticleContent" :key="index" :item="i"></longArticleComponent>
		<!-- safeArea -->
		<view style="width: 100%;height: 80px;"></view>
		<!-- 底部操作行 -->
		<view class="menu-bar">
			<!-- 收藏 -->
			<view class="collect" @tap="toggleCollect()" style="border-radius:8px 0 0 8px;" hover-class="hoverColor">
				<image v-if="!thisLongArticle.isCollect" src="../../static/icon/star-888888.png" mode="aspectFit"></image>
				<image v-if="thisLongArticle.isCollect" src="../../static/icon/star-full-fcc041.png" mode="aspectFit"></image>
			</view>
			<!-- 点赞 -->
			<view class="like" :class="{'liked': thisLongArticle.isLike}" @tap="swLikeLongArticle()" style="border-radius:8px 0 0 8px;"
			 hover-class="hoverColor">
				<image v-if="!thisLongArticle.isLike" src="../../static/icon/thumbs-up-888888.png" mode="aspectFit"></image>
				<image v-if="thisLongArticle.isLike" src="../../static/icon/liked.png" mode="aspectFit"></image>
				{{ thisLongArticle.likeNum }}
			</view>
			<!-- 评论 -->
			<view class="comment" @click="goToCommentPage" hover-class="hoverColor">
				<!--todo  完善展示评论区域相关函数-->
				<image v-if="!showInput" src="../../static/icon/comment-alt-888888.png" mode="aspectFit"></image>
				{{ thisLongArticle.commentNum }}
			</view>
			<!-- 分享 -->
			<view class="share" @tap="showUnfinishToast()" hover-class="hoverColor">
				<image src="../../static/icon/wechatMoment.png" mode="aspectFit"></image>
				<!-- {{ lang.sharetoMoments }} -->
			</view>
		</view>

		<!-- 悬浮窗 -->
		<!-- <view style="height: 50px;width:106px;position: fixed;bottom:200px;right: 5px;z-index: 10;background: #FFFFFF;box-shadow: 0px 3px 5px rgba(160,160,160,0.16);border-radius: 3PX;">
			<image :src="pathFilter(thisLongArticle.faceImg)" class="touxiang" style="margin:4px 9px 9px 12px;vertical-align: bottom;"></image>
			<view style="font-size:12px;line-height: 12px;height:12px;padding: 19px 12px 19px 0;overflow: hidden;width:36px;display: inline-block;vertical-align: bottom;word-wrap: normal;">{{articleCard.nickname}}</view>
			<view style="position: absolute;bottom:4px;left:24px;width: 13px;height: 13px;border-radius: 50%;background-color: #FCC041;color: #FFFFFF;line-height: 10px;text-align: center;">+</view>
		</view> -->
	</view>
</template>

<script>
	// import mySharePoster from 'components/shareposter/myshareposter.vue';
	import longArticleComponent from '../../components/nq-card/long_article_component.vue';
	import uniNavBar from '@/components/uni-nav-bar/uni-nav-bar.vue';
	import {
		mapState
	} from 'vuex';
	import nq_parse from '@/pagesSubA/longArticleDetail/parse.js'

	export default {
		components: {
			// mySharePoster,
			uniNavBar,
			longArticleComponent,
			
		},
		data() {
			return {

				navbarHeight: "",
				longArticleId: "",
				thisLongArticle: '', // 储存长文章的 object
				userInfo: '',
				isYuanchuang: true, //控制原创变量，由文章加载后替换删除此变量
				
				savedArticleContent: [], //  文章主体数组，由JS解析articleContent为数组，新变量savedArticleContent或原路赋值
			};
		},
		computed: {
			...mapState(['lang'])
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
			this.longArticleId = options.data || options.scene;
			// console.log("data="+options.data); //跳转进入
			// console.log("sence="+options.scene); //扫码进入

			// 导航栏高度
			this.navbarHeight = this.getnavbarHeight().bottom + 5;
			var that = this;
			//this.loadLongArticle();

		},
		onShow() {
			this.loadLongArticle();//
		},
		onUnload() {
			// 更新本文章信息给上级页面，同步数据
			uni.$emit('updateLongArticle', this.thisLongArticle);
			console.log(this.thisLongArticle)
			console.log('返回');
		},

		methods: {
			share(mode) {
				if (mode == 'chat') {
					//todo  分享到聊天
				} else {
					//todo 分享到朋友圈
				};
			},
			goToCommentPage() {
				uni.navigateTo({
					url: '/pagesSubA/longArticleComment/longArticleComment?data=' + JSON.stringify(this.thisLongArticle)
				});
			},
			// 跳转到作者主页，userID 由根据文章 ID 查询文章返回值提供
			goToPersonPublic() {
				uni.navigateTo({
					url: '../personpublic/personpublic?userId=' + this.thisLongArticle.userId
				});
			},

			swLikeLongArticle() { //点赞主文章功能三个函数
				if (this.thisLongArticle.isLike) {
					this.unLikeArticle();
				} else {
					this.likeArticle();
				}
				// 	this.thisArticle.isLike = !this.thisArticle.isLike;
				//
			},

			likeArticle() {
				console.log('点赞文章');
				var that = this;
				uni.request({
					method: 'POST',
					url: that.$serverUrl + '/social/userLike',
					data: {
						targetType: "LONGARTICLE",
						userId: that.userInfo.id,
						targetId: that.thisLongArticle.id,
					},
					header: {
						'content-type': 'application/x-www-form-urlencoded'
					},
					success: res => {
						console.log(res);
						that.thisLongArticle.isLike = !that.thisLongArticle.isLike;
						that.thisLongArticle.likeNum++;
						// this.$emit('swLikeArticleSignal', true);
					}
				});
			},
			unLikeArticle() {
				console.log('取消点赞文章');
				var that = this;
				uni.request({
					method: 'POST',
					url: that.$serverUrl + '/social/userUnLike',
					data: {
						targetType: "LONGARTICLE",
						userId: that.userInfo.id,
						targetId: that.thisLongArticle.id,
					},
					header: {
						'content-type': 'application/x-www-form-urlencoded'
					},
					success: res => {
						console.log(res);
						that.thisLongArticle.isLike = !that.thisLongArticle.isLike;
						that.thisLongArticle.likeNum--;
						//this.$emit('swLikeArticleSignal', false);
					}
				});
			}, //点赞主文章函数结束

			toggleCollect() {
				if (this.thisLongArticle.isCollect) {
					this.unCollectArticle();
				} else {
					this.collectArticle();
				}
			},
			collectArticle() {
				console.log('收藏文章');
				var that = this;
				uni.request({
					method: 'POST',
					url: that.$serverUrl + '/social/userCollect',
					data: {
						targetType: "LONGARTICLE",
						userId: that.userInfo.id,
						targetId: that.thisLongArticle.id,
					},
					header: {
						'content-type': 'application/x-www-form-urlencoded'
					},
					success: res => {
						console.log(res);
						that.thisLongArticle.isCollect = !that.thisLongArticle.isCollect;
						//this.$emit('swLikeArticleSignal', false);
						uni.showToast({
							title: '收藏成功',
							icon: 'success',
							duration: 1000,
						});
					}
				});
			},
			unCollectArticle() {
				console.log('取消收藏文章');
				var that = this;
				uni.request({
					method: 'POST',
					url: that.$serverUrl + '/social/userUncollect',
					data: {
						targetType: "LONGARTICLE",
						userId: that.userInfo.id,
						targetId: that.thisLongArticle.id,
					},
					header: {
						'content-type': 'application/x-www-form-urlencoded'
					},
					success: res => {
						console.log(res);
						that.thisLongArticle.isCollect = !that.thisLongArticle.isCollect;
						uni.showToast({
							title: '取消收藏成功',
							icon: 'success',
							duration: 1000,
						});
					}
				});
			},
			loadLongArticle() {
				var that = this;
				uni.request({
					url: that.$serverUrl + '/longarticle/getArticleById',
					method: 'POST',
					header: {
						'content-type': 'application/x-www-form-urlencoded'
					},
					data: {
						articleId: that.longArticleId,
						userId: that.userInfo.id,
					},
					success: res => {
						if (res.data.status == 200) {
							this.thisLongArticle = res.data.data;
							this.savedArticleContent = nq_parse.parseMedia(res.data.data.content).data;
							console.log(this.thisLongArticle);
							console.log("savedArticleContent ===== " + this.savedArticleContent);
						}
					}
				});
			},
			showUnfinishToast(){
				uni.showToast({
					title: '代码同学正玩命开发中...',
					icon: 'none',
					duration: 1500
				})
			}
		} //method
	};
</script>

<style scoped>
	page{
		background: #fcfcfc;
	}
	
	.detail-page {
		width: calc(100% - 32px);
		margin: auto;
		background: #fcfcfc;
	}

	.detail-article {
		width: 100%;
		background: #fcfcfc;
	}

	.longArticleDetail-title {
		width: 100%;
		color: #4a4a4a;
		font-size: 24px;
		line-height: 28px;
		/* margin: auto; */
		font-weight: 550;
		word-break: break-all;
		word-wrap: break-word;
		margin-top: 16px;
		margin-bottom: 15px;
		text-align: justify;

	}

	.yuanchuang {
		text-indent: 20px;
		position: relative;
	}

	.yuanchuang::after {
		content: "";
		position: absolute;
		background-size: 22px 22px;
		width: 22px;
		height: 22px;
		left: 0;
		top: 0;
	}

	.longArticleDetail-subTitle {
		width: 100%;
		color: #4a4a4a;
		font-size: 16px;
		line-height: 21px;
		/* margin: auto; */
		font-weight: 550;
		word-break: break-all;
		word-wrap: break-word;
		margin-top: 0px;
		margin-bottom: 15px;
		max-height: 42px;
		text-align: justify;
	}



	.author-info-bar {
		margin-top: 5px;
		margin-bottom: 20px;
		height: 32px;
		width: 100%;
		position: relative;
	}

	.touxiang {
		width: 32px;
		height: 32px;
		border-radius: 50%;
		vertical-align: bottom;
	}

	.name {
		font-size: 14px;
		/* height: 16px; */
		min-width: 96px;
		font-weight: 500;
		height: 16px;
		line-height: 16px;
		margin: 8px 12px;
		color: rgba(53, 53, 53, 1);
	}

	.time {
		text-align: left;
		font-size: 12px;
		color: #9b9b9b;
		line-height: 14px;
		height: 14px;
		width: 130px;
		margin: 10px 0;
		display: inline-block;
	}

	.menu-bar {
		position: fixed;
		width: calc(750upx - 32px);
		bottom: 24px;
		left: 16px;
		height: 36px;
		background: rgba(252, 252, 252, 1);
		box-shadow: 0px 0px 4px rgba(121, 121, 121, 0.42);
		border-radius: 8px;
		z-index: 20;
	}

	.menu-bar image {
		width: 16px;
		height: 16px;
		vertical-align: bottom;
	}

	.like,
	.comment,
	.share,
	.collect {
		width: 31px;
		text-align: right;
		padding: 12px calc((100% - 124px)/8);
		heigh: 12px;
		line-height: 16px;
		color: rgba(136, 136, 136, 1);
		display: inline-flex;
		align-items: center;
		justify-content: space-around;
		font-size: 14px;
		vertical-align: bottom;
		position: relative;
	}

	.like::after,
	.comment::after,
	.collect::after {
		content: "";
		width: 1px;
		height: 15px;
		position: absolute;
		right: -1px;
		bottom: 11px;
		background-color: #ECECEC;
	}

	.liked {
		width: 31px;
		text-align: right;
		padding: 12px calc((100% - 124px)/8);
		heigh: 12px;
		line-height: 16px;
		color: #dba503;
		display: inline-flex;
		align-items: center;
		justify-content: space-around;
		font-size: 14px;
		vertical-align: bottom;
		position: relative;
	}
</style>
