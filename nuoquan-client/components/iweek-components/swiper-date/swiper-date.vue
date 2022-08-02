<template>
	<view class="swiper-date">
		<view class="unselected" v-for="(item,index) in dateList" :key = "index" :class="{'selected': nowIndex === index }" @click="getDate(item);changeIndex(index)">
			<text>{{item.date}}</text>
		</view>
	</view>
</template>

<script>
	export default {
		data() {
			return {
				index: 0,
				nowIndex: 0,
				// startDate 控制在0-6区间内
				startDate: 0,
				date:'',
				dateList:[
					{
						date: 15,
						selected: false,
					},
					{
						date: 16,
						selected: false,
					},
					{
						date: 17,
						selected: false,
					},
					{
						date: 18,
						selected: false,
					},
					{
						date: 19,
						selected: false,
					},
					{
						date: 20,
						selected: false,
					},
					{
						date: 21,
						selected: false,
					},
					{
						date: 22,
						selected: false,
					},
					{
						date: 23,
						selected: false,
					},
					{
						date: 24,
						selected: false,
					},
					{
						date: 25,
						selected: false,
					},
					{
						date: 26,
						selected: false,
					},
					{
						date: 27,
						selected: false,
					},
					{
						date: 28,
						selected: false,
					}
				]
			}
		},
		onLoad(){
			this.dayList = common.weekDate().dayList;
		},
		methods: {
			getDate(e){
				// debugger
				// console.log(e.date)
				this.date = e.date
				this.$emit("date",this.date)
			},
			changeIndex(e){
				console.log('change index')
				this.nowIndex = e
			}
		}
	}
</script>

<style scoped>
	.swiper-date {
		margin: 20upx 0 40upx 0;
	}
	.unselected {
		display: inline-block;
		text-align: center;
		border: 1upx solid #ECECEC;
		border-radius: 50%;
		margin: 40upx 20upx 0 20upx;
		font-weight: bold;
		font-size: 14px;
		height: 30px;
		width: 30px;
		line-height: 30px;
		color: #000000;
		background-color: #FFFFFF;
	}
	.selected {
		display: inline-block;
		text-align: center;
		border: 1upx #b1b1b1;
		border-radius: 50%;
		margin: 40upx 20upx 0 20upx;
		font-weight: bold;
		font-size: 14px;
		height: 30px;
		width: 30px;
		line-height: 30px;
		color: #FFFFFF;
		background-color: #f9c466;
	}
</style>
