<!-- 
	Author: Guetta
	Latest update: 2020年8月24日15点33分
	Intro: 公众号表单页面
	备注:
 -->
 
<template>
	<view class="officialAccountList-container" >
		<!-- 导航栏 -->
		<uni-nav-bar class="navigationBar" :left-text="lang.back" :title="lang.officialAccountList" :showLeftIcon="true" :isNavHome="isNavHome"
		 :height="navbarHeight"></uni-nav-bar>
		<view :style="{ height: navbarHeight + 'px' }" style="width: 100%;"></view>
		<view class="newsCard" :style="{width: screenWidth - 32 - 24 + 'px'}" v-for="(article,index) in articleListOA" :key="index" @tap=goToAdWebPage(article.isJump,article.id,article.link)>
			<!-- 用户信息行 -->
			<view class="userLine hor_center">
				<image :src="pathFilter(article.faceImg)" class="touxiang"></image>
				<view class="name">{{ article.nickname }}</view>
				<view class="time" :style="timeLeft">{{timeDeal(article.createDate)}}</view>
			</view>
			<!-- 无封面图，判断有无图片 -->
			<view v-if="article.coverImage == null" class="content_type_one">
				<!-- 判断是否含有图片 -->
				<text :style="{width: article.withPic ? 'calc(100% - 93px)' : '100%'}">{{article.title}}</text>
				<image v-if="localParse(article.content).firstImage.status" :src="localParse(article.content).firstImage.url" mode="aspectFill"></image>
			</view>
			<!-- 有封面图 -->
			<view v-else :style="{width: screenWidth - 32 + 'px'}" class="content_type_two">
				<image :src="pathFilter(article.coverImage)" mode="aspectFill"></image>
				<text>{{article.title}}</text>
			</view>
		</view>
		
	</view>
</template>

<script>
	import uniNavBar from '@/components/uni-nav-bar/uni-nav-bar.vue';
	import {
		mapState,
		mapMutations
	} from 'vuex';
	import nq_parse from '../../pagesSubA/longArticleDetail/parse.js';
	
	export default {
		components: {
			uniNavBar,
		},
		data() {
			return {
				navbarHeight: 0, //一次性储存 navbarheight
				screenWidth: 375,
				parseReturn:"",
				
				currentPageOA: 1, // 当前分页
				totalPageOA: 1, // 总页数
				articleListOA:[],
					// 公众号文章
				//{ 	accountName: "公众号名字示例",
				// 	author: "作者名字示例",
				// 	profilePic: '../../static/AD/20200524AD1.jpg',
				// 	title: "文章标题示例二十个字文章标题示例二十个字",
				// 	subTitle: "文章标题示例二十个字文章标题示例二十个字",
				// 	content: "文章内容示例三十个字文章内容示例三十个字文章内容示例三十个字",
				// 	postTime: "2020-12-31 23:59",
				// 	withCover: true,
				// 	withPic: true,
				// 	coverPic: '../../static/AD/20200524AD1.jpg',
				// },{
				// 	accountName: "公众号名字示例",
				// 	author: "作者名字示例",
				// 	profilePic: '../../static/AD/20200524AD1.jpg',
				// 	title: "文章标题示例二十个字文章标题示例二十个字",
				// 	subTitle: "文章标题示例二十个字文章标题示例二十个字",
				// 	content: "文章内容示例三十个字文章内容示例三十个字文章内容示例三十个字",
				// 	postTime: "2020-12-31 23:59",
				// 	withCover: false,
				// 	withPic: false,
				// 	coverPic: '../../static/AD/20200524AD1.jpg',
				// },{
				// 	accountName: "公众号名字示例",
				// 	author: "作者名字示例",
				// 	profilePic: '../../static/AD/20200524AD1.jpg',
				// 	title: "文章标题示例二十个字文章标题示例二十个字",
				// 	subTitle: "文章标题示例二十个字文章标题示例二十个字",
				// 	content: "文章内容示例三十个字文章内容示例三十个字文章内容示例三十个字",
				// 	postTime: "2020-12-31 23:59",
				// 	withCover: false,
				// 	withPic: true,
				// 	coverPic: '../../static/AD/20200524AD1.jpg',
				// }],
			}
		},
		computed: {
			...mapState(['lang'])
		},
		onLoad() {
			var that = this;
			var userInfo = that.getGlobalUserInfo();
			if (that.isNull(userInfo)) {
				uni.redirectTo({
					url: '../signin/signin'
				});
				return;
			} else {
				that.userInfo = userInfo; // 刷去默认值(若有)
			}
			
			// 一次性储存 navbar 高度
			that.navbarHeight = that.getnavbarHeight().bottom + 5;
			//获取屏幕宽度
			uni.getSystemInfo({
				success(res) {
					that.screenWidth = res.screenWidth
				}
			})
			
			that.getArticlesFromOA(1, that.userInfo.id);
		},
		onReachBottom() {
		    this.loadMoreOA();
		},
		methods: {
			/**
			 * 获取公众号文章
			 * @param {Object} userId
			 */
			getArticlesFromOA: function(page, userId){
				var that = this;
				uni.request({
					url: this.$serverUrl + '/longarticle/getArticlesFromOA',
					method: 'POST',
					data: {
						page: page,
						pageSize: 8,
						userId: userId,
					},
					header: {
						'content-type': 'application/x-www-form-urlencoded'
					},
					success: res => {
						if(res.data.status == 200){
							// console.log(this.articleListOA);
							// 判断当前页是不是第一页，如果是第一页，那么设置 列表 为空
							if (page == 1) {
								this.articleListOA = [];
							}
							that.$nextTick(() => {
								var newList = res.data.data.rows;
								var oldList = that.articleListOA;
								that.articleListOA = oldList.concat(newList);
								that.currentPageOA = page;
								that.totalPageOA = res.data.data.total;
							});
							console.log(that.articleListOA);
							console.log(res.data.data.rows);
						}
					},
					fail: res => {
					
					}
				});
			},
			// 公众号板块，加载更多
			loadMoreOA: function() {
				var currentPage = this.currentPageOA;
				console.log(currentPage);
				var totalPage = this.totalPageOA;
				console.log(totalPage);
				// 判断当前页数和总页数是否相等
				if (currentPage == totalPage) {
					// this.showLongArticles(1);
					uni.showToast({
						title: '没有更多内容了',
						icon: 'none',
						duration: 1000
					});
				} else {
					var page = currentPage + 1;
					this.getArticlesFromOA(page, this.userInfo.id);
				}
			},
			localParse(unParsed) {//本地解析，引入的js在HTML似乎没法直接用,没有时间琢磨的 --yaoyao
				var result = nq_parse.parsePureText(unParsed);
				result.firstImage.url = this.pathFilter(result.firstImage.url);
				// console.log(result);
				return result;//二次处理地址，v-for循环地址无法通过本地化二次处理
			},
			goToAdWebPage(isJump,id,link){
				if (isJump == 0) { //0，跳转详情
					uni.navigateTo({
						url: '../../pagesSubA/longArticleDetail/longArticleDetail?data=' + id,
					});
				} else if(isJump == 1){
					var encodeData = encodeURIComponent(link);
					uni.navigateTo({
						url: '/pages/adWebPage/adWebPage?url=' + encodeData,
					})
				}
			}
		}
	}
