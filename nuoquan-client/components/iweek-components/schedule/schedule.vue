<template>
	<view>
		<view class="calendar">
			<picker class="picker faculty-picker" mode="selector" :range="facultyList" range-key="name" @change="facultyChange">
				<view>{{beforeFaculty?beforeFaculty:'Faculty'}}</view>
			</picker>
			<picker class="picker degree-picker" mode="selector" :range="degreeList" range-key="name" @change="degreeChange">
				<view>{{beforeDegree?beforeDegree:'Degree'}}</view>
			</picker>
			<swiper-date></swiper-date>
			<schedule-card></schedule-card>
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
						name: 'UG-Domenistic',
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
		// onShow:function(e) {
			// console.log('Onload'),
			
			// uni.getStorage({
			// 	key: 'facultyId',
			// 	success: (res) => {
			// 		console.log(res)
			// 	}
			// })
			// var value = uni.getStorageSync('facultyId'),
			// console.log(value)
		// },
		methods: {
			facultyChange(e){
				const index = e.target.value
				this.beforeFaculty = this.facultyList[index].name
				this.facultyId = this.facultyList[index].id
				uni.setStorage({
					key: 'facultyId',
					data: this.facultyId,
					success: (res) => {
						console.log(res)
					},
					fail: (err) => {
						console.log(err)
					}
				})
			},
			degreeChange(e){
				const index2 = e.target.value
				this.beforeDegree = this.degreeList[index2].name
				this.degreeId = this.degreeList[index2].id
				uid.setStorage('degreeId',this.degreeId)
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
