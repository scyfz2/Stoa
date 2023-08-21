package com.nuoquan.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import cn.hutool.core.util.StrUtil;

/**
 * 中奖记录表 LotteryHistoryExample
 * @author fuce_自动生成
 * @date 2023-08-20 01:31:23
 */
public class LotteryHistoryExample {

    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public LotteryHistoryExample() {
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
        
		
        public Criteria andLotteryIdIsNull() {
            addCriterion("lottery_id is null");
            return (Criteria) this;
        }

        public Criteria andLotteryIdIsNotNull() {
            addCriterion("lottery_id is not null");
            return (Criteria) this;
        }

        public Criteria andLotteryIdEqualTo(Integer value) {
            addCriterion("lottery_id =", value, "lotteryId");
            return (Criteria) this;
        }

        public Criteria andLotteryIdNotEqualTo(Integer value) {
            addCriterion("lottery_id <>", value, "lotteryId");
            return (Criteria) this;
        }

        public Criteria andLotteryIdGreaterThan(Integer value) {
            addCriterion("lottery_id >", value, "lotteryId");
            return (Criteria) this;
        }

        public Criteria andLotteryIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("lottery_id >=", value, "lotteryId");
            return (Criteria) this;
        }

        public Criteria andLotteryIdLessThan(Integer value) {
            addCriterion("lottery_id <", value, "lotteryId");
            return (Criteria) this;
        }

        public Criteria andLotteryIdLessThanOrEqualTo(Integer value) {
            addCriterion("lottery_id <=", value, "lotteryId");
            return (Criteria) this;
        }

        public Criteria andLotteryIdLike(Integer value) {
            addCriterion("lottery_id like", value, "lotteryId");
            return (Criteria) this;
        }

        public Criteria andLotteryIdNotLike(Integer value) {
            addCriterion("lottery_id not like", value, "lotteryId");
            return (Criteria) this;
        }

        public Criteria andLotteryIdIn(List<Integer> values) {
            addCriterion("lottery_id in", values, "lotteryId");
            return (Criteria) this;
        }

        public Criteria andLotteryIdNotIn(List<Integer> values) {
            addCriterion("lottery_id not in", values, "lotteryId");
            return (Criteria) this;
        }

        public Criteria andLotteryIdBetween(Integer value1, Integer value2) {
            addCriterion("lottery_id between", value1, value2, "lotteryId");
            return (Criteria) this;
        }

        public Criteria andLotteryIdNotBetween(Integer value1, Integer value2) {
            addCriterion("lottery_id not between", value1, value2, "lotteryId");
            return (Criteria) this;
        }
        
		
        public Criteria andLotteryNoIsNull() {
            addCriterion("lottery_no is null");
            return (Criteria) this;
        }

        public Criteria andLotteryNoIsNotNull() {
            addCriterion("lottery_no is not null");
            return (Criteria) this;
        }

        public Criteria andLotteryNoEqualTo(Integer value) {
            addCriterion("lottery_no =", value, "lotteryNo");
            return (Criteria) this;
        }

        public Criteria andLotteryNoNotEqualTo(Integer value) {
            addCriterion("lottery_no <>", value, "lotteryNo");
            return (Criteria) this;
        }

        public Criteria andLotteryNoGreaterThan(Integer value) {
            addCriterion("lottery_no >", value, "lotteryNo");
            return (Criteria) this;
        }

        public Criteria andLotteryNoGreaterThanOrEqualTo(Integer value) {
            addCriterion("lottery_no >=", value, "lotteryNo");
            return (Criteria) this;
        }

        public Criteria andLotteryNoLessThan(Integer value) {
            addCriterion("lottery_no <", value, "lotteryNo");
            return (Criteria) this;
        }

        public Criteria andLotteryNoLessThanOrEqualTo(Integer value) {
            addCriterion("lottery_no <=", value, "lotteryNo");
            return (Criteria) this;
        }

        public Criteria andLotteryNoLike(Integer value) {
            addCriterion("lottery_no like", value, "lotteryNo");
            return (Criteria) this;
        }

        public Criteria andLotteryNoNotLike(Integer value) {
            addCriterion("lottery_no not like", value, "lotteryNo");
            return (Criteria) this;
        }

        public Criteria andLotteryNoIn(List<Integer> values) {
            addCriterion("lottery_no in", values, "lotteryNo");
            return (Criteria) this;
        }

        public Criteria andLotteryNoNotIn(List<Integer> values) {
            addCriterion("lottery_no not in", values, "lotteryNo");
            return (Criteria) this;
        }

        public Criteria andLotteryNoBetween(Integer value1, Integer value2) {
            addCriterion("lottery_no between", value1, value2, "lotteryNo");
            return (Criteria) this;
        }

