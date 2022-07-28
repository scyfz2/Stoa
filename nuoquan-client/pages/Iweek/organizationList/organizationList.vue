<!-- 
	Date: July 23, 2022
	Author: Zhuoli
	Description: 校内组织
 -->
<template>
	<view id="organizationList-container">
		<uni-nav-bar class="navigationBar" 
		:style="{ height: this.getnavbarHeight() + 'px'}"  
		backgroundColor="#f9c406"
		color="#fcfcfc"
		:showLeftIcon="true" 
		:isNavHome="isNavHome"
		:left-text="lang.back" 
		:title="lang.organizationList" 
		:height="navbarHeight"></uni-nav-bar>
		<view :style="{ height: navbarHeight + 'px' }"></view>
		<!-- safearea -->
		<view style="height: 30px;"></view>
		<organizationCard v-for="(item,index) in organizationList" :detail="organizationList[index]"></organizationCard>
	</view>
</template>

<script>
	import uniNavBar from '@/components/uni-nav-bar/uni-nav-bar.vue';
	import organizationCard from '@/components/iweek-components/organizationCard/organizationCard/organizationCard.vue'
	import {
		mapState,
		mapMutations
	} from 'vuex';
	export default {
		components: {
			uniNavBar,
			organizationCard
		},
		computed: {
			...mapState(['lang'])
		},
		data() {
			return {
				navbarHeight: 0 ,//一次性储存 navbarheight
				
				
				page:1,
				pagesize:0,
				currentPage: 1,
				thisUserInfo: '',
				organizationList:[],
				
				userId:'oDwsO5A-1gkeGk_1dVrslR6HYVvA',
				// organizationList:[
				// {
				// 	icon:'/static/icon/iweek/society.png',
				// 	title:'青协',
				// 	brief:"sassadsadafsffsfsdsfsdhfhdfhsdgfsdhsjdfhhfsjsdfgdfshdfsbsfjhfsdbfhsbfhsfbsfhbshfsvfshsfbsfhbssffasasaa333333",
				// 	activity:"11232425436547654765785685686877867",
				// 	department:"121354327nsjdsbdasdsadas",
				// }]
			}
		},
		onLoad() {
			this.navbarHeight = this.getnavbarHeight().bottom + 5;
			this.thisUserInfo = this.getGlobalUserInfo();
			this.getOrg(this.page);
		},
		methods: {
			getOrg: function(page){
				uni.showLoading({
						title: '加载中...'
				});
				var that = this;
				uni.request({
					// url:that.$serverUrl +'/organization/queryOrganizations',
					url:'https://localhost:8080' +'/organization/queryOrganizations',
					method: 'POST',
					data: {
						page: page,
						// userId:that.thisUserInfo.id,
						userId:that.userId,
						pageSize:that.pagesize,
					},
					header: {
						'content-type': 'application/x-www-form-urlencoded'
					},
					success: res => {
						uni.hideLoading();
						console.log(res);
						// 判断当前页是不是第一页，如果是第一页，那么设置showList为空
						if (page == 1) {
							that.organizationList=[];
						}
						this.$nextTick(() => {
							var newOrgList = res.data.data.rows;
							var oldOrgList = that.organizationList;
							that.organizationList = oldOrgList.concat(newOrgList);
							
							console.log(that.organizationList);
							that.currentPage = page;
						
						})
					},
					fail: res => {
						uni.hideLoading();
							
						console.log('index unirequest fail');
						console.log(res);
					}
				});
			}
		}
	}
</script>

<style>

</style>
