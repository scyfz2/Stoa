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
				date:'',
				curDate:'',
				dateList:[
					{
						date: 13,
						selected: false,
					},
					{
						date: 14,
						selected: false,
					},
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
					}
				]
			}
		},
		mounted() {
			this.getCurrentDate();
			if (this.curDate < 13){
				this.getDate(this.dateList[0]);
				this.changeIndex(0);
			}else if(this.curDate<=26){
					this.getDate(this.dateList[this.curDate-13]);
					this.changeIndex(this.curDate-13);
			}else {
				this.getDate(this.dateList[13]);
				this.changeIndex(13)
			}
		},
		methods: {
			getDate(e){
				this.date = e.date;
				this.$emit("date",this.date);
			},
			changeIndex(e){
				this.nowIndex = e
			},
			getCurrentDate(){
				var d = new Date();
				// this.curDate = 27;
				this.curDate = d.getDate();
				console.log(this.curDate);
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
		/* border: 1upx #b1b1b1; */
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
