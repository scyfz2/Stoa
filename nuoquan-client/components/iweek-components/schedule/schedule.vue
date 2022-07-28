<template>
	<view>
		<view class="calendar">
			<picker class="picker faculty-picker" mode="selector" :range="facultyList" range-key="name" @change="facultyChange">
				<view>{{beforeFaculty?beforeFaculty:'Faculty'}}</view>
			</picker>
			<picker class="picker degree-picker" mode="selector" :range="degreeList" range-key="name" @change="degreeChange">
				<view>{{beforeDegree?beforeDegree:'Degree'}}</view>
			</picker>
			<swiper-date @date="getEmitDate"></swiper-date>
			<schedule-card v-for="(item,index) in showList" :key = "index"></schedule-card>
			<view class="bottom-placeholder"></view>
		</view>
	</view>
</template>

<script>
	import swiperDate from '../swiper-date/swiper-date.vue';
	import scheduleCard from '../schedule-card/schedule-card.vue';
	import { mapState, mapMutations } from 'vuex';
	export default {
		components:{
		scheduleCard,
		swiperDate,
		},
		data() {
			return {
				userInfo:'',
				date:'',
				showList: [],
				beforeFaculty:'',
				facultyId:'',
				beforeDegree:'',
				degreeId:'',
				facultyList:[
					{
						id: 1,
						name: 'FoSE',
					},
					{
						id: 2,
						name: 'FoB',
					},
					{
						id: 3,
						name: 'FHSS',
					}
				],
				degreeList:[
					{
						id: 1,
						name: 'UG-Domestic',
					},
					{
						id:2,
						name:'UG-SPP',
					},
					{
						id:3,
						name:'PGT',
					},
					{
						id:4,
						name:'PGR'
					}
				]
			}
		},
		onLoad() {
			var userInfo = this.getGlobalUserInfo();
			this.userInfo = userInfo;
		},
		methods: {
			checkSchdule(){
				var that = this;
				uni.request({
					url: that.$serverUrl + '/eventsCalendar/queryEventsCalender',
					method: 'POST',
					data: {
						userId: that.userInfo.id,
						// page 和 pagesize写成静态的 一次性加载出来
						page: 1,
						pageSize: 20,
						
						targetDate:this.date,
						faculty:this.facultyId,
						degree:this.degreeId,
					},
					header: {
						'content-type': 'application/x-www-form-urlencoded'
					},
					success: res=> {
						if (page == 1) {
							that.showList = [];
						}
						this.$nextTick(() =>{
							showList = res.data.data.rows;
						})
					},
					fail: res => {
						console.log(res);
					}
				});
			},
			
			facultyChange(e){
				const index = e.target.value
				this.beforeFaculty = this.facultyList[index].name
				this.facultyId = this.facultyList[index].id
				// uni.setStorage({
				// 	key: 'facultyId',
				// 	data: this.facultyId,
				// 	success: (res) => {
				// 		console.log(res)
				// 	},
				// 	fail: (err) => {
				// 		console.log(err)
				// 	}
				// })
				this.checkSchdule()
			},
			degreeChange(e){
				const index2 = e.target.value
				this.beforeDegree = this.degreeList[index2].name
				this.degreeId = this.degreeList[index2].id
				// uid.setStorage('degreeId',this.degreeId)
				this.checkSchdule()
			},
			getEmitDate(data){
				this.date = data
				console.log(data)
				this.checkSchdule()
			}
		}
	}
</script>

<style>
	.picker{
		border-radius: 10rpx;
		background-color: #f2f2fc;
		padding: 0 30rpx;
	}
	.faculty-picker {
		position: fixed;
		margin-left: 180px;
		margin-top: -25px;
	}
	.degree-picker {
		position: fixed;
		margin-left: 280px;
		margin-top: -25px;
		width: 60px;
		text-align: center;
	}
	.bottom-placeholder {
		height: 50px;
	}
</style>
