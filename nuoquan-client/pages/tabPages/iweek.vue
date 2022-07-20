<template>
	<view class="iweek">
		<swiper class="top-swiper" :indicator-dots="true" :autoplay="true" :interval="3000" :duration="1000">
			<swiper-item v-for="(item,index) in swipers" :key="index">
				<image :src="item"></image>
			</swiper-item>
		</swiper>
	
		<tab-bar :current="1"></tab-bar>
	</view>
</template>

<script>
	import tabBar from '@/components/nq-tabbar/nq-tabbar.vue';
	import { mapState, mapMutations } from 'vuex';
	export default {
		data(){
			return{
				title: 'Hello',
				swipers:[]
			}
		},
		onLoad(){
			this.swipers=['https://nuoquan-1308006370.cos.ap-shanghai.myqcloud.com/nqprod/ad/hq.jpeg'						];
	},
	methods:{
		
	}
	}
</script>

<style>
	.top-swiper {
		height: 500upx;
	}
</style>
