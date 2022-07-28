<template>
	<view class="swiper-date">
		<view class="date-botton" display-multiple-items="7" v-for="item in dateList" :key = "item.date">
			<text>{{item.date}}</text>
		</view>
	</view>
</template>

<script>
	export default {
		data() {
			return {
				dateList:[
					{
						date: 15,
						schedule: {},
					},
					{
						date: 16,
						schedule: {},
					},
					{
						date: 17,
						schedule: {},
					},
					{
						date: 18,
						schedule: {},
					},
					{
						date: 19,
						schedule: {},
					},
					{
						date: 20,
						schedule: {},
					},
					{
						date: 21,
						schedule: {},
					},
					{
						date: 22,
						schedule: {},
					},
					{
						date: 23,
						schedule: {},
					},
					{
						date: 24,
						schedule: {},
					},
					{
						date: 25,
						schedule: {},
					},
					{
						date: 26,
						schedule: {},
					},
					{
						date: 27,
						schedule: {},
					},
				]
			}
		},
		methods: {
			
		}
	}
</script>

<style>
	.swiper-date {
		margin: 20upx 0 20upx 0;
	}
	.date-botton {
		display: inline-block;
		text-align: center;
		border: 1px solid #b1b1b1;
		border-radius: 50%;
		margin: 40upx 20upx 0 20upx;
		font-weight: bold;
		font-size: 14px;
		height: 30px;
		width: 30px;
		line-height: 30px;
	}
</style>