        public Criteria andLotteryNoNotBetween(Integer value1, Integer value2) {
            addCriterion("lottery_no not between", value1, value2, "lotteryNo");
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
        
		
        public Criteria andLotteryDateIsNull() {
            addCriterion("lottery_date is null");
            return (Criteria) this;
        }

        public Criteria andLotteryDateIsNotNull() {
            addCriterion("lottery_date is not null");
            return (Criteria) this;
        }

        public Criteria andLotteryDateEqualTo(Date value) {
            addCriterion("lottery_date =", value, "lotteryDate");
            return (Criteria) this;
        }

        public Criteria andLotteryDateNotEqualTo(Date value) {
            addCriterion("lottery_date <>", value, "lotteryDate");
            return (Criteria) this;
        }

        public Criteria andLotteryDateGreaterThan(Date value) {
            addCriterion("lottery_date >", value, "lotteryDate");
            return (Criteria) this;
        }

        public Criteria andLotteryDateGreaterThanOrEqualTo(Date value) {
            addCriterion("lottery_date >=", value, "lotteryDate");
            return (Criteria) this;
        }

        public Criteria andLotteryDateLessThan(Date value) {
            addCriterion("lottery_date <", value, "lotteryDate");
            return (Criteria) this;
        }

        public Criteria andLotteryDateLessThanOrEqualTo(Date value) {
            addCriterion("lottery_date <=", value, "lotteryDate");
            return (Criteria) this;
        }

        public Criteria andLotteryDateLike(Date value) {
            addCriterion("lottery_date like", value, "lotteryDate");
            return (Criteria) this;
        }

        public Criteria andLotteryDateNotLike(Date value) {
            addCriterion("lottery_date not like", value, "lotteryDate");
            return (Criteria) this;
        }

        public Criteria andLotteryDateIn(List<Date> values) {
            addCriterion("lottery_date in", values, "lotteryDate");
            return (Criteria) this;
        }

        public Criteria andLotteryDateNotIn(List<Date> values) {
            addCriterion("lottery_date not in", values, "lotteryDate");
            return (Criteria) this;
        }

        public Criteria andLotteryDateBetween(Date value1, Date value2) {
            addCriterion("lottery_date between", value1, value2, "lotteryDate");
            return (Criteria) this;
        }

        public Criteria andLotteryDateNotBetween(Date value1, Date value2) {
            addCriterion("lottery_date not between", value1, value2, "lotteryDate");
            return (Criteria) this;
        }
        
		
        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(String value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(String value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(String value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(String value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(String value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(String value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLike(String value) {
            addCriterion("user_id like", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotLike(String value) {
            addCriterion("user_id not like", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<String> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<String> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(String value1, String value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(String value1, String value2) {
            addCriterion("user_id not between", value1, value2, "userId");
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
        
	
		 public Criteria andLikeQuery(LotteryHistory record) {
		 	List<String> list= new ArrayList<String>();
		 	List<String> list2= new ArrayList<String>();
        	StringBuffer buffer=new StringBuffer();
			if(record.getId()!=null&&StrUtil.isNotEmpty(record.getId().toString())) {
    			 list.add("ifnull(id,'')");
    		}
			if(record.getLotteryId()!=null&&StrUtil.isNotEmpty(record.getLotteryId().toString())) {
    			 list.add("ifnull(lottery_id,'')");
    		}
			if(record.getLotteryNo()!=null&&StrUtil.isNotEmpty(record.getLotteryNo().toString())) {
    			 list.add("ifnull(lottery_no,'')");
    		}
			if(record.getLotteryContent()!=null&&StrUtil.isNotEmpty(record.getLotteryContent().toString())) {
    			 list.add("ifnull(lottery_content,'')");
    		}
			if(record.getLotteryDate()!=null&&StrUtil.isNotEmpty(record.getLotteryDate().toString())) {
    			 list.add("ifnull(lottery_date,'')");
    		}
			if(record.getUserId()!=null&&StrUtil.isNotEmpty(record.getUserId().toString())) {
    			 list.add("ifnull(user_id,'')");
    		}
			if(record.getIsDeleted()!=null&&StrUtil.isNotEmpty(record.getIsDeleted().toString())) {
    			 list.add("ifnull(is_deleted,'')");
    		}
			if(record.getId()!=null&&StrUtil.isNotEmpty(record.getId().toString())) {
    			list2.add("'%"+record.getId()+"%'");
    		}
			if(record.getLotteryId()!=null&&StrUtil.isNotEmpty(record.getLotteryId().toString())) {
    			list2.add("'%"+record.getLotteryId()+"%'");
    		}
			if(record.getLotteryNo()!=null&&StrUtil.isNotEmpty(record.getLotteryNo().toString())) {
    			list2.add("'%"+record.getLotteryNo()+"%'");
    		}
			if(record.getLotteryContent()!=null&&StrUtil.isNotEmpty(record.getLotteryContent().toString())) {
    			list2.add("'%"+record.getLotteryContent()+"%'");
    		}
			if(record.getLotteryDate()!=null&&StrUtil.isNotEmpty(record.getLotteryDate().toString())) {
    			list2.add("'%"+record.getLotteryDate()+"%'");
    		}
			if(record.getUserId()!=null&&StrUtil.isNotEmpty(record.getUserId().toString())) {
    			list2.add("'%"+record.getUserId()+"%'");
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
    		list.add("ifnull(lottery_id,'')");
    		list.add("ifnull(lottery_no,'')");
    		list.add("ifnull(lottery_content,'')");
    		list.add("ifnull(lottery_date,'')");
    		list.add("ifnull(user_id,'')");
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