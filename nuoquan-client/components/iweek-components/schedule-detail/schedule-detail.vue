<template>
	<view v-if="show" class="scheduleContainer">
		<view class="scheduleBox">
			<view class="content">
				<view class="concrete_topic title">
					<text>{{event.title}}</text>
				</view>
				<view class="date">
					<view class="concrete_date title">
						<text>Date:</text>
					</view>
					<view class="concrete_date detail">
						<text>{{event.date}}</text>
					</view>
				</view>
				
				<view class="time">
					<view class="concrete_time title">
						<text>Time:</text>
					</view>
					<view class="concrete_time detail">
						<text>{{event.time}}</text>
					</view>
				</view>
				
				<view class="venue">
					<view class="concrete_venue title">
						<text>Venue:</text>
					</view>
					<view class="concrete_venue detail">
						<text>{{event.venue}}</text>
					</view>
				</view>
				
				<view class="target">
					<view class="concrete_target title">
						<text>Target Student:</text>
					</view>
					<view class="concrete_target detail">
						<text>{{event.faculty}} {{event.degree}}</text>
					</view>
				</view>
			</view>
			<view class="killIcon super_center" @click="killAd">
				<image src="../../../static/icon/delete.png" mode="aspectFit"></image>
			</view>
		</view>
		<view style="height: 100%;width: 100%;background-color: #000000;opacity: 0.5;"></view>
	</view>
</template>

<script>
	import { mapState, mapMutations } from 'vuex';
	export default {
		props:{
			event:{
				required: true,
				default:{},
			}
		},
		data() {
			return {
				show: false,
			}
		},
		computed: {
			...mapState(['lang'])
		},
		methods: {
			killAd(){
				this.show = !this.show;
			}	
		}
	}
</script>

<style>
	.scheduleContainer {
		height: 100%;
		width: 100%;
		position: fixed;
		/* 第五层 */
		z-index: 50; 
	}
	.scheduleBox {
		height: 700upx;
		width: 700upx;
		position: fixed;
		/* 第六层 */
		z-index: 60;
		background-color: white;
		opacity: 1;
		border-radius: 8px;
		top: 0;
		bottom: 0;
		left: 0;
		right: 0;
		margin-top: auto;
		margin-bottom: auto;
		margin-left: auto;
		margin-right: auto;
	}
	.killIcon{
		position: absolute;
		top: 2px;
		right: 2px;
		width: 28px;
		height: 28px;
		border-radius: 50%;
		background-color: #e6e6e6;
	}
	
	.killIcon image{
		width: 20px;
		height: 20px;
	}
	
	.content {
		margin: 40px 10px 0 10px;
	}
	
	.detail {
		margin-top: -18px;
		margin-left: 40px;
	}
	
	.concrete_topic {
		margin-bottom: 15px;
	}
	
	.title {
		font-weight: bold;
		font-size: 14px;
	}
	.time {
		margin-left: 0;
		margin-top: 20upx;
	}
	.concrete_venue.title {
		margin-top: 20upx;
	}
	.concrete_venue.detail {
		margin-left: 100upx;
	}
	.concrete_target.title {
		margin-top: 30upx;
	}
	.concrete_target.detail {
		margin-left: 230upx;
	}
	.concrete_type.title {
		margin-top: 30upx;
	}
	.concrete_type.detail {
		margin-left: 180upx;
	}
</style>
