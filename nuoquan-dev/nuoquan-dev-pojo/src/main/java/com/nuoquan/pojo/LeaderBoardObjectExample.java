package com.nuoquan.pojo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import cn.hutool.core.util.StrUtil;

/**
 * 排行榜主表 LeaderBoardObjectExample
 * @author xxdd_自动生成
 * @date 2023-12-23 15:05:38
 */
public class LeaderBoardObjectExample {

    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public LeaderBoardObjectExample() {
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

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLike(Long value) {
            addCriterion("id like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotLike(Long value) {
            addCriterion("id not like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }
        
		
        public Criteria andNameIsNull() {
            addCriterion("name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
            return (Criteria) this;
        }
        
		
        public Criteria andLeaderBoardIdIsNull() {
            addCriterion("leader_board_id is null");
            return (Criteria) this;
        }

        public Criteria andLeaderBoardIdIsNotNull() {
            addCriterion("leader_board_id is not null");
            return (Criteria) this;
        }

        public Criteria andLeaderBoardIdEqualTo(String value) {
            addCriterion("leader_board_id =", value, "leaderBoardId");
            return (Criteria) this;
        }

        public Criteria andLeaderBoardIdNotEqualTo(String value) {
            addCriterion("leader_board_id <>", value, "leaderBoardId");
            return (Criteria) this;
        }

        public Criteria andLeaderBoardIdGreaterThan(String value) {
            addCriterion("leader_board_id >", value, "leaderBoardId");
            return (Criteria) this;
        }

        public Criteria andLeaderBoardIdGreaterThanOrEqualTo(String value) {
            addCriterion("leader_board_id >=", value, "leaderBoardId");
            return (Criteria) this;
        }

        public Criteria andLeaderBoardIdLessThan(String value) {
            addCriterion("leader_board_id <", value, "leaderBoardId");
            return (Criteria) this;
        }

        public Criteria andLeaderBoardIdLessThanOrEqualTo(String value) {
            addCriterion("leader_board_id <=", value, "leaderBoardId");
            return (Criteria) this;
        }

        public Criteria andLeaderBoardIdLike(String value) {
            addCriterion("leader_board_id like", value, "leaderBoardId");
            return (Criteria) this;
        }

        public Criteria andLeaderBoardIdNotLike(String value) {
            addCriterion("leader_board_id not like", value, "leaderBoardId");
            return (Criteria) this;
        }

        public Criteria andLeaderBoardIdIn(List<String> values) {
            addCriterion("leader_board_id in", values, "leaderBoardId");
            return (Criteria) this;
        }

        public Criteria andLeaderBoardIdNotIn(List<String> values) {
            addCriterion("leader_board_id not in", values, "leaderBoardId");
            return (Criteria) this;
        }

        public Criteria andLeaderBoardIdBetween(String value1, String value2) {
            addCriterion("leader_board_id between", value1, value2, "leaderBoardId");
            return (Criteria) this;
        }

        public Criteria andLeaderBoardIdNotBetween(String value1, String value2) {
            addCriterion("leader_board_id not between", value1, value2, "leaderBoardId");
            return (Criteria) this;
        }
        
		
        public Criteria andImgUrl0IsNull() {
            addCriterion("img_url0 is null");
            return (Criteria) this;
        }

        public Criteria andImgUrl0IsNotNull() {
            addCriterion("img_url0 is not null");
            return (Criteria) this;
        }

        public Criteria andImgUrl0EqualTo(String value) {
            addCriterion("img_url0 =", value, "imgUrl0");
            return (Criteria) this;
        }

        public Criteria andImgUrl0NotEqualTo(String value) {
            addCriterion("img_url0 <>", value, "imgUrl0");
            return (Criteria) this;
        }

        public Criteria andImgUrl0GreaterThan(String value) {
            addCriterion("img_url0 >", value, "imgUrl0");
            return (Criteria) this;
        }

        public Criteria andImgUrl0GreaterThanOrEqualTo(String value) {
            addCriterion("img_url0 >=", value, "imgUrl0");
            return (Criteria) this;
        }

        public Criteria andImgUrl0LessThan(String value) {
            addCriterion("img_url0 <", value, "imgUrl0");
            return (Criteria) this;
        }

        public Criteria andImgUrl0LessThanOrEqualTo(String value) {
            addCriterion("img_url0 <=", value, "imgUrl0");
            return (Criteria) this;
        }

        public Criteria andImgUrl0Like(String value) {
            addCriterion("img_url0 like", value, "imgUrl0");
            return (Criteria) this;
        }

        public Criteria andImgUrl0NotLike(String value) {
            addCriterion("img_url0 not like", value, "imgUrl0");
            return (Criteria) this;
        }

        public Criteria andImgUrl0In(List<String> values) {
            addCriterion("img_url0 in", values, "imgUrl0");
            return (Criteria) this;
        }

        public Criteria andImgUrl0NotIn(List<String> values) {
            addCriterion("img_url0 not in", values, "imgUrl0");
            return (Criteria) this;
        }

        public Criteria andImgUrl0Between(String value1, String value2) {
            addCriterion("img_url0 between", value1, value2, "imgUrl0");
            return (Criteria) this;
        }

        public Criteria andImgUrl0NotBetween(String value1, String value2) {
            addCriterion("img_url0 not between", value1, value2, "imgUrl0");
            return (Criteria) this;
        }
        
		
        public Criteria andImgUrl1IsNull() {
            addCriterion("img_url1 is null");
            return (Criteria) this;
        }

        public Criteria andImgUrl1IsNotNull() {
            addCriterion("img_url1 is not null");
            return (Criteria) this;
        }

        public Criteria andImgUrl1EqualTo(String value) {
            addCriterion("img_url1 =", value, "imgUrl1");
            return (Criteria) this;
        }

        public Criteria andImgUrl1NotEqualTo(String value) {
            addCriterion("img_url1 <>", value, "imgUrl1");
            return (Criteria) this;
        }

        public Criteria andImgUrl1GreaterThan(String value) {
            addCriterion("img_url1 >", value, "imgUrl1");
            return (Criteria) this;
        }

        public Criteria andImgUrl1GreaterThanOrEqualTo(String value) {
            addCriterion("img_url1 >=", value, "imgUrl1");
            return (Criteria) this;
        }

        public Criteria andImgUrl1LessThan(String value) {
            addCriterion("img_url1 <", value, "imgUrl1");
            return (Criteria) this;
        }

        public Criteria andImgUrl1LessThanOrEqualTo(String value) {
            addCriterion("img_url1 <=", value, "imgUrl1");
            return (Criteria) this;
        }

        public Criteria andImgUrl1Like(String value) {
            addCriterion("img_url1 like", value, "imgUrl1");
            return (Criteria) this;
        }

        public Criteria andImgUrl1NotLike(String value) {
            addCriterion("img_url1 not like", value, "imgUrl1");
            return (Criteria) this;
        }

        public Criteria andImgUrl1In(List<String> values) {
            addCriterion("img_url1 in", values, "imgUrl1");
            return (Criteria) this;
        }

        public Criteria andImgUrl1NotIn(List<String> values) {
            addCriterion("img_url1 not in", values, "imgUrl1");
            return (Criteria) this;
        }

        public Criteria andImgUrl1Between(String value1, String value2) {
            addCriterion("img_url1 between", value1, value2, "imgUrl1");
            return (Criteria) this;
        }

        public Criteria andImgUrl1NotBetween(String value1, String value2) {
            addCriterion("img_url1 not between", value1, value2, "imgUrl1");
            return (Criteria) this;
        }
        
		
        public Criteria andImgUrl2IsNull() {
            addCriterion("img_url2 is null");
            return (Criteria) this;
        }

        public Criteria andImgUrl2IsNotNull() {
            addCriterion("img_url2 is not null");
            return (Criteria) this;
        }

        public Criteria andImgUrl2EqualTo(String value) {
            addCriterion("img_url2 =", value, "imgUrl2");
            return (Criteria) this;
        }

        public Criteria andImgUrl2NotEqualTo(String value) {
            addCriterion("img_url2 <>", value, "imgUrl2");
            return (Criteria) this;
        }

        public Criteria andImgUrl2GreaterThan(String value) {
            addCriterion("img_url2 >", value, "imgUrl2");
            return (Criteria) this;
        }

        public Criteria andImgUrl2GreaterThanOrEqualTo(String value) {
            addCriterion("img_url2 >=", value, "imgUrl2");
            return (Criteria) this;
        }

        public Criteria andImgUrl2LessThan(String value) {
            addCriterion("img_url2 <", value, "imgUrl2");
            return (Criteria) this;
        }

        public Criteria andImgUrl2LessThanOrEqualTo(String value) {
            addCriterion("img_url2 <=", value, "imgUrl2");
            return (Criteria) this;
        }

        public Criteria andImgUrl2Like(String value) {
            addCriterion("img_url2 like", value, "imgUrl2");
            return (Criteria) this;
        }

        public Criteria andImgUrl2NotLike(String value) {
            addCriterion("img_url2 not like", value, "imgUrl2");
            return (Criteria) this;
        }

        public Criteria andImgUrl2In(List<String> values) {
            addCriterion("img_url2 in", values, "imgUrl2");
            return (Criteria) this;
        }

        public Criteria andImgUrl2NotIn(List<String> values) {
            addCriterion("img_url2 not in", values, "imgUrl2");
            return (Criteria) this;
        }

        public Criteria andImgUrl2Between(String value1, String value2) {
            addCriterion("img_url2 between", value1, value2, "imgUrl2");
            return (Criteria) this;
        }

        public Criteria andImgUrl2NotBetween(String value1, String value2) {
            addCriterion("img_url2 not between", value1, value2, "imgUrl2");
            return (Criteria) this;
        }
        
		
        public Criteria andTagIsNull() {
            addCriterion("tag is null");
            return (Criteria) this;
        }

        public Criteria andTagIsNotNull() {
            addCriterion("tag is not null");
            return (Criteria) this;
        }

        public Criteria andTagEqualTo(String value) {
            addCriterion("tag =", value, "tag");
            return (Criteria) this;
        }

        public Criteria andTagNotEqualTo(String value) {
            addCriterion("tag <>", value, "tag");
            return (Criteria) this;
        }

        public Criteria andTagGreaterThan(String value) {
            addCriterion("tag >", value, "tag");
            return (Criteria) this;
        }

        public Criteria andTagGreaterThanOrEqualTo(String value) {
            addCriterion("tag >=", value, "tag");
            return (Criteria) this;
        }

        public Criteria andTagLessThan(String value) {
            addCriterion("tag <", value, "tag");
            return (Criteria) this;
        }

        public Criteria andTagLessThanOrEqualTo(String value) {
            addCriterion("tag <=", value, "tag");
            return (Criteria) this;
        }

        public Criteria andTagLike(String value) {
            addCriterion("tag like", value, "tag");
            return (Criteria) this;
        }

        public Criteria andTagNotLike(String value) {
            addCriterion("tag not like", value, "tag");
            return (Criteria) this;
        }

        public Criteria andTagIn(List<String> values) {
            addCriterion("tag in", values, "tag");
            return (Criteria) this;
        }

        public Criteria andTagNotIn(List<String> values) {
            addCriterion("tag not in", values, "tag");
            return (Criteria) this;
        }

        public Criteria andTagBetween(String value1, String value2) {
            addCriterion("tag between", value1, value2, "tag");
            return (Criteria) this;
        }

        public Criteria andTagNotBetween(String value1, String value2) {
            addCriterion("tag not between", value1, value2, "tag");
            return (Criteria) this;
        }
        
		
        public Criteria andStarIsNull() {
            addCriterion("star is null");
            return (Criteria) this;
        }

        public Criteria andStarIsNotNull() {
            addCriterion("star is not null");
            return (Criteria) this;
        }

        public Criteria andStarEqualTo(BigDecimal value) {
            addCriterion("star =", value, "star");
            return (Criteria) this;
        }

        public Criteria andStarNotEqualTo(BigDecimal value) {
            addCriterion("star <>", value, "star");
            return (Criteria) this;
        }

        public Criteria andStarGreaterThan(BigDecimal value) {
            addCriterion("star >", value, "star");
            return (Criteria) this;
        }

        public Criteria andStarGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("star >=", value, "star");
            return (Criteria) this;
        }

        public Criteria andStarLessThan(BigDecimal value) {
            addCriterion("star <", value, "star");
            return (Criteria) this;
        }

        public Criteria andStarLessThanOrEqualTo(BigDecimal value) {
            addCriterion("star <=", value, "star");
            return (Criteria) this;
        }

        public Criteria andStarLike(BigDecimal value) {
            addCriterion("star like", value, "star");
            return (Criteria) this;
        }

        public Criteria andStarNotLike(BigDecimal value) {
            addCriterion("star not like", value, "star");
            return (Criteria) this;
        }

        public Criteria andStarIn(List<BigDecimal> values) {
            addCriterion("star in", values, "star");
            return (Criteria) this;
        }

        public Criteria andStarNotIn(List<BigDecimal> values) {
            addCriterion("star not in", values, "star");
            return (Criteria) this;
        }

        public Criteria andStarBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("star between", value1, value2, "star");
            return (Criteria) this;
        }

        public Criteria andStarNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("star not between", value1, value2, "star");
            return (Criteria) this;
        }
        
		
        public Criteria andEvaluateNumsIsNull() {
            addCriterion("evaluate_nums is null");
            return (Criteria) this;
        }

        public Criteria andEvaluateNumsIsNotNull() {
            addCriterion("evaluate_nums is not null");
            return (Criteria) this;
        }

        public Criteria andEvaluateNumsEqualTo(Integer value) {
            addCriterion("evaluate_nums =", value, "evaluateNums");
            return (Criteria) this;
        }

        public Criteria andEvaluateNumsNotEqualTo(Integer value) {
            addCriterion("evaluate_nums <>", value, "evaluateNums");
            return (Criteria) this;
        }

        public Criteria andEvaluateNumsGreaterThan(Integer value) {
            addCriterion("evaluate_nums >", value, "evaluateNums");
            return (Criteria) this;
        }

        public Criteria andEvaluateNumsGreaterThanOrEqualTo(Integer value) {
            addCriterion("evaluate_nums >=", value, "evaluateNums");
            return (Criteria) this;
        }

        public Criteria andEvaluateNumsLessThan(Integer value) {
            addCriterion("evaluate_nums <", value, "evaluateNums");
            return (Criteria) this;
        }

        public Criteria andEvaluateNumsLessThanOrEqualTo(Integer value) {
            addCriterion("evaluate_nums <=", value, "evaluateNums");
            return (Criteria) this;
        }

        public Criteria andEvaluateNumsLike(Integer value) {
            addCriterion("evaluate_nums like", value, "evaluateNums");
            return (Criteria) this;
        }

        public Criteria andEvaluateNumsNotLike(Integer value) {
            addCriterion("evaluate_nums not like", value, "evaluateNums");
            return (Criteria) this;
        }

        public Criteria andEvaluateNumsIn(List<Integer> values) {
            addCriterion("evaluate_nums in", values, "evaluateNums");
            return (Criteria) this;
        }

        public Criteria andEvaluateNumsNotIn(List<Integer> values) {
            addCriterion("evaluate_nums not in", values, "evaluateNums");
            return (Criteria) this;
        }

        public Criteria andEvaluateNumsBetween(Integer value1, Integer value2) {
            addCriterion("evaluate_nums between", value1, value2, "evaluateNums");
            return (Criteria) this;
        }

        public Criteria andEvaluateNumsNotBetween(Integer value1, Integer value2) {
            addCriterion("evaluate_nums not between", value1, value2, "evaluateNums");
            return (Criteria) this;
        }
        
		
        public Criteria andLeaderBoardDescIsNull() {
            addCriterion("leader_board_desc is null");
            return (Criteria) this;
        }

        public Criteria andLeaderBoardDescIsNotNull() {
            addCriterion("leader_board_desc is not null");
            return (Criteria) this;
        }

        public Criteria andLeaderBoardDescEqualTo(String value) {
            addCriterion("leader_board_desc =", value, "leaderBoardDesc");
            return (Criteria) this;
        }

        public Criteria andLeaderBoardDescNotEqualTo(String value) {
            addCriterion("leader_board_desc <>", value, "leaderBoardDesc");
            return (Criteria) this;
        }

        public Criteria andLeaderBoardDescGreaterThan(String value) {
            addCriterion("leader_board_desc >", value, "leaderBoardDesc");
            return (Criteria) this;
        }

        public Criteria andLeaderBoardDescGreaterThanOrEqualTo(String value) {
            addCriterion("leader_board_desc >=", value, "leaderBoardDesc");
            return (Criteria) this;
        }

        public Criteria andLeaderBoardDescLessThan(String value) {
            addCriterion("leader_board_desc <", value, "leaderBoardDesc");
            return (Criteria) this;
        }

        public Criteria andLeaderBoardDescLessThanOrEqualTo(String value) {
            addCriterion("leader_board_desc <=", value, "leaderBoardDesc");
            return (Criteria) this;
        }

        public Criteria andLeaderBoardDescLike(String value) {
            addCriterion("leader_board_desc like", value, "leaderBoardDesc");
            return (Criteria) this;
        }

        public Criteria andLeaderBoardDescNotLike(String value) {
            addCriterion("leader_board_desc not like", value, "leaderBoardDesc");
            return (Criteria) this;
        }

        public Criteria andLeaderBoardDescIn(List<String> values) {
            addCriterion("leader_board_desc in", values, "leaderBoardDesc");
            return (Criteria) this;
        }

        public Criteria andLeaderBoardDescNotIn(List<String> values) {
            addCriterion("leader_board_desc not in", values, "leaderBoardDesc");
            return (Criteria) this;
        }

        public Criteria andLeaderBoardDescBetween(String value1, String value2) {
            addCriterion("leader_board_desc between", value1, value2, "leaderBoardDesc");
            return (Criteria) this;
        }

        public Criteria andLeaderBoardDescNotBetween(String value1, String value2) {
            addCriterion("leader_board_desc not between", value1, value2, "leaderBoardDesc");
            return (Criteria) this;
        }
        
		
        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(String value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(String value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(String value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(String value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(String value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(String value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLike(String value) {
            addCriterion("status like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotLike(String value) {
            addCriterion("status not like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<String> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<String> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(String value1, String value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(String value1, String value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }
        
		
        public Criteria andCreateByIsNull() {
            addCriterion("create_by is null");
            return (Criteria) this;
        }

        public Criteria andCreateByIsNotNull() {
            addCriterion("create_by is not null");
            return (Criteria) this;
        }

        public Criteria andCreateByEqualTo(String value) {
            addCriterion("create_by =", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByNotEqualTo(String value) {
            addCriterion("create_by <>", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByGreaterThan(String value) {
            addCriterion("create_by >", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByGreaterThanOrEqualTo(String value) {
            addCriterion("create_by >=", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByLessThan(String value) {
            addCriterion("create_by <", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByLessThanOrEqualTo(String value) {
            addCriterion("create_by <=", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByLike(String value) {
            addCriterion("create_by like", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByNotLike(String value) {
            addCriterion("create_by not like", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByIn(List<String> values) {
            addCriterion("create_by in", values, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByNotIn(List<String> values) {
            addCriterion("create_by not in", values, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByBetween(String value1, String value2) {
            addCriterion("create_by between", value1, value2, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByNotBetween(String value1, String value2) {
            addCriterion("create_by not between", value1, value2, "createBy");
            return (Criteria) this;
        }
        
		
        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLike(Date value) {
            addCriterion("create_time like", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotLike(Date value) {
            addCriterion("create_time not like", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }
        
		
        public Criteria andUpdateByIsNull() {
            addCriterion("update_by is null");
            return (Criteria) this;
        }

        public Criteria andUpdateByIsNotNull() {
            addCriterion("update_by is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateByEqualTo(String value) {
            addCriterion("update_by =", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByNotEqualTo(String value) {
            addCriterion("update_by <>", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByGreaterThan(String value) {
            addCriterion("update_by >", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByGreaterThanOrEqualTo(String value) {
            addCriterion("update_by >=", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByLessThan(String value) {
            addCriterion("update_by <", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByLessThanOrEqualTo(String value) {
            addCriterion("update_by <=", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByLike(String value) {
            addCriterion("update_by like", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByNotLike(String value) {
            addCriterion("update_by not like", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByIn(List<String> values) {
            addCriterion("update_by in", values, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByNotIn(List<String> values) {
            addCriterion("update_by not in", values, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByBetween(String value1, String value2) {
            addCriterion("update_by between", value1, value2, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByNotBetween(String value1, String value2) {
            addCriterion("update_by not between", value1, value2, "updateBy");
            return (Criteria) this;
        }
        
		
        public Criteria andUpdateTimeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLike(Date value) {
            addCriterion("update_time like", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotLike(Date value) {
            addCriterion("update_time not like", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("update_time not between", value1, value2, "updateTime");
            return (Criteria) this;
        }
        
		
        public Criteria andDelFlagIsNull() {
            addCriterion("del_flag is null");
            return (Criteria) this;
        }

        public Criteria andDelFlagIsNotNull() {
            addCriterion("del_flag is not null");
            return (Criteria) this;
        }

        public Criteria andDelFlagEqualTo(Integer value) {
            addCriterion("del_flag =", value, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagNotEqualTo(Integer value) {
            addCriterion("del_flag <>", value, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagGreaterThan(Integer value) {
            addCriterion("del_flag >", value, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagGreaterThanOrEqualTo(Integer value) {
            addCriterion("del_flag >=", value, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagLessThan(Integer value) {
            addCriterion("del_flag <", value, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagLessThanOrEqualTo(Integer value) {
            addCriterion("del_flag <=", value, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagLike(Integer value) {
            addCriterion("del_flag like", value, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagNotLike(Integer value) {
            addCriterion("del_flag not like", value, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagIn(List<Integer> values) {
            addCriterion("del_flag in", values, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagNotIn(List<Integer> values) {
            addCriterion("del_flag not in", values, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagBetween(Integer value1, Integer value2) {
            addCriterion("del_flag between", value1, value2, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagNotBetween(Integer value1, Integer value2) {
            addCriterion("del_flag not between", value1, value2, "delFlag");
            return (Criteria) this;
        }
        
	
		 public Criteria andLikeQuery(LeaderBoardObject record) {
		 	List<String> list= new ArrayList<String>();
		 	List<String> list2= new ArrayList<String>();
        	StringBuffer buffer=new StringBuffer();
			if(record.getId()!=null&&StrUtil.isNotEmpty(record.getId().toString())) {
    			 list.add("ifnull(id,'')");
    		}
			if(record.getName()!=null&&StrUtil.isNotEmpty(record.getName().toString())) {
    			 list.add("ifnull(name,'')");
    		}
			if(record.getLeaderBoardId()!=null&&StrUtil.isNotEmpty(record.getLeaderBoardId().toString())) {
    			 list.add("ifnull(leader_board_id,'')");
    		}
			if(record.getImgUrl0()!=null&&StrUtil.isNotEmpty(record.getImgUrl0().toString())) {
    			 list.add("ifnull(img_url0,'')");
    		}
			if(record.getImgUrl1()!=null&&StrUtil.isNotEmpty(record.getImgUrl1().toString())) {
    			 list.add("ifnull(img_url1,'')");
    		}
			if(record.getImgUrl2()!=null&&StrUtil.isNotEmpty(record.getImgUrl2().toString())) {
    			 list.add("ifnull(img_url2,'')");
    		}
			if(record.getTag()!=null&&StrUtil.isNotEmpty(record.getTag().toString())) {
    			 list.add("ifnull(tag,'')");
    		}
			if(record.getStar()!=null&&StrUtil.isNotEmpty(record.getStar().toString())) {
    			 list.add("ifnull(star,'')");
    		}
			if(record.getEvaluateNums()!=null&&StrUtil.isNotEmpty(record.getEvaluateNums().toString())) {
    			 list.add("ifnull(evaluate_nums,'')");
    		}
			if(record.getLeaderBoardDesc()!=null&&StrUtil.isNotEmpty(record.getLeaderBoardDesc().toString())) {
    			 list.add("ifnull(leader_board_desc,'')");
    		}
			if(record.getStatus()!=null&&StrUtil.isNotEmpty(record.getStatus().toString())) {
    			 list.add("ifnull(status,'')");
    		}
			if(record.getCreateBy()!=null&&StrUtil.isNotEmpty(record.getCreateBy().toString())) {
    			 list.add("ifnull(create_by,'')");
    		}
			if(record.getCreateTime()!=null&&StrUtil.isNotEmpty(record.getCreateTime().toString())) {
    			 list.add("ifnull(create_time,'')");
    		}
			if(record.getUpdateBy()!=null&&StrUtil.isNotEmpty(record.getUpdateBy().toString())) {
    			 list.add("ifnull(update_by,'')");
    		}
			if(record.getUpdateTime()!=null&&StrUtil.isNotEmpty(record.getUpdateTime().toString())) {
    			 list.add("ifnull(update_time,'')");
    		}
			if(record.getDelFlag()!=null&&StrUtil.isNotEmpty(record.getDelFlag().toString())) {
    			 list.add("ifnull(del_flag,'')");
    		}
			if(record.getId()!=null&&StrUtil.isNotEmpty(record.getId().toString())) {
    			list2.add("'%"+record.getId()+"%'");
    		}
			if(record.getName()!=null&&StrUtil.isNotEmpty(record.getName().toString())) {
    			list2.add("'%"+record.getName()+"%'");
    		}
			if(record.getLeaderBoardId()!=null&&StrUtil.isNotEmpty(record.getLeaderBoardId().toString())) {
    			list2.add("'%"+record.getLeaderBoardId()+"%'");
    		}
			if(record.getImgUrl0()!=null&&StrUtil.isNotEmpty(record.getImgUrl0().toString())) {
    			list2.add("'%"+record.getImgUrl0()+"%'");
    		}
			if(record.getImgUrl1()!=null&&StrUtil.isNotEmpty(record.getImgUrl1().toString())) {
    			list2.add("'%"+record.getImgUrl1()+"%'");
    		}
			if(record.getImgUrl2()!=null&&StrUtil.isNotEmpty(record.getImgUrl2().toString())) {
    			list2.add("'%"+record.getImgUrl2()+"%'");
    		}
			if(record.getTag()!=null&&StrUtil.isNotEmpty(record.getTag().toString())) {
    			list2.add("'%"+record.getTag()+"%'");
    		}
			if(record.getStar()!=null&&StrUtil.isNotEmpty(record.getStar().toString())) {
    			list2.add("'%"+record.getStar()+"%'");
    		}
			if(record.getEvaluateNums()!=null&&StrUtil.isNotEmpty(record.getEvaluateNums().toString())) {
    			list2.add("'%"+record.getEvaluateNums()+"%'");
    		}
			if(record.getLeaderBoardDesc()!=null&&StrUtil.isNotEmpty(record.getLeaderBoardDesc().toString())) {
    			list2.add("'%"+record.getLeaderBoardDesc()+"%'");
    		}
			if(record.getStatus()!=null&&StrUtil.isNotEmpty(record.getStatus().toString())) {
    			list2.add("'%"+record.getStatus()+"%'");
    		}
			if(record.getCreateBy()!=null&&StrUtil.isNotEmpty(record.getCreateBy().toString())) {
    			list2.add("'%"+record.getCreateBy()+"%'");
    		}
			if(record.getCreateTime()!=null&&StrUtil.isNotEmpty(record.getCreateTime().toString())) {
    			list2.add("'%"+record.getCreateTime()+"%'");
    		}
			if(record.getUpdateBy()!=null&&StrUtil.isNotEmpty(record.getUpdateBy().toString())) {
    			list2.add("'%"+record.getUpdateBy()+"%'");
    		}
			if(record.getUpdateTime()!=null&&StrUtil.isNotEmpty(record.getUpdateTime().toString())) {
    			list2.add("'%"+record.getUpdateTime()+"%'");
    		}
			if(record.getDelFlag()!=null&&StrUtil.isNotEmpty(record.getDelFlag().toString())) {
    			list2.add("'%"+record.getDelFlag()+"%'");
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
    		list.add("ifnull(name,'')");
    		list.add("ifnull(leader_board_id,'')");
    		list.add("ifnull(img_url0,'')");
    		list.add("ifnull(img_url1,'')");
    		list.add("ifnull(img_url2,'')");
    		list.add("ifnull(tag,'')");
    		list.add("ifnull(star,'')");
    		list.add("ifnull(evaluate_nums,'')");
    		list.add("ifnull(leader_board_desc,'')");
    		list.add("ifnull(status,'')");
    		list.add("ifnull(create_by,'')");
    		list.add("ifnull(create_time,'')");
    		list.add("ifnull(update_by,'')");
    		list.add("ifnull(update_time,'')");
    		list.add("ifnull(del_flag,'')");
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