<template>
	<view id="about-container">
		<!-- 导航栏 -->
		<uni-nav-bar class="navigationBar" 
		:style="{height: this.getnavbarHeight() + 'px'}" 
		:showLeftIcon="true" 
		:isNavHome="isNavHome" 
		:left-text="lang.back"
		:title="lang.about" 
		:height="this.getnavbarHeight().bottom + 5"></uni-nav-bar>
		<view :style="{height: this.getnavbarHeight().bottom + 5 + 'px'}"></view>
		<!--顶部名称部分-->
		<view class="top-picture">
			<!--logo-->
			<view><image class="logo-app" src="../../static/icon/logo_app.png" ></image></view>
			<!--Nottinghome-->
			<view class="company-name">Nottinghome</view>
			<!--版本-->
			<view class="version">{{versionNum}}</view>
		</view>
		<!--表单部分-->
		<view class="two-forms">
			<dropdown :lang="lang" :objList="data" v-for="(data,index) in dataList" :key="index"> </dropdown>
		</view>
		
		<!--底部图片部分-->
		<view class="bottom-picture"><image src="../../static/BG/signin_bottom.png" mode="aspectFit"></image></view>
	</view>
</template>

<script>
import uniNavBar from "@/components/uni-nav-bar/uni-nav-bar.vue";	
import { mapState, mapMutations } from 'vuex';
import dropdown from "@/components/dropdown.vue";
	
export default {
	components:{
		uniNavBar,
		dropdown
	},
	computed: {
		...mapState(['lang'])
	},
	data() {
		return {
			versionNum: this.version,
			isNavHome: getApp().globalData.isNavHome,//判断导航栏左侧是否显示home按钮
			dataList:[
				{
					name:'联系我们', 
					subtitle:'商务合作',
					body:'\“Share beyond Moments\” \n\
						Nottinghome 期待与校内各组织社团、学生团队、alumni 创业企业合作。\n \
						合作形式包括但不限于联名活动、官方账号入驻 Nottinghome、资源共享等。\n \
						欢迎更多朋友与我们一起为 UNNC 创造无限可能！\n \
						举报和反馈请联系：\n \
						wx: honggh-\n \
						\n \
						商务合作请联系：\n \
						wx: qian4223x\n \
						email: guetta.xia@outlook.com\n \
						\n \
						更多资讯，请关注官方微信公众号：\n \
						Jumboxtech,'
				},
				{
					name:'更新公告',
					subtitle:this.versionNum,
					body:'\ Nottinghome v2.0.0 已更新！\n \
						1. 升级：大部分页面 UI\n \
						2. 新增：探索板块，可以发文章啦\n \
						3. 优化部分使用体验\n \
						\n \
						'
				}
			],
		};
	},
};
</script>

<style>
page {
	width: 100%;
	height: 100%;
	overflow: scroll;
}
#about-container{
	width:100%;
	height:100%;
}
.top-picture{
	height:30%;
}
.two-forms{
	min-height:30%;
}
.bottom-picture {
	height:40%;
}
.logo-app {
	display: block;
	margin: auto;
	margin-top: 80upx;
	height: 144upx;
	width: 144upx;
}
.company-name {
	margin-top: 16upx;
	text-align: center;
	font-family: 'Source Han Sans CN';
	font-size: 34upx;
	color: #888888;
	opacity: 1;
}
.version {
	text-align: center;
	font-family: 'Source Han Sans CN';
	font-size: 34upx;
	color: #888888;
	opacity: 1;
	margin-top: 10upx;
}
.bottom-picture image {
	width: 100%;
}
</style>
