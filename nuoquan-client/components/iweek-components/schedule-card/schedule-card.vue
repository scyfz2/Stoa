<!-- 
	I-week日程预览卡片
	Author: Yifei
	Date: July 25, 2022
 -->
<template>
	<view class="scheduleCard">
		<view class="placeholder">
			<view class="topic">
				<text>Early University Registration</text>
			</view>
			<view class="time">
				<text>08:00-17:30</text>
			</view>
			<view class="location">
				<text>D.H Lawrence Auditorium Hall</text>
			</view>
		</view>
	</view>
</template>

<script>
	export default {
		data() {
			return {
				
			}
		},
		methods: {
			
		}
	}
</script>

<style>
	.scheduleCard {
		width: 90%;
		height: 100upx;
		border: 1px solid #b1b1b1;
		border-radius: 10px;
		margin-left: 4%;
		background-color: rgba(255,255,255,1);
		opacity: 1;
		margin-top: 20upx;
		margin-bottom: 20upx;
	}
	
	.placeholder {
		position: fixed;
		background-size: 3%;
		background-color: #f9c466;
		width: 3%;
		height: 100upx;
		border-radius:100px 0 0 100px;
		margin-bottom: 0;
	}
	
	.topic {
		font-size: 12px;
		font-weight: bold;
		width: 400upx;
		margin-left: 20px;
		margin-top: 10upx;
		
		/**文字隐藏后添加省略号*/
		display: -webkit-box;
		-webkit-box-orient: vertical;
		-webkit-line-clamp: 1;
		overflow: hidden;
	}
	.time {
		width: 300upx;
		margin-left: 20px;
		margin-top: 15upx;
		
		/**文字隐藏后添加省略号*/
		/* display: -webkit-box;
		-webkit-box-orient: vertical;
		-webkit-line-clamp: 1;
		overflow: hidden; */
	}
	.location {
		width: 400upx;
		margin-left: 130px;
		margin-top: -35upx;
		
		/**文字隐藏后添加省略号*/
		display: -webkit-box;
		-webkit-box-orient: vertical;
		-webkit-line-clamp: 1;
		overflow: hidden;
	}
</style>
