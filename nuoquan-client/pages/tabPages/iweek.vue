<!-- 
	Author: Yifei
	Date: Sept 21, 2022
	Description: 温肯页面，直接把社团组织的页面放进来
 -->

<template>
	<view id="organizationList-container">
		<uni-nav-bar class="navigationBar" 
		:style="{ height: this.getnavbarHeight() + 'px'}"  
		:showLeftIcon="false" 
		:title="lang.clubList" 
		:height="this.getnavbarHeight().bottom + 5"></uni-nav-bar>
		
		<view :style="{ height: this.getnavbarHeight().bottom + 5 + 'px' }" style="width: 100%;"></view>
		<!-- safearea -->
		<organization-card v-for="(item,index) in showList" :detail="showList[index]"></organization-card>
		
		<tab-bar :current="1"></tab-bar>
	</view>
</template>

<script>
	import uniNavBar from '@/components/uni-nav-bar/uni-nav-bar.vue';
	import organizationCard from '../../components/iweek-components/organizationCard/organizationCard/organizationCard.vue'
	import tabBar from '@/components/nq-tabbar/nq-tabbar.vue';
	import {
		mapState,
		mapMutations
	} from 'vuex';
	
	export default {
		components: {
			uniNavBar,
			organizationCard,
			tabBar
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
				showList: [],
			}
		},
		onLoad() {
			uni.setNavigationBarTitle({
				title:'社团组织'
			});
			
			this.navbarHeight = this.getnavbarHeight().bottom + 5;
			this.thisUserInfo = this.getGlobalUserInfo();
			this.getOrg(1);
		},
		methods: {
			getOrg: function(page){
				uni.showLoading({
					title: '加载中...'
				});
				var that = this;
				uni.request({
					url:that.$serverUrl +'/organization/queryOrganizations',
					method: 'POST',
					data: {
						page: page,
						userId:that.thisUserInfo.id,
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
							// that.sortList(that.organizationList);
							that.currentPage = page;
							that.showList = that.organizationList;
							
						})
					},
					fail: res => {
						uni.hideLoading();
							
						console.log('index unirequest fail');
						console.log(res);
					}
				});
			},
			sortList:function(organizationList){
				var item;
				for(item in this.organizationList){
					// this.organizationList[item]
					// 1是组织，2是社团
					if (this.organizationList[item].status == 1){
						this.orgList.push(this.organizationList[item]);
					}
					else if(this.organizationList[item].status == 2){
						this.clubList.push(this.organizationList[item]);
					}
				}
			}
		}
	}
</script>

<style>

</style>
