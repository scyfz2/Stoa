<!-- 
	Author: Yifei
	Date: July 21, 2022
	Description: 新生I-week页面
 -->
<template>
	<view class="iweek">
		<schedule-detail @event="getEvent" :event="event"></schedule-detail>
		<!-- 导航栏 -->
		<uni-nav-bar class="navigationBar" :style="{height: this.getnavbarHeight() + 'px'}"
		:title="lang.iweek" :showLeftIcon="false"
		:height="this.getnavbarHeight().bottom + 5"></uni-nav-bar>
		<view :style="{ height: this.getnavbarHeight().bottom + 5 + 'px' }" style="width: 100%;"></view>
		
		<view class="topHalf">
		<!-- 轮播图 如果不想让他动的话就只放一张图 -->
		<swiper class="top-swiper" :indicator-dots="true" :autoplay="true" :interval="3000" :duration="1000">
			<swiper-item v-for="(item,index) in swipers" :key="index">
				<image :src="item"></image>
			</swiper-item>
		</swiper>
		
		<!-- 四项功能的图标及文字 -->
		<functionList class="functionList"></functionList>
		</view>
		
		<view class="downHalf">
			<view class="text_topic">
			{{lang.dailySchedule}}
			</view>
			<!-- <view class="second_line" @click="toggleIsEditFaculty"></view> -->
			<schedule class="schedule"></schedule>
		</view>
		
		<!-- 底部选项卡 -->
		<tab-bar :current="1"></tab-bar>
	</view>
</template>

<script>
	import scheduleDetail from '@/components/iweek-components/schedule-detail/schedule-detail.vue';
	import schedule from '@/components/iweek-components/schedule/schedule.vue';
	import functionList from '@/components/iweek-components/function-list/function-list.vue';
	import uniNavBar from '@/components/uni-nav-bar/uni-nav-bar.vue';
	import tabBar from '@/components/nq-tabbar/nq-tabbar.vue';
	import { mapState, mapMutations } from 'vuex';
	export default {
		components:{
			uniNavBar,
			tabBar,
			functionList,
			schedule,
			scheduleDetail
		},
		data(){
			return{
				event: {},
				title: 'Hello',
				swipers:[],
			}
		},
		computed:{
			...mapState(['lang'])
		},
		onLoad(){
			this.swipers=['https://nuoquan-1308006370.cos.ap-shanghai.myqcloud.com/nqprod/ad/hq.jpeg'];
			var userInfo = this.getGlobalUserInfo();
			if (this.isNull(userInfo)) {
				uni.redirectTo({
					url: '../signin/signin'
				});
				return;
			} else {
				this.userInfo = userInfo; // 刷去默认值(若有)
			}
		},
		methods:{
			getEvent(data){
				this.event = data
				console.log(this.event)
			}
		}
	}
</script>

<style>
	.top-swiper {
		/* margin-top: 10%; */
		margin-left: 5%;
		margin-right: 5%;
		height: 400upx;
	}
	
	.topHalf {
		background-color: #FFFFFF;
		margin-top: 8px;
	}
	
	.functionList {
		margin-top: 500upx;
		width: 100%;
		height: auto;
	}
	
	.downHalf {
		margin-top: 2%;
		background-color: #FFFFFF;
	}
	
	.text_topic {
		padding-top: 20upx;
		padding-left: 4%;
		font-size: 16px;
		font-weight: bold;
	}
</style>
