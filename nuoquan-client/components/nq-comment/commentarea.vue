<template>
	<!--评论区域-->
	<view :style="{ width: areaWidth, margin: areaMargin, opacity: commentList.length != undefined ? 1 : 0 }">
		<!--评论数，排序方式-->
		<view class="comments-menu">
			<view class="comments-num">{{ commentNum }}{{ lang.commentNum }}</view>
			<nqSwitch
				v-if="lang.langType == 'zh-CN'"
				style="margin-top: 3px;"
				:bgSwitchLeft="'-13px'"
				:bgSwitchRight="'41px'"
				:options="[lang.time, lang.hot]"
				@onChange="change_comment_order"
			></nqSwitch>
			<nqSwitch v-else style="margin-top: 3px;" :bgSwitchLeft="'-11px'" :bgSwitchRight="'41px'" :options="[lang.time, lang.hot]" @onChange="change_comment_order"></nqSwitch>
			<!-- <view class="comments-order">
                   <view class="order-in-time" :class="{ chosen : order == 0}" @tap="change_comment_order(0)">
					   时间
				   </view>
				   <view class="order-in-hot" :class="{ chosen : order != 0}" @tap="change_comment_order(1)">
				   	   热度
				   </view>
				   <view class="bg-of-order" :style="{'left':order == 0 ? '-13px;' :'41px' ,}"></view>
			</view> -->
		</view>

		<!--循环评论卡片-->
		<view class="comments">
			<block v-for="(comment, index) in commentList" :key="index">
				<view class="comment">
					<view class="comment-info">
						<image :src="pathFilter(comment.mainComment.faceImg)" @tap="goToPersonPublic(comment.mainComment.fromUserId)"></image>
						<text selectable="true" class="name_text">{{ comment.mainComment.nickname }}</text>
						<view class="time_text">{{ timeDeal(comment.mainComment.createDate) }}</view>
					</view>
					<text selectable="true" class="comment-content" @longpress="onLongpress" @tap="goToCommentDetail(comment.mainComment)">{{ comment.mainComment.comment }}</text>
					<reComment :subComment="comment.subComment" @goToCommentDetail="goToCommentDetail(comment.mainComment)" style="width: 100%;height:100%;"></reComment>
					<view class="comment-menu">
						<view class="operationBar column_center">
							<nqCmt @click.native="goToCommentDetail(comment.mainComment)" :number="comment.mainComment.commentNum"></nqCmt>
							<nqLike
								style="margin-left: 11px;"
								@click.native="swLikeComment(comment, index)"
								:status="comment.mainComment.isLike"
								:number="comment.mainComment.likeNum"
							></nqLike>
						</view>
					</view>
				</view>
			</block>
		</view>
	</view>
</template>

<script>
import nqSwitch from '@/components/nq-switch.vue';
import reComment from './reComment.vue';
import { mapState, mapMutations } from 'vuex';
import nqLike from '@/components/nq-button/nq-likeButton.vue';
import nqCmt from '@/components/nq-button/nq-cmtButton.vue';

export default {
	props: {
		/** commentList数据结构
		 * commentList:[
		 * 		mainComment:
		 * 		subComment:{
		 * 			subCommentList,
		 * 			subCommentNum
		 * 		}
		 * ]
		 */
		commentList: '',
		commentNum: '',
		areaWidth: '100%',
		areaMargin: ''
	},
	components: {
		nqSwitch,
		reComment,
		nqLike,
		nqCmt
	},
	computed: {
		...mapState(['lang'])
	},
	created() {
		uni.$on('updateComment', comment => {
			console.log('on update');
			// from comment-detail || comment-vote-detail
			for (var i = 0; i < this.commentList.length; i++) {
				if (this.commentList[i].mainComment.id == comment.mainComment.id) {
					this.commentList[i].mainComment = comment.mainComment;
					this.commentList[i].subComment = comment.subComment;
					console.log('update 第' + i + '条评论');
				}
			}
		});
	},

	data() {
		return {
			// commentList: this.commentList,
			order: 0 //评论排序方式 0：按时间查询, 1：按热度查询
		};
	},
	methods: {
		swLikeComment(comment, index) {
			console.log('click like');
			this.$emit('like', comment, index);
		},
		onLongpress() {
			console.log('触发长按操作,复制或者是快速回复');
		},
		goToCommentDetail(mainComment) {
			this.$emit('goToCommentDetail', mainComment);
			// uni.navigateTo({
			// 	url: '/pages/comment-detail/comment-detail?data=' + JSON.stringify(mainComment)
			// });
		},
		change_comment_order(e) {
			this.$emit('onChange', {
				type: e.status
			});
		},
		goToPersonPublic(userId) {
			// router.goToPersonPublic(); // 全局方法
			uni.navigateTo({
				url: '/pagesSubA/personpublic/personpublic?userId=' + userId
			});
		}
	} //method
};
</script>

<style>
@import url('./oneComment.css');

.comments-menu {
	height: 28px;
	padding-top: 13px;
}

.comments-num {
	height: 17px;
	font-size: 17px;
	font-family: Source Han Sans CN;
	font-weight: 500;
	line-height: 17px;
	color: rgba(155, 155, 155, 1);
	padding-left: 4px;
	display: inline-block;
}

/* .comments-order {
		margin-top:3px;
		height: 22px;
		background: #ECECEC;
		border-radius: 75px;
		width: 82px;
		float: right;
		line-height: 28px;
		display: flex;
		vertical-align: middle;
		position: relative;
		justify-content: space-between;
		
	}
	.order-in-hot ,.order-in-time{
		color:#9B9B9B;
		font-size: 10px;
		line-height: 22px;
		display: inline-block;
		align-items: center;
		padding-right:10.5px;
		padding-left: 10.5px;
		z-index: 30;
		width:28px;
		text-align: center;
		transition: padding-left 200ms,
		padding-right 200ms,
		font-size  200ms,
		color 200ms;
		 transition-delay: 0ms;
	}
	.bg-of-order{
		height:28px;
		width:54px;
		background: #FFFFFF;
		border-radius: 75px;
		box-shadow: 0px 0px 10px rgba(0,0,0,0.16);
		z-index: 20;
		position: absolute;
		left:-13px;
		top:-3px;
		transition: left 500ms ease;
	}
	.chosen{
		font-size: 14px;
		color:#353535;
		width:28px;
		padding-left: 0;
		padding-right: 0;
		transition: padding-left 300ms,
		padding-right 300ms,
		font-size  300ms,
		color 300ms;
		 transition-delay: 100ms;
	} */
</style>
