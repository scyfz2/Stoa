<!-- 
	Date: July 23, 2022
	Author: Zhuoli
	Description: 组织详情
 -->
<template>
	<view id="organizationDetail-container">
		<uni-nav-bar class="navigationBar" 
		:style="{ height: this.getnavbarHeight() + 'px'}"  
		backgroundColor="#f9c406"
		color="#fcfcfc"
		:showLeftIcon="true" 
		:isNavHome="isNavHome"
		:left-text="lang.back" 
		:title="lang.organizationDetail" 
		:height="navbarHeight"></uni-nav-bar>
		<view :style="{ height: navbarHeight + 'px' }"></view>
		<!-- safearea -->
		<view style="height: 20px;"></view>
		<view style="display: flex;">
			<image :src="pathFilter(detail.logoPath)" mode="aspectFill" class="orgImage"></image>
			<view class="orgTitle">{{detail.name}}</view>
		</view>
		
		<view class="orgContentBox">
			<view v-for="(item,index) in showList" class="orgIntro">
				<view style="font-size: 17px;font-weight: bold;">{{item}}</view>
				<view class="orgDetail">
					<view v-if="index==0">{{detail.intro}}</view>
					<view v-else-if="index==1">{{detail.activityIntro}}</view>
					<view v-else>{{detail.division}}</view>
				</view>
			</view>
			<!-- 招新推文以及介绍的二维码 -->
			<view class="orgQRBox" v-if="detail.imgList">
				<view v-if="detail.imgList[0]">
					<image :src="pathFilter(detail.imgList[0].imagePath)" mode="aspectFill" class="orgQR"></image>
				</view>
				<view v-if="detail.imgList[1]">
					<image :src="pathFilter(detail.imgList[1].imagePath)" mode="aspectFill" class="orgQR"></image>
				</view></view>
		</view>
	</view>
</template>

<script>
	import uniNavBar from '@/components/uni-nav-bar/uni-nav-bar.vue';
	import {
		mapState,
		mapMutations
	} from 'vuex';
	export default {
		components: {
			uniNavBar,
		},
		computed: {
			...mapState(['lang'])
		},
		data() {
			return {
				navbarHeight: 0 ,//一次性储存 navbarheight
				detail: '',
				

				showList:['组织简介','主要活动','部门组成']
			}
		},
		onLoad:function (option) {
			this.navbarHeight = this.getnavbarHeight().bottom + 5;
			
			const temp = JSON.parse(decodeURIComponent(option.detail));
			this.detail = temp;
		},
		methods: {
			
		}
	}
</script>

<style>
	.orgImage{
		width: 80px;
		height: 80px;
		border: 0.5px solid gray;
		border-radius: 50%;
		margin-left: 20px;
	}
	.orgTitle{
		margin-top: 35px;
		margin-left: 20px;
		font-size: 24px;
		font-weight:bold;
		line-height: 25px;
	}
	
	.orgContentBox{
		width: 90%;
		margin:15px 5% 5px 5%;
		border-radius: 12px;
		border: 1.5px solid gray;
	}
	.orgIntro{
		margin: 10px 10px 20px 10px;
	}
	.orgDetail{
		margin-top: 5px;
		font-size: 14px;
		line-height: 17px;
		word-wrap: break-word;
	}
	
	.orgQRBox{
		display:flex;
		align-items:center;
		justify-content: space-evenly;
		margin-top: 10px;
		margin-bottom: 10px;
	}
	.orgQR{
		width: 90px;
		height: 90px;
	}
</style>