</script>

<style>
	.officialAccountList-container{
		background-color: #fafafa;
	}
	
	.newsCard{
		padding: 0 12px;
		margin-top: 13px;
		margin-left: 16px;
		background:rgba(255,255,255,1);
		box-shadow: 0px 3px 5px rgba(0,0,0,0.08);
		opacity:1;
		border-radius:5px;
	}
	
	.userLine {
		position: relative;
		width: 100%;
		height: 54px;
	}
	
	.touxiang {
		position: absolute;
		/* left: 4.53%; */
		left: 0px;
		vertical-align: middle;
		width:44px;
		height:44px;
		border-radius:50%;
		opacity:1;
	}
	/* .touxiang::after{
			content: "";
			position: absolute;
			height:30px;
			width:30px;
			left:-5px;
			top:0;
		} */
	
	.name {
		position: absolute;
		left: 55px;
		font-family:Source Han Sans CN;
		font-weight:500;
		font-size:17px;
		line-height:25px;
		color:rgba(136,136,136,1);
		opacity:1;
		/* max-width: 24%; */
		white-space: nowrap;
		overflow: hidden;
		text-overflow: ellipsis;
	}
	
	.time {
		position: absolute;
		right: 0px;
		height:18px;
		font-size:12px;
		font-family:Source Han Sans CN;
		font-weight:400;
		line-height:18px;
		color:rgba(136,136,136,1);
		opacity:1;
	}
	
	.content_type_one{
		position: relative;
		height: 62px;
		display: flex;
		width: calc(100% - 22px);
		padding: 7px 11px 10px 11px;
	}
	
	.content_type_two{
		position: relative;
		height: 200px;
		width: ;
	}
	
	.content_type_one text{
		position: absolute;
		left: 0;
		color:rgba(74,74,74,1);
	}
	
	.content_type_two text{
		position: absolute;
		border-bottom-left-radius:5px;
		border-bottom-right-radius:5px;
		bottom: 0;
		width: calc(100% - 24px);
		left: -12px;
		z-index: 20;
		background: linear-gradient(0deg, rgba(0, 0, 0, 0.16) 0%, rgba(255,255,255,0.16) 100%);
		padding: 0 12px 0 12px;
		height:52px;
		font-size:17px;
		font-family:Source Han Sans CN;
		font-weight:400;
		line-height:25px;
		color:rgba(255,255,255,1);
		opacity:1;
	}
	
	.content_type_one .content_type_two text{
		font-size:17px;
		font-family:Source Han Sans CN;
		font-weight:400;
		line-height:25px;
		opacity:1;
		text-overflow: ellipsis;
		/**文字隐藏后添加省略号*/
		display: -webkit-box;
		-webkit-box-orient: vertical;
		-webkit-line-clamp: 2;
		overflow: hidden;
	}
	
	.content_type_one image{
		position: absolute;
		right: 0;
		width: 62px;
		height: 62px;
	}
	
	.content_type_two image{
		position: absolute;
		left: -12px;
		z-index: 10;
		bottom: 0;
		height: 200px;
		width: 100%;
		border-bottom-left-radius:5px;
		border-bottom-right-radius:5px;
	}
	
</style>
