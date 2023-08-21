package com.nuoquan.pojo;

import java.util.ArrayList;
import java.util.List;

import cn.hutool.core.util.StrUtil;

/**
 * 奖品配置表 LotteryConfigExample
 * @author fuce_自动生成
 * @date 2023-08-19 22:47:40
 */
public class LotteryConfigExample {

    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public LotteryConfigExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }
        
		
        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLike(Integer value) {
            addCriterion("id like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotLike(Integer value) {
            addCriterion("id not like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }
        
		
        public Criteria andLotteryNameIsNull() {
            addCriterion("lottery_name is null");
            return (Criteria) this;
        }

        public Criteria andLotteryNameIsNotNull() {
            addCriterion("lottery_name is not null");
            return (Criteria) this;
        }

        public Criteria andLotteryNameEqualTo(String value) {
            addCriterion("lottery_name =", value, "lotteryName");
            return (Criteria) this;
        }

        public Criteria andLotteryNameNotEqualTo(String value) {
            addCriterion("lottery_name <>", value, "lotteryName");
            return (Criteria) this;
        }

        public Criteria andLotteryNameGreaterThan(String value) {
            addCriterion("lottery_name >", value, "lotteryName");
            return (Criteria) this;
        }

        public Criteria andLotteryNameGreaterThanOrEqualTo(String value) {
            addCriterion("lottery_name >=", value, "lotteryName");
            return (Criteria) this;
        }

        public Criteria andLotteryNameLessThan(String value) {
            addCriterion("lottery_name <", value, "lotteryName");
            return (Criteria) this;
        }

        public Criteria andLotteryNameLessThanOrEqualTo(String value) {
            addCriterion("lottery_name <=", value, "lotteryName");
            return (Criteria) this;
        }

        public Criteria andLotteryNameLike(String value) {
            addCriterion("lottery_name like", value, "lotteryName");
            return (Criteria) this;
        }

        public Criteria andLotteryNameNotLike(String value) {
            addCriterion("lottery_name not like", value, "lotteryName");
            return (Criteria) this;
        }

        public Criteria andLotteryNameIn(List<String> values) {
            addCriterion("lottery_name in", values, "lotteryName");
            return (Criteria) this;
        }

        public Criteria andLotteryNameNotIn(List<String> values) {
            addCriterion("lottery_name not in", values, "lotteryName");
            return (Criteria) this;
        }

        public Criteria andLotteryNameBetween(String value1, String value2) {
            addCriterion("lottery_name between", value1, value2, "lotteryName");
            return (Criteria) this;
        }

        public Criteria andLotteryNameNotBetween(String value1, String value2) {
            addCriterion("lottery_name not between", value1, value2, "lotteryName");
            return (Criteria) this;
        }
        
		
        public Criteria andLotteryContentIsNull() {
            addCriterion("lottery_content is null");
            return (Criteria) this;
        }

        public Criteria andLotteryContentIsNotNull() {
            addCriterion("lottery_content is not null");
            return (Criteria) this;
        }

        public Criteria andLotteryContentEqualTo(String value) {
            addCriterion("lottery_content =", value, "lotteryContent");
            return (Criteria) this;
        }

        public Criteria andLotteryContentNotEqualTo(String value) {
            addCriterion("lottery_content <>", value, "lotteryContent");
            return (Criteria) this;
        }

        public Criteria andLotteryContentGreaterThan(String value) {
            addCriterion("lottery_content >", value, "lotteryContent");
            return (Criteria) this;
        }

        public Criteria andLotteryContentGreaterThanOrEqualTo(String value) {
            addCriterion("lottery_content >=", value, "lotteryContent");
            return (Criteria) this;
        }

        public Criteria andLotteryContentLessThan(String value) {
            addCriterion("lottery_content <", value, "lotteryContent");
            return (Criteria) this;
        }

        public Criteria andLotteryContentLessThanOrEqualTo(String value) {
            addCriterion("lottery_content <=", value, "lotteryContent");
            return (Criteria) this;
        }

        public Criteria andLotteryContentLike(String value) {
            addCriterion("lottery_content like", value, "lotteryContent");
            return (Criteria) this;
        }

        public Criteria andLotteryContentNotLike(String value) {
            addCriterion("lottery_content not like", value, "lotteryContent");
            return (Criteria) this;
        }

        public Criteria andLotteryContentIn(List<String> values) {
            addCriterion("lottery_content in", values, "lotteryContent");
            return (Criteria) this;
        }

        public Criteria andLotteryContentNotIn(List<String> values) {
            addCriterion("lottery_content not in", values, "lotteryContent");
            return (Criteria) this;
        }

        public Criteria andLotteryContentBetween(String value1, String value2) {
            addCriterion("lottery_content between", value1, value2, "lotteryContent");
            return (Criteria) this;
        }

        public Criteria andLotteryContentNotBetween(String value1, String value2) {
            addCriterion("lottery_content not between", value1, value2, "lotteryContent");
            return (Criteria) this;
        }
        
		
        public Criteria andImageUrlIsNull() {
            addCriterion("image_url is null");
            return (Criteria) this;
        }

        public Criteria andImageUrlIsNotNull() {
            addCriterion("image_url is not null");
            return (Criteria) this;
        }

        public Criteria andImageUrlEqualTo(String value) {
            addCriterion("image_url =", value, "imageUrl");
            return (Criteria) this;
        }

        public Criteria andImageUrlNotEqualTo(String value) {
            addCriterion("image_url <>", value, "imageUrl");
            return (Criteria) this;
        }

        public Criteria andImageUrlGreaterThan(String value) {
            addCriterion("image_url >", value, "imageUrl");
            return (Criteria) this;
        }

        public Criteria andImageUrlGreaterThanOrEqualTo(String value) {
            addCriterion("image_url >=", value, "imageUrl");
            return (Criteria) this;
        }

        public Criteria andImageUrlLessThan(String value) {
            addCriterion("image_url <", value, "imageUrl");
            return (Criteria) this;
        }

        public Criteria andImageUrlLessThanOrEqualTo(String value) {
            addCriterion("image_url <=", value, "imageUrl");
            return (Criteria) this;
        }

        public Criteria andImageUrlLike(String value) {
            addCriterion("image_url like", value, "imageUrl");
            return (Criteria) this;
        }

        public Criteria andImageUrlNotLike(String value) {
            addCriterion("image_url not like", value, "imageUrl");
            return (Criteria) this;
        }

        public Criteria andImageUrlIn(List<String> values) {
            addCriterion("image_url in", values, "imageUrl");
            return (Criteria) this;
        }

        public Criteria andImageUrlNotIn(List<String> values) {
            addCriterion("image_url not in", values, "imageUrl");
            return (Criteria) this;
        }

        public Criteria andImageUrlBetween(String value1, String value2) {
            addCriterion("image_url between", value1, value2, "imageUrl");
            return (Criteria) this;
        }

        public Criteria andImageUrlNotBetween(String value1, String value2) {
            addCriterion("image_url not between", value1, value2, "imageUrl");
            return (Criteria) this;
        }
        
		
        public Criteria andThresholdIsNull() {
            addCriterion("threshold is null");
            return (Criteria) this;
        }

        public Criteria andThresholdIsNotNull() {
            addCriterion("threshold is not null");
            return (Criteria) this;
        }

        public Criteria andThresholdEqualTo(Integer value) {
            addCriterion("threshold =", value, "threshold");
            return (Criteria) this;
        }

        public Criteria andThresholdNotEqualTo(Integer value) {
            addCriterion("threshold <>", value, "threshold");
            return (Criteria) this;
        }

        public Criteria andThresholdGreaterThan(Integer value) {
            addCriterion("threshold >", value, "threshold");
            return (Criteria) this;
        }

        public Criteria andThresholdGreaterThanOrEqualTo(Integer value) {
            addCriterion("threshold >=", value, "threshold");
            return (Criteria) this;
        }

        public Criteria andThresholdLessThan(Integer value) {
            addCriterion("threshold <", value, "threshold");
            return (Criteria) this;
        }

        public Criteria andThresholdLessThanOrEqualTo(Integer value) {
            addCriterion("threshold <=", value, "threshold");
            return (Criteria) this;
        }

        public Criteria andThresholdLike(Integer value) {
            addCriterion("threshold like", value, "threshold");
            return (Criteria) this;
        }

        public Criteria andThresholdNotLike(Integer value) {
            addCriterion("threshold not like", value, "threshold");
            return (Criteria) this;
        }

        public Criteria andThresholdIn(List<Integer> values) {
            addCriterion("threshold in", values, "threshold");
            return (Criteria) this;
        }

        public Criteria andThresholdNotIn(List<Integer> values) {
            addCriterion("threshold not in", values, "threshold");
            return (Criteria) this;
        }

        public Criteria andThresholdBetween(Integer value1, Integer value2) {
            addCriterion("threshold between", value1, value2, "threshold");
            return (Criteria) this;
        }

        public Criteria andThresholdNotBetween(Integer value1, Integer value2) {
            addCriterion("threshold not between", value1, value2, "threshold");
            return (Criteria) this;
        }
        
		
        public Criteria andMeritStartIsNull() {
            addCriterion("merit_start is null");
            return (Criteria) this;
        }

        public Criteria andMeritStartIsNotNull() {
            addCriterion("merit_start is not null");
            return (Criteria) this;
        }

        public Criteria andMeritStartEqualTo(Integer value) {
            addCriterion("merit_start =", value, "meritStart");
            return (Criteria) this;
        }

        public Criteria andMeritStartNotEqualTo(Integer value) {
            addCriterion("merit_start <>", value, "meritStart");
            return (Criteria) this;
        }

        public Criteria andMeritStartGreaterThan(Integer value) {
            addCriterion("merit_start >", value, "meritStart");
            return (Criteria) this;
        }

        public Criteria andMeritStartGreaterThanOrEqualTo(Integer value) {
            addCriterion("merit_start >=", value, "meritStart");
            return (Criteria) this;
        }

        public Criteria andMeritStartLessThan(Integer value) {
            addCriterion("merit_start <", value, "meritStart");
            return (Criteria) this;
        }

        public Criteria andMeritStartLessThanOrEqualTo(Integer value) {
            addCriterion("merit_start <=", value, "meritStart");
            return (Criteria) this;
        }

        public Criteria andMeritStartLike(Integer value) {
            addCriterion("merit_start like", value, "meritStart");
            return (Criteria) this;
        }

        public Criteria andMeritStartNotLike(Integer value) {
            addCriterion("merit_start not like", value, "meritStart");
            return (Criteria) this;
        }

        public Criteria andMeritStartIn(List<Integer> values) {
            addCriterion("merit_start in", values, "meritStart");
            return (Criteria) this;
        }

        public Criteria andMeritStartNotIn(List<Integer> values) {
            addCriterion("merit_start not in", values, "meritStart");
            return (Criteria) this;
        }

        public Criteria andMeritStartBetween(Integer value1, Integer value2) {
            addCriterion("merit_start between", value1, value2, "meritStart");
            return (Criteria) this;
        }

        public Criteria andMeritStartNotBetween(Integer value1, Integer value2) {
            addCriterion("merit_start not between", value1, value2, "meritStart");
            return (Criteria) this;
        }
        
		
        public Criteria andMeritEndIsNull() {
            addCriterion("merit_end is null");
            return (Criteria) this;
        }

        public Criteria andMeritEndIsNotNull() {
            addCriterion("merit_end is not null");
            return (Criteria) this;
        }

        public Criteria andMeritEndEqualTo(Integer value) {
            addCriterion("merit_end =", value, "meritEnd");
            return (Criteria) this;
        }

        public Criteria andMeritEndNotEqualTo(Integer value) {
            addCriterion("merit_end <>", value, "meritEnd");
            return (Criteria) this;
        }

        public Criteria andMeritEndGreaterThan(Integer value) {
            addCriterion("merit_end >", value, "meritEnd");
            return (Criteria) this;
        }

        public Criteria andMeritEndGreaterThanOrEqualTo(Integer value) {
            addCriterion("merit_end >=", value, "meritEnd");
            return (Criteria) this;
        }

        public Criteria andMeritEndLessThan(Integer value) {
            addCriterion("merit_end <", value, "meritEnd");
            return (Criteria) this;
        }

        public Criteria andMeritEndLessThanOrEqualTo(Integer value) {
            addCriterion("merit_end <=", value, "meritEnd");
            return (Criteria) this;
        }

        public Criteria andMeritEndLike(Integer value) {
            addCriterion("merit_end like", value, "meritEnd");
            return (Criteria) this;
        }

        public Criteria andMeritEndNotLike(Integer value) {
            addCriterion("merit_end not like", value, "meritEnd");
            return (Criteria) this;
        }

        public Criteria andMeritEndIn(List<Integer> values) {
            addCriterion("merit_end in", values, "meritEnd");
            return (Criteria) this;
        }

        public Criteria andMeritEndNotIn(List<Integer> values) {
            addCriterion("merit_end not in", values, "meritEnd");
            return (Criteria) this;
        }

        public Criteria andMeritEndBetween(Integer value1, Integer value2) {
            addCriterion("merit_end between", value1, value2, "meritEnd");
            return (Criteria) this;
        }

        public Criteria andMeritEndNotBetween(Integer value1, Integer value2) {
            addCriterion("merit_end not between", value1, value2, "meritEnd");
            return (Criteria) this;
        }
        
		
        public Criteria andIsDeletedIsNull() {
            addCriterion("is_deleted is null");
            return (Criteria) this;
        }

        public Criteria andIsDeletedIsNotNull() {
            addCriterion("is_deleted is not null");
            return (Criteria) this;
        }

        public Criteria andIsDeletedEqualTo(Character value) {
            addCriterion("is_deleted =", value, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedNotEqualTo(Character value) {
            addCriterion("is_deleted <>", value, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedGreaterThan(Character value) {
            addCriterion("is_deleted >", value, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedGreaterThanOrEqualTo(Character value) {
            addCriterion("is_deleted >=", value, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedLessThan(Character value) {
            addCriterion("is_deleted <", value, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedLessThanOrEqualTo(Character value) {
            addCriterion("is_deleted <=", value, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedLike(Character value) {
            addCriterion("is_deleted like", value, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedNotLike(Character value) {
            addCriterion("is_deleted not like", value, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedIn(List<Character> values) {
            addCriterion("is_deleted in", values, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedNotIn(List<Character> values) {
            addCriterion("is_deleted not in", values, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedBetween(Character value1, Character value2) {
            addCriterion("is_deleted between", value1, value2, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedNotBetween(Character value1, Character value2) {
            addCriterion("is_deleted not between", value1, value2, "isDeleted");
            return (Criteria) this;
        }
        
	
		 public Criteria andLikeQuery(LotteryConfig record) {
		 	List<String> list= new ArrayList<String>();
		 	List<String> list2= new ArrayList<String>();
        	StringBuffer buffer=new StringBuffer();
			if(record.getId()!=null&&StrUtil.isNotEmpty(record.getId().toString())) {
    			 list.add("ifnull(id,'')");
    		}
			if(record.getLotteryName()!=null&&StrUtil.isNotEmpty(record.getLotteryName().toString())) {
    			 list.add("ifnull(lottery_name,'')");
    		}
			if(record.getLotteryContent()!=null&&StrUtil.isNotEmpty(record.getLotteryContent().toString())) {
    			 list.add("ifnull(lottery_content,'')");
    		}
			if(record.getImageUrl()!=null&&StrUtil.isNotEmpty(record.getImageUrl().toString())) {
    			 list.add("ifnull(image_url,'')");
    		}
			if(record.getThreshold()!=null&&StrUtil.isNotEmpty(record.getThreshold().toString())) {
    			 list.add("ifnull(threshold,'')");
    		}
			if(record.getMeritStart()!=null&&StrUtil.isNotEmpty(record.getMeritStart().toString())) {
    			 list.add("ifnull(merit_start,'')");
    		}
			if(record.getMeritEnd()!=null&&StrUtil.isNotEmpty(record.getMeritEnd().toString())) {
    			 list.add("ifnull(merit_end,'')");
    		}
			if(record.getIsDeleted()!=null&&StrUtil.isNotEmpty(record.getIsDeleted().toString())) {
    			 list.add("ifnull(is_deleted,'')");
    		}
			if(record.getId()!=null&&StrUtil.isNotEmpty(record.getId().toString())) {
    			list2.add("'%"+record.getId()+"%'");
    		}
			if(record.getLotteryName()!=null&&StrUtil.isNotEmpty(record.getLotteryName().toString())) {
    			list2.add("'%"+record.getLotteryName()+"%'");
    		}
			if(record.getLotteryContent()!=null&&StrUtil.isNotEmpty(record.getLotteryContent().toString())) {
    			list2.add("'%"+record.getLotteryContent()+"%'");
    		}
			if(record.getImageUrl()!=null&&StrUtil.isNotEmpty(record.getImageUrl().toString())) {
    			list2.add("'%"+record.getImageUrl()+"%'");
    		}
			if(record.getThreshold()!=null&&StrUtil.isNotEmpty(record.getThreshold().toString())) {
    			list2.add("'%"+record.getThreshold()+"%'");
    		}
			if(record.getMeritStart()!=null&&StrUtil.isNotEmpty(record.getMeritStart().toString())) {
    			list2.add("'%"+record.getMeritStart()+"%'");
    		}
			if(record.getMeritEnd()!=null&&StrUtil.isNotEmpty(record.getMeritEnd().toString())) {
    			list2.add("'%"+record.getMeritEnd()+"%'");
    		}
			if(record.getIsDeleted()!=null&&StrUtil.isNotEmpty(record.getIsDeleted().toString())) {
    			list2.add("'%"+record.getIsDeleted()+"%'");
    		}
        	buffer.append(" CONCAT(");
	        buffer.append(StrUtil.join(",",list));
        	buffer.append(")");
        	buffer.append(" like CONCAT(");
        	buffer.append(StrUtil.join(",",list2));
        	buffer.append(")");
        	if(!" CONCAT() like CONCAT()".equals(buffer.toString())) {
        		addCriterion(buffer.toString());
        	}
        	return (Criteria) this;
        }
        
        public Criteria andLikeQuery2(String searchText) {
		 	List<String> list= new ArrayList<String>();
        	StringBuffer buffer=new StringBuffer();
    		list.add("ifnull(id,'')");
    		list.add("ifnull(lottery_name,'')");
    		list.add("ifnull(lottery_content,'')");
    		list.add("ifnull(image_url,'')");
    		list.add("ifnull(threshold,'')");
    		list.add("ifnull(merit_start,'')");
    		list.add("ifnull(merit_end,'')");
    		list.add("ifnull(is_deleted,'')");
        	buffer.append(" CONCAT(");
	        buffer.append(StrUtil.join(",",list));
        	buffer.append(")");
        	buffer.append("like '%");
        	buffer.append(searchText);
        	buffer.append("%'");
        	addCriterion(buffer.toString());
        	return (Criteria) this;
        }
        
}
	
    public static class Criteria extends GeneratedCriteria {
        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}