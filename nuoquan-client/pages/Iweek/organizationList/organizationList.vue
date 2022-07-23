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
				
				organizationList:[
				{
					icon:'/static/icon/iweek/society.png',
					title:'青协',
					brief:"sassadsadafsffsfsdsfsdhfhdfhsdgfsdhsjdfhhfsjsdfgdfshdfsbsfjhfsdbfhsbfhsfbsfhbshfsvfshsfbsfhbssffasasaa333333",
					activity:"11232425436547654765785685686877867",
					department:"121354327nsjdsbdasdsadas",
				}]
			}
		},
		onLoad() {
			this.navbarHeight = this.getnavbarHeight().bottom + 5;
		},
		methods: {
			
		}
	}
</script>

<style>

</style>
