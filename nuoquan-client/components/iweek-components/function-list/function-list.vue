<!-- 
	Date: July 20, 2022
	Author: Yifei
	Description: I-week新生界面的四项功能，分别为：社团组织，我的课程，校园地图和吃喝玩乐
 -->
<template>
	<view class="function-list">
		<view class="functions" v-for="(item, index) in functionList" :key="index">
			<view>
				<image :src="item.icon" class="function-image"></image>
				<view class="text">
					{{lang.functionList[index]}}
				</view>
			</view>
		</view>
	</view>
</template>

<script>
	import { mapState, mapMutations } from 'vuex';
	export default {
		data(){
			return {
				functionList:''
			};
		},
		computed: {
			...mapState(['myMsgCount','lang'])
		},
		created() {
			this.functionList = [
				{
					type: 0,
					icon: '/static/icon/iweek/society.png',
					name: '社团组织',
					url: '/pages/iweek/society'
				},
				{
					type: 0,
					icon: '/static/icon/iweek/ucourse.png',
					name: '我的课程',
					appid: '',
					url: 'appiducourse'
				},
				{
					type: 0,
					icon: '/static/icon/iweek/map.png',
					name: '校园地图',
					appid: '',
					url: 'appidunncmap'
				},
				{
					type: 0,
					icon: '/static/icon/iweek/eat.png',
					name: '吃喝玩乐',
					url: '/pages/iweek/eat'
				}
			]
		},
		methods: {
			onClick(e){
				console.log(e.name)
				// 若点击社团组织或吃喝玩乐，在小程序内跳转
				// 若点击map或course，根据appid和path跳转至对应小程序
				if (e.name == '我的课程' || e.name == '校园地图'){
					uni.navigateToMiniProgram({
						appId: e.appid,
						path: e.url,
						envVersion:"release",
						success:res => {
							console.log("打开成功", res);
						},
						fail: err => {
							console.log(err);
						}
					})
				}
				else {
					uni.switchTab({
						url: e.url
					});
				}
			}
		}
	}
</script>

<style>
	.function-list {
		display: flex; 
		flex-direction: row; 
		flex-wrap: wrap; 
		margin: 0 5%;
	}
	.functions{
		width: 25%;
		margin-top: 16upx;
	}
	.function-image{
		width: 50px; 
		height: 50px;
		margin: 10% 25% 20% 25%;
		border: 1px solid #b1b1b1;
		border-radius: 100upx;
	}
	.text {
		text-align: center;
		font-size: 14px;
		margin-bottom: 15%;
	}
</style>
