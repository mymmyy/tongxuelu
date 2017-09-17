package org.jxnd.tongxuelu_album.entity;

import java.util.ArrayList;
import java.util.List;

public class AlbumExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AlbumExample() {
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

        public Criteria andAlbumIdIsNull() {
            addCriterion("album_id is null");
            return (Criteria) this;
        }

        public Criteria andAlbumIdIsNotNull() {
            addCriterion("album_id is not null");
            return (Criteria) this;
        }

        public Criteria andAlbumIdEqualTo(Integer value) {
            addCriterion("album_id =", value, "albumId");
            return (Criteria) this;
        }

        public Criteria andAlbumIdNotEqualTo(Integer value) {
            addCriterion("album_id <>", value, "albumId");
            return (Criteria) this;
        }

        public Criteria andAlbumIdGreaterThan(Integer value) {
            addCriterion("album_id >", value, "albumId");
            return (Criteria) this;
        }

        public Criteria andAlbumIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("album_id >=", value, "albumId");
            return (Criteria) this;
        }

        public Criteria andAlbumIdLessThan(Integer value) {
            addCriterion("album_id <", value, "albumId");
            return (Criteria) this;
        }

        public Criteria andAlbumIdLessThanOrEqualTo(Integer value) {
            addCriterion("album_id <=", value, "albumId");
            return (Criteria) this;
        }

        public Criteria andAlbumIdIn(List<Integer> values) {
            addCriterion("album_id in", values, "albumId");
            return (Criteria) this;
        }

        public Criteria andAlbumIdNotIn(List<Integer> values) {
            addCriterion("album_id not in", values, "albumId");
            return (Criteria) this;
        }

        public Criteria andAlbumIdBetween(Integer value1, Integer value2) {
            addCriterion("album_id between", value1, value2, "albumId");
            return (Criteria) this;
        }

        public Criteria andAlbumIdNotBetween(Integer value1, Integer value2) {
            addCriterion("album_id not between", value1, value2, "albumId");
            return (Criteria) this;
        }

        public Criteria andAlbumNameIsNull() {
            addCriterion("album_name is null");
            return (Criteria) this;
        }

        public Criteria andAlbumNameIsNotNull() {
            addCriterion("album_name is not null");
            return (Criteria) this;
        }

        public Criteria andAlbumNameEqualTo(String value) {
            addCriterion("album_name =", value, "albumName");
            return (Criteria) this;
        }

        public Criteria andAlbumNameNotEqualTo(String value) {
            addCriterion("album_name <>", value, "albumName");
            return (Criteria) this;
        }

        public Criteria andAlbumNameGreaterThan(String value) {
            addCriterion("album_name >", value, "albumName");
            return (Criteria) this;
        }

        public Criteria andAlbumNameGreaterThanOrEqualTo(String value) {
            addCriterion("album_name >=", value, "albumName");
            return (Criteria) this;
        }

        public Criteria andAlbumNameLessThan(String value) {
            addCriterion("album_name <", value, "albumName");
            return (Criteria) this;
        }

        public Criteria andAlbumNameLessThanOrEqualTo(String value) {
            addCriterion("album_name <=", value, "albumName");
            return (Criteria) this;
        }

        public Criteria andAlbumNameLike(String value) {
            addCriterion("album_name like", value, "albumName");
            return (Criteria) this;
        }

        public Criteria andAlbumNameNotLike(String value) {
            addCriterion("album_name not like", value, "albumName");
            return (Criteria) this;
        }

        public Criteria andAlbumNameIn(List<String> values) {
            addCriterion("album_name in", values, "albumName");
            return (Criteria) this;
        }

        public Criteria andAlbumNameNotIn(List<String> values) {
            addCriterion("album_name not in", values, "albumName");
            return (Criteria) this;
        }

        public Criteria andAlbumNameBetween(String value1, String value2) {
            addCriterion("album_name between", value1, value2, "albumName");
            return (Criteria) this;
        }

        public Criteria andAlbumNameNotBetween(String value1, String value2) {
            addCriterion("album_name not between", value1, value2, "albumName");
            return (Criteria) this;
        }

        public Criteria andViewLockIsNull() {
            addCriterion("view_lock is null");
            return (Criteria) this;
        }

        public Criteria andViewLockIsNotNull() {
            addCriterion("view_lock is not null");
            return (Criteria) this;
        }

        public Criteria andViewLockEqualTo(Integer value) {
            addCriterion("view_lock =", value, "viewLock");
            return (Criteria) this;
        }

        public Criteria andViewLockNotEqualTo(Integer value) {
            addCriterion("view_lock <>", value, "viewLock");
            return (Criteria) this;
        }

        public Criteria andViewLockGreaterThan(Integer value) {
            addCriterion("view_lock >", value, "viewLock");
            return (Criteria) this;
        }

        public Criteria andViewLockGreaterThanOrEqualTo(Integer value) {
            addCriterion("view_lock >=", value, "viewLock");
            return (Criteria) this;
        }

        public Criteria andViewLockLessThan(Integer value) {
            addCriterion("view_lock <", value, "viewLock");
            return (Criteria) this;
        }

        public Criteria andViewLockLessThanOrEqualTo(Integer value) {
            addCriterion("view_lock <=", value, "viewLock");
            return (Criteria) this;
        }

        public Criteria andViewLockIn(List<Integer> values) {
            addCriterion("view_lock in", values, "viewLock");
            return (Criteria) this;
        }

        public Criteria andViewLockNotIn(List<Integer> values) {
            addCriterion("view_lock not in", values, "viewLock");
            return (Criteria) this;
        }

        public Criteria andViewLockBetween(Integer value1, Integer value2) {
            addCriterion("view_lock between", value1, value2, "viewLock");
            return (Criteria) this;
        }

        public Criteria andViewLockNotBetween(Integer value1, Integer value2) {
            addCriterion("view_lock not between", value1, value2, "viewLock");
            return (Criteria) this;
        }

        public Criteria andViewIssueIsNull() {
            addCriterion("view_issue is null");
            return (Criteria) this;
        }

        public Criteria andViewIssueIsNotNull() {
            addCriterion("view_issue is not null");
            return (Criteria) this;
        }

        public Criteria andViewIssueEqualTo(String value) {
            addCriterion("view_issue =", value, "viewIssue");
            return (Criteria) this;
        }

        public Criteria andViewIssueNotEqualTo(String value) {
            addCriterion("view_issue <>", value, "viewIssue");
            return (Criteria) this;
        }

        public Criteria andViewIssueGreaterThan(String value) {
            addCriterion("view_issue >", value, "viewIssue");
            return (Criteria) this;
        }

        public Criteria andViewIssueGreaterThanOrEqualTo(String value) {
            addCriterion("view_issue >=", value, "viewIssue");
            return (Criteria) this;
        }

        public Criteria andViewIssueLessThan(String value) {
            addCriterion("view_issue <", value, "viewIssue");
            return (Criteria) this;
        }

        public Criteria andViewIssueLessThanOrEqualTo(String value) {
            addCriterion("view_issue <=", value, "viewIssue");
            return (Criteria) this;
        }

        public Criteria andViewIssueLike(String value) {
            addCriterion("view_issue like", value, "viewIssue");
            return (Criteria) this;
        }

        public Criteria andViewIssueNotLike(String value) {
            addCriterion("view_issue not like", value, "viewIssue");
            return (Criteria) this;
        }

        public Criteria andViewIssueIn(List<String> values) {
            addCriterion("view_issue in", values, "viewIssue");
            return (Criteria) this;
        }

        public Criteria andViewIssueNotIn(List<String> values) {
            addCriterion("view_issue not in", values, "viewIssue");
            return (Criteria) this;
        }

        public Criteria andViewIssueBetween(String value1, String value2) {
            addCriterion("view_issue between", value1, value2, "viewIssue");
            return (Criteria) this;
        }

        public Criteria andViewIssueNotBetween(String value1, String value2) {
            addCriterion("view_issue not between", value1, value2, "viewIssue");
            return (Criteria) this;
        }

        public Criteria andViewKeyIsNull() {
            addCriterion("view_key is null");
            return (Criteria) this;
        }

        public Criteria andViewKeyIsNotNull() {
            addCriterion("view_key is not null");
            return (Criteria) this;
        }

        public Criteria andViewKeyEqualTo(String value) {
            addCriterion("view_key =", value, "viewKey");
            return (Criteria) this;
        }

        public Criteria andViewKeyNotEqualTo(String value) {
            addCriterion("view_key <>", value, "viewKey");
            return (Criteria) this;
        }

        public Criteria andViewKeyGreaterThan(String value) {
            addCriterion("view_key >", value, "viewKey");
            return (Criteria) this;
        }

        public Criteria andViewKeyGreaterThanOrEqualTo(String value) {
            addCriterion("view_key >=", value, "viewKey");
            return (Criteria) this;
        }

        public Criteria andViewKeyLessThan(String value) {
            addCriterion("view_key <", value, "viewKey");
            return (Criteria) this;
        }

        public Criteria andViewKeyLessThanOrEqualTo(String value) {
            addCriterion("view_key <=", value, "viewKey");
            return (Criteria) this;
        }

        public Criteria andViewKeyLike(String value) {
            addCriterion("view_key like", value, "viewKey");
            return (Criteria) this;
        }

        public Criteria andViewKeyNotLike(String value) {
            addCriterion("view_key not like", value, "viewKey");
            return (Criteria) this;
        }

        public Criteria andViewKeyIn(List<String> values) {
            addCriterion("view_key in", values, "viewKey");
            return (Criteria) this;
        }

        public Criteria andViewKeyNotIn(List<String> values) {
            addCriterion("view_key not in", values, "viewKey");
            return (Criteria) this;
        }

        public Criteria andViewKeyBetween(String value1, String value2) {
            addCriterion("view_key between", value1, value2, "viewKey");
            return (Criteria) this;
        }

        public Criteria andViewKeyNotBetween(String value1, String value2) {
            addCriterion("view_key not between", value1, value2, "viewKey");
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