package cn.hrfax.open.model.bean;
/*
 * Copyright(c) 2016 expo.ofweek.com All rights reserved.
 * distributed with this file and available online at
 * http://expo.ofweek.com/
 */
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;


/**
 * user 
 */
public class UserBean {

    /**
     * 逻辑or语句
     * 对应数据库表字段 user
     */
    private List<Criteria> oredCriteria;

    /**
     */
    public UserBean() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * 获得逻辑or语句
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * 添加逻辑or语句
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * 添加逻辑and语句
     */
    public void and(Criteria criteria) {
        criteria.setAndRelation(true);
        oredCriteria.add(criteria);
    }

    /**
     * 新建逻辑或or语句
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * 新建逻辑and语句
     */
    public Criteria and() {
        Criteria criteria = createCriteriaInternal();
        criteria.setAndRelation(true);
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * 创建查询条件，如果逻辑或为空，同时将查询条件放入。
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * 创建新查询条件。
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * 清除逻辑或or语句，并且distinct为false，不去重。
     */
    public void clear() {
        oredCriteria.clear();
    }

    /**
     * 该类对应数据库表 user
     */
    protected abstract static class AbstractGeneratedCriteria implements java.io.Serializable {
        protected List<Criterion> criteria;

        protected AbstractGeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        public void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        public void orCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition, true));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void orCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value, true));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        protected void orCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2, true));
        }

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Timestamp(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Timestamp> dateList = new ArrayList<java.sql.Timestamp>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Timestamp(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Timestamp(value1.getTime()), new java.sql.Timestamp(value2.getTime()), property);
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
        public Criteria orIdIsNull() {
            orCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria orIdIsNotNull() {
            orCriterion("id is not null");
            return (Criteria) this;
        }
        public Criteria orIdEqualTo(Integer value) {
            orCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria orIdNotEqualTo(Integer value) {
            orCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria orIdGreaterThan(Integer value) {
            orCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria orIdGreaterThanOrEqualTo(Integer value) {
            orCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria orIdLessThan(Integer value) {
            orCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria orIdLessThanOrEqualTo(Integer value) {
            orCriterion("id <=", value, "id");
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

        public Criteria orIdIn(List<Integer> values) {
            orCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria orIdNotIn(List<Integer> values) {
            orCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria orIdBetween(Integer value1, Integer value2) {
            orCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria orIdNotBetween(Integer value1, Integer value2) {
            orCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }
        public Criteria andUsernameIsNull() {
            addCriterion("username is null");
            return (Criteria) this;
        }
        
        public Criteria andUsernameIsNotNull() {
            addCriterion("username is not null");
            return (Criteria) this;
        }
        public Criteria andUsernameEqualTo(String value) {
            addCriterion("username =", value, "username");
            return (Criteria) this;
        }
        
        public Criteria andUsernameNotEqualTo(String value) {
            addCriterion("username <>", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameGreaterThan(String value) {
            addCriterion("username >", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameGreaterThanOrEqualTo(String value) {
            addCriterion("username >=", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLessThan(String value) {
            addCriterion("username <", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLessThanOrEqualTo(String value) {
            addCriterion("username <=", value, "username");
            return (Criteria) this;
        }
        public Criteria orUsernameIsNull() {
            orCriterion("username is null");
            return (Criteria) this;
        }

        public Criteria orUsernameIsNotNull() {
            orCriterion("username is not null");
            return (Criteria) this;
        }
        public Criteria orUsernameEqualTo(String value) {
            orCriterion("username =", value, "username");
            return (Criteria) this;
        }

        public Criteria orUsernameNotEqualTo(String value) {
            orCriterion("username <>", value, "username");
            return (Criteria) this;
        }

        public Criteria orUsernameGreaterThan(String value) {
            orCriterion("username >", value, "username");
            return (Criteria) this;
        }

        public Criteria orUsernameGreaterThanOrEqualTo(String value) {
            orCriterion("username >=", value, "username");
            return (Criteria) this;
        }

        public Criteria orUsernameLessThan(String value) {
            orCriterion("username <", value, "username");
            return (Criteria) this;
        }

        public Criteria orUsernameLessThanOrEqualTo(String value) {
            orCriterion("username <=", value, "username");
            return (Criteria) this;
        }
        public Criteria andUsernameLike(String value) {
            addCriterion("username like", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotLike(String value) {
            addCriterion("username not like", value, "username");
            return (Criteria) this;
        }

        public Criteria orUsernameLike(String value) {
            orCriterion("username like", value, "username");
            return (Criteria) this;
        }

        public Criteria orUsernameNotLike(String value) {
            orCriterion("username not like", value, "username");
            return (Criteria) this;
        }
        
        
        public Criteria andUsernameIn(List<String> values) {
            addCriterion("username in", values, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotIn(List<String> values) {
            addCriterion("username not in", values, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameBetween(String value1, String value2) {
            addCriterion("username between", value1, value2, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotBetween(String value1, String value2) {
            addCriterion("username not between", value1, value2, "username");
            return (Criteria) this;
        }

        public Criteria orUsernameIn(List<String> values) {
            orCriterion("username in", values, "username");
            return (Criteria) this;
        }

        public Criteria orUsernameNotIn(List<String> values) {
            orCriterion("username not in", values, "username");
            return (Criteria) this;
        }

        public Criteria orUsernameBetween(String value1, String value2) {
            orCriterion("username between", value1, value2, "username");
            return (Criteria) this;
        }

        public Criteria orUsernameNotBetween(String value1, String value2) {
            orCriterion("username not between", value1, value2, "username");
            return (Criteria) this;
        }
        public Criteria andNicknameIsNull() {
            addCriterion("nickname is null");
            return (Criteria) this;
        }
        
        public Criteria andNicknameIsNotNull() {
            addCriterion("nickname is not null");
            return (Criteria) this;
        }
        public Criteria andNicknameEqualTo(String value) {
            addCriterion("nickname =", value, "nickname");
            return (Criteria) this;
        }
        
        public Criteria andNicknameNotEqualTo(String value) {
            addCriterion("nickname <>", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameGreaterThan(String value) {
            addCriterion("nickname >", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameGreaterThanOrEqualTo(String value) {
            addCriterion("nickname >=", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameLessThan(String value) {
            addCriterion("nickname <", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameLessThanOrEqualTo(String value) {
            addCriterion("nickname <=", value, "nickname");
            return (Criteria) this;
        }
        public Criteria orNicknameIsNull() {
            orCriterion("nickname is null");
            return (Criteria) this;
        }

        public Criteria orNicknameIsNotNull() {
            orCriterion("nickname is not null");
            return (Criteria) this;
        }
        public Criteria orNicknameEqualTo(String value) {
            orCriterion("nickname =", value, "nickname");
            return (Criteria) this;
        }

        public Criteria orNicknameNotEqualTo(String value) {
            orCriterion("nickname <>", value, "nickname");
            return (Criteria) this;
        }

        public Criteria orNicknameGreaterThan(String value) {
            orCriterion("nickname >", value, "nickname");
            return (Criteria) this;
        }

        public Criteria orNicknameGreaterThanOrEqualTo(String value) {
            orCriterion("nickname >=", value, "nickname");
            return (Criteria) this;
        }

        public Criteria orNicknameLessThan(String value) {
            orCriterion("nickname <", value, "nickname");
            return (Criteria) this;
        }

        public Criteria orNicknameLessThanOrEqualTo(String value) {
            orCriterion("nickname <=", value, "nickname");
            return (Criteria) this;
        }
        public Criteria andNicknameLike(String value) {
            addCriterion("nickname like", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameNotLike(String value) {
            addCriterion("nickname not like", value, "nickname");
            return (Criteria) this;
        }

        public Criteria orNicknameLike(String value) {
            orCriterion("nickname like", value, "nickname");
            return (Criteria) this;
        }

        public Criteria orNicknameNotLike(String value) {
            orCriterion("nickname not like", value, "nickname");
            return (Criteria) this;
        }
        
        
        public Criteria andNicknameIn(List<String> values) {
            addCriterion("nickname in", values, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameNotIn(List<String> values) {
            addCriterion("nickname not in", values, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameBetween(String value1, String value2) {
            addCriterion("nickname between", value1, value2, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameNotBetween(String value1, String value2) {
            addCriterion("nickname not between", value1, value2, "nickname");
            return (Criteria) this;
        }

        public Criteria orNicknameIn(List<String> values) {
            orCriterion("nickname in", values, "nickname");
            return (Criteria) this;
        }

        public Criteria orNicknameNotIn(List<String> values) {
            orCriterion("nickname not in", values, "nickname");
            return (Criteria) this;
        }

        public Criteria orNicknameBetween(String value1, String value2) {
            orCriterion("nickname between", value1, value2, "nickname");
            return (Criteria) this;
        }

        public Criteria orNicknameNotBetween(String value1, String value2) {
            orCriterion("nickname not between", value1, value2, "nickname");
            return (Criteria) this;
        }
        public Criteria andRealnameIsNull() {
            addCriterion("realname is null");
            return (Criteria) this;
        }
        
        public Criteria andRealnameIsNotNull() {
            addCriterion("realname is not null");
            return (Criteria) this;
        }
        public Criteria andRealnameEqualTo(String value) {
            addCriterion("realname =", value, "realname");
            return (Criteria) this;
        }
        
        public Criteria andRealnameNotEqualTo(String value) {
            addCriterion("realname <>", value, "realname");
            return (Criteria) this;
        }

        public Criteria andRealnameGreaterThan(String value) {
            addCriterion("realname >", value, "realname");
            return (Criteria) this;
        }

        public Criteria andRealnameGreaterThanOrEqualTo(String value) {
            addCriterion("realname >=", value, "realname");
            return (Criteria) this;
        }

        public Criteria andRealnameLessThan(String value) {
            addCriterion("realname <", value, "realname");
            return (Criteria) this;
        }

        public Criteria andRealnameLessThanOrEqualTo(String value) {
            addCriterion("realname <=", value, "realname");
            return (Criteria) this;
        }
        public Criteria orRealnameIsNull() {
            orCriterion("realname is null");
            return (Criteria) this;
        }

        public Criteria orRealnameIsNotNull() {
            orCriterion("realname is not null");
            return (Criteria) this;
        }
        public Criteria orRealnameEqualTo(String value) {
            orCriterion("realname =", value, "realname");
            return (Criteria) this;
        }

        public Criteria orRealnameNotEqualTo(String value) {
            orCriterion("realname <>", value, "realname");
            return (Criteria) this;
        }

        public Criteria orRealnameGreaterThan(String value) {
            orCriterion("realname >", value, "realname");
            return (Criteria) this;
        }

        public Criteria orRealnameGreaterThanOrEqualTo(String value) {
            orCriterion("realname >=", value, "realname");
            return (Criteria) this;
        }

        public Criteria orRealnameLessThan(String value) {
            orCriterion("realname <", value, "realname");
            return (Criteria) this;
        }

        public Criteria orRealnameLessThanOrEqualTo(String value) {
            orCriterion("realname <=", value, "realname");
            return (Criteria) this;
        }
        public Criteria andRealnameLike(String value) {
            addCriterion("realname like", value, "realname");
            return (Criteria) this;
        }

        public Criteria andRealnameNotLike(String value) {
            addCriterion("realname not like", value, "realname");
            return (Criteria) this;
        }

        public Criteria orRealnameLike(String value) {
            orCriterion("realname like", value, "realname");
            return (Criteria) this;
        }

        public Criteria orRealnameNotLike(String value) {
            orCriterion("realname not like", value, "realname");
            return (Criteria) this;
        }
        
        
        public Criteria andRealnameIn(List<String> values) {
            addCriterion("realname in", values, "realname");
            return (Criteria) this;
        }

        public Criteria andRealnameNotIn(List<String> values) {
            addCriterion("realname not in", values, "realname");
            return (Criteria) this;
        }

        public Criteria andRealnameBetween(String value1, String value2) {
            addCriterion("realname between", value1, value2, "realname");
            return (Criteria) this;
        }

        public Criteria andRealnameNotBetween(String value1, String value2) {
            addCriterion("realname not between", value1, value2, "realname");
            return (Criteria) this;
        }

        public Criteria orRealnameIn(List<String> values) {
            orCriterion("realname in", values, "realname");
            return (Criteria) this;
        }

        public Criteria orRealnameNotIn(List<String> values) {
            orCriterion("realname not in", values, "realname");
            return (Criteria) this;
        }

        public Criteria orRealnameBetween(String value1, String value2) {
            orCriterion("realname between", value1, value2, "realname");
            return (Criteria) this;
        }

        public Criteria orRealnameNotBetween(String value1, String value2) {
            orCriterion("realname not between", value1, value2, "realname");
            return (Criteria) this;
        }
        public Criteria andPasswordIsNull() {
            addCriterion("password is null");
            return (Criteria) this;
        }
        
        public Criteria andPasswordIsNotNull() {
            addCriterion("password is not null");
            return (Criteria) this;
        }
        public Criteria andPasswordEqualTo(String value) {
            addCriterion("password =", value, "password");
            return (Criteria) this;
        }
        
        public Criteria andPasswordNotEqualTo(String value) {
            addCriterion("password <>", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThan(String value) {
            addCriterion("password >", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("password >=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThan(String value) {
            addCriterion("password <", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThanOrEqualTo(String value) {
            addCriterion("password <=", value, "password");
            return (Criteria) this;
        }
        public Criteria orPasswordIsNull() {
            orCriterion("password is null");
            return (Criteria) this;
        }

        public Criteria orPasswordIsNotNull() {
            orCriterion("password is not null");
            return (Criteria) this;
        }
        public Criteria orPasswordEqualTo(String value) {
            orCriterion("password =", value, "password");
            return (Criteria) this;
        }

        public Criteria orPasswordNotEqualTo(String value) {
            orCriterion("password <>", value, "password");
            return (Criteria) this;
        }

        public Criteria orPasswordGreaterThan(String value) {
            orCriterion("password >", value, "password");
            return (Criteria) this;
        }

        public Criteria orPasswordGreaterThanOrEqualTo(String value) {
            orCriterion("password >=", value, "password");
            return (Criteria) this;
        }

        public Criteria orPasswordLessThan(String value) {
            orCriterion("password <", value, "password");
            return (Criteria) this;
        }

        public Criteria orPasswordLessThanOrEqualTo(String value) {
            orCriterion("password <=", value, "password");
            return (Criteria) this;
        }
        public Criteria andPasswordLike(String value) {
            addCriterion("password like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotLike(String value) {
            addCriterion("password not like", value, "password");
            return (Criteria) this;
        }

        public Criteria orPasswordLike(String value) {
            orCriterion("password like", value, "password");
            return (Criteria) this;
        }

        public Criteria orPasswordNotLike(String value) {
            orCriterion("password not like", value, "password");
            return (Criteria) this;
        }
        
        
        public Criteria andPasswordIn(List<String> values) {
            addCriterion("password in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotIn(List<String> values) {
            addCriterion("password not in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordBetween(String value1, String value2) {
            addCriterion("password between", value1, value2, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotBetween(String value1, String value2) {
            addCriterion("password not between", value1, value2, "password");
            return (Criteria) this;
        }

        public Criteria orPasswordIn(List<String> values) {
            orCriterion("password in", values, "password");
            return (Criteria) this;
        }

        public Criteria orPasswordNotIn(List<String> values) {
            orCriterion("password not in", values, "password");
            return (Criteria) this;
        }

        public Criteria orPasswordBetween(String value1, String value2) {
            orCriterion("password between", value1, value2, "password");
            return (Criteria) this;
        }

        public Criteria orPasswordNotBetween(String value1, String value2) {
            orCriterion("password not between", value1, value2, "password");
            return (Criteria) this;
        }
        public Criteria andSaltIsNull() {
            addCriterion("salt is null");
            return (Criteria) this;
        }
        
        public Criteria andSaltIsNotNull() {
            addCriterion("salt is not null");
            return (Criteria) this;
        }
        public Criteria andSaltEqualTo(String value) {
            addCriterion("salt =", value, "salt");
            return (Criteria) this;
        }
        
        public Criteria andSaltNotEqualTo(String value) {
            addCriterion("salt <>", value, "salt");
            return (Criteria) this;
        }

        public Criteria andSaltGreaterThan(String value) {
            addCriterion("salt >", value, "salt");
            return (Criteria) this;
        }

        public Criteria andSaltGreaterThanOrEqualTo(String value) {
            addCriterion("salt >=", value, "salt");
            return (Criteria) this;
        }

        public Criteria andSaltLessThan(String value) {
            addCriterion("salt <", value, "salt");
            return (Criteria) this;
        }

        public Criteria andSaltLessThanOrEqualTo(String value) {
            addCriterion("salt <=", value, "salt");
            return (Criteria) this;
        }
        public Criteria orSaltIsNull() {
            orCriterion("salt is null");
            return (Criteria) this;
        }

        public Criteria orSaltIsNotNull() {
            orCriterion("salt is not null");
            return (Criteria) this;
        }
        public Criteria orSaltEqualTo(String value) {
            orCriterion("salt =", value, "salt");
            return (Criteria) this;
        }

        public Criteria orSaltNotEqualTo(String value) {
            orCriterion("salt <>", value, "salt");
            return (Criteria) this;
        }

        public Criteria orSaltGreaterThan(String value) {
            orCriterion("salt >", value, "salt");
            return (Criteria) this;
        }

        public Criteria orSaltGreaterThanOrEqualTo(String value) {
            orCriterion("salt >=", value, "salt");
            return (Criteria) this;
        }

        public Criteria orSaltLessThan(String value) {
            orCriterion("salt <", value, "salt");
            return (Criteria) this;
        }

        public Criteria orSaltLessThanOrEqualTo(String value) {
            orCriterion("salt <=", value, "salt");
            return (Criteria) this;
        }
        public Criteria andSaltLike(String value) {
            addCriterion("salt like", value, "salt");
            return (Criteria) this;
        }

        public Criteria andSaltNotLike(String value) {
            addCriterion("salt not like", value, "salt");
            return (Criteria) this;
        }

        public Criteria orSaltLike(String value) {
            orCriterion("salt like", value, "salt");
            return (Criteria) this;
        }

        public Criteria orSaltNotLike(String value) {
            orCriterion("salt not like", value, "salt");
            return (Criteria) this;
        }
        
        
        public Criteria andSaltIn(List<String> values) {
            addCriterion("salt in", values, "salt");
            return (Criteria) this;
        }

        public Criteria andSaltNotIn(List<String> values) {
            addCriterion("salt not in", values, "salt");
            return (Criteria) this;
        }

        public Criteria andSaltBetween(String value1, String value2) {
            addCriterion("salt between", value1, value2, "salt");
            return (Criteria) this;
        }

        public Criteria andSaltNotBetween(String value1, String value2) {
            addCriterion("salt not between", value1, value2, "salt");
            return (Criteria) this;
        }

        public Criteria orSaltIn(List<String> values) {
            orCriterion("salt in", values, "salt");
            return (Criteria) this;
        }

        public Criteria orSaltNotIn(List<String> values) {
            orCriterion("salt not in", values, "salt");
            return (Criteria) this;
        }

        public Criteria orSaltBetween(String value1, String value2) {
            orCriterion("salt between", value1, value2, "salt");
            return (Criteria) this;
        }

        public Criteria orSaltNotBetween(String value1, String value2) {
            orCriterion("salt not between", value1, value2, "salt");
            return (Criteria) this;
        }
        public Criteria andAnonymIsNull() {
            addCriterion("anonym is null");
            return (Criteria) this;
        }
        
        public Criteria andAnonymIsNotNull() {
            addCriterion("anonym is not null");
            return (Criteria) this;
        }
        public Criteria andAnonymEqualTo(String value) {
            addCriterion("anonym =", value, "anonym");
            return (Criteria) this;
        }
        
        public Criteria andAnonymNotEqualTo(String value) {
            addCriterion("anonym <>", value, "anonym");
            return (Criteria) this;
        }

        public Criteria andAnonymGreaterThan(String value) {
            addCriterion("anonym >", value, "anonym");
            return (Criteria) this;
        }

        public Criteria andAnonymGreaterThanOrEqualTo(String value) {
            addCriterion("anonym >=", value, "anonym");
            return (Criteria) this;
        }

        public Criteria andAnonymLessThan(String value) {
            addCriterion("anonym <", value, "anonym");
            return (Criteria) this;
        }

        public Criteria andAnonymLessThanOrEqualTo(String value) {
            addCriterion("anonym <=", value, "anonym");
            return (Criteria) this;
        }
        public Criteria orAnonymIsNull() {
            orCriterion("anonym is null");
            return (Criteria) this;
        }

        public Criteria orAnonymIsNotNull() {
            orCriterion("anonym is not null");
            return (Criteria) this;
        }
        public Criteria orAnonymEqualTo(String value) {
            orCriterion("anonym =", value, "anonym");
            return (Criteria) this;
        }

        public Criteria orAnonymNotEqualTo(String value) {
            orCriterion("anonym <>", value, "anonym");
            return (Criteria) this;
        }

        public Criteria orAnonymGreaterThan(String value) {
            orCriterion("anonym >", value, "anonym");
            return (Criteria) this;
        }

        public Criteria orAnonymGreaterThanOrEqualTo(String value) {
            orCriterion("anonym >=", value, "anonym");
            return (Criteria) this;
        }

        public Criteria orAnonymLessThan(String value) {
            orCriterion("anonym <", value, "anonym");
            return (Criteria) this;
        }

        public Criteria orAnonymLessThanOrEqualTo(String value) {
            orCriterion("anonym <=", value, "anonym");
            return (Criteria) this;
        }
        public Criteria andAnonymLike(String value) {
            addCriterion("anonym like", value, "anonym");
            return (Criteria) this;
        }

        public Criteria andAnonymNotLike(String value) {
            addCriterion("anonym not like", value, "anonym");
            return (Criteria) this;
        }

        public Criteria orAnonymLike(String value) {
            orCriterion("anonym like", value, "anonym");
            return (Criteria) this;
        }

        public Criteria orAnonymNotLike(String value) {
            orCriterion("anonym not like", value, "anonym");
            return (Criteria) this;
        }
        
        
        public Criteria andAnonymIn(List<String> values) {
            addCriterion("anonym in", values, "anonym");
            return (Criteria) this;
        }

        public Criteria andAnonymNotIn(List<String> values) {
            addCriterion("anonym not in", values, "anonym");
            return (Criteria) this;
        }

        public Criteria andAnonymBetween(String value1, String value2) {
            addCriterion("anonym between", value1, value2, "anonym");
            return (Criteria) this;
        }

        public Criteria andAnonymNotBetween(String value1, String value2) {
            addCriterion("anonym not between", value1, value2, "anonym");
            return (Criteria) this;
        }

        public Criteria orAnonymIn(List<String> values) {
            orCriterion("anonym in", values, "anonym");
            return (Criteria) this;
        }

        public Criteria orAnonymNotIn(List<String> values) {
            orCriterion("anonym not in", values, "anonym");
            return (Criteria) this;
        }

        public Criteria orAnonymBetween(String value1, String value2) {
            orCriterion("anonym between", value1, value2, "anonym");
            return (Criteria) this;
        }

        public Criteria orAnonymNotBetween(String value1, String value2) {
            orCriterion("anonym not between", value1, value2, "anonym");
            return (Criteria) this;
        }
        public Criteria andWxOpenidIsNull() {
            addCriterion("wx_openid is null");
            return (Criteria) this;
        }
        
        public Criteria andWxOpenidIsNotNull() {
            addCriterion("wx_openid is not null");
            return (Criteria) this;
        }
        public Criteria andWxOpenidEqualTo(String value) {
            addCriterion("wx_openid =", value, "wxOpenid");
            return (Criteria) this;
        }
        
        public Criteria andWxOpenidNotEqualTo(String value) {
            addCriterion("wx_openid <>", value, "wxOpenid");
            return (Criteria) this;
        }

        public Criteria andWxOpenidGreaterThan(String value) {
            addCriterion("wx_openid >", value, "wxOpenid");
            return (Criteria) this;
        }

        public Criteria andWxOpenidGreaterThanOrEqualTo(String value) {
            addCriterion("wx_openid >=", value, "wxOpenid");
            return (Criteria) this;
        }

        public Criteria andWxOpenidLessThan(String value) {
            addCriterion("wx_openid <", value, "wxOpenid");
            return (Criteria) this;
        }

        public Criteria andWxOpenidLessThanOrEqualTo(String value) {
            addCriterion("wx_openid <=", value, "wxOpenid");
            return (Criteria) this;
        }
        public Criteria orWxOpenidIsNull() {
            orCriterion("wx_openid is null");
            return (Criteria) this;
        }

        public Criteria orWxOpenidIsNotNull() {
            orCriterion("wx_openid is not null");
            return (Criteria) this;
        }
        public Criteria orWxOpenidEqualTo(String value) {
            orCriterion("wx_openid =", value, "wxOpenid");
            return (Criteria) this;
        }

        public Criteria orWxOpenidNotEqualTo(String value) {
            orCriterion("wx_openid <>", value, "wxOpenid");
            return (Criteria) this;
        }

        public Criteria orWxOpenidGreaterThan(String value) {
            orCriterion("wx_openid >", value, "wxOpenid");
            return (Criteria) this;
        }

        public Criteria orWxOpenidGreaterThanOrEqualTo(String value) {
            orCriterion("wx_openid >=", value, "wxOpenid");
            return (Criteria) this;
        }

        public Criteria orWxOpenidLessThan(String value) {
            orCriterion("wx_openid <", value, "wxOpenid");
            return (Criteria) this;
        }

        public Criteria orWxOpenidLessThanOrEqualTo(String value) {
            orCriterion("wx_openid <=", value, "wxOpenid");
            return (Criteria) this;
        }
        public Criteria andWxOpenidLike(String value) {
            addCriterion("wx_openid like", value, "wxOpenid");
            return (Criteria) this;
        }

        public Criteria andWxOpenidNotLike(String value) {
            addCriterion("wx_openid not like", value, "wxOpenid");
            return (Criteria) this;
        }

        public Criteria orWxOpenidLike(String value) {
            orCriterion("wx_openid like", value, "wxOpenid");
            return (Criteria) this;
        }

        public Criteria orWxOpenidNotLike(String value) {
            orCriterion("wx_openid not like", value, "wxOpenid");
            return (Criteria) this;
        }
        
        
        public Criteria andWxOpenidIn(List<String> values) {
            addCriterion("wx_openid in", values, "wxOpenid");
            return (Criteria) this;
        }

        public Criteria andWxOpenidNotIn(List<String> values) {
            addCriterion("wx_openid not in", values, "wxOpenid");
            return (Criteria) this;
        }

        public Criteria andWxOpenidBetween(String value1, String value2) {
            addCriterion("wx_openid between", value1, value2, "wxOpenid");
            return (Criteria) this;
        }

        public Criteria andWxOpenidNotBetween(String value1, String value2) {
            addCriterion("wx_openid not between", value1, value2, "wxOpenid");
            return (Criteria) this;
        }

        public Criteria orWxOpenidIn(List<String> values) {
            orCriterion("wx_openid in", values, "wxOpenid");
            return (Criteria) this;
        }

        public Criteria orWxOpenidNotIn(List<String> values) {
            orCriterion("wx_openid not in", values, "wxOpenid");
            return (Criteria) this;
        }

        public Criteria orWxOpenidBetween(String value1, String value2) {
            orCriterion("wx_openid between", value1, value2, "wxOpenid");
            return (Criteria) this;
        }

        public Criteria orWxOpenidNotBetween(String value1, String value2) {
            orCriterion("wx_openid not between", value1, value2, "wxOpenid");
            return (Criteria) this;
        }
        public Criteria andWxUnionidIsNull() {
            addCriterion("wx_unionid is null");
            return (Criteria) this;
        }
        
        public Criteria andWxUnionidIsNotNull() {
            addCriterion("wx_unionid is not null");
            return (Criteria) this;
        }
        public Criteria andWxUnionidEqualTo(String value) {
            addCriterion("wx_unionid =", value, "wxUnionid");
            return (Criteria) this;
        }
        
        public Criteria andWxUnionidNotEqualTo(String value) {
            addCriterion("wx_unionid <>", value, "wxUnionid");
            return (Criteria) this;
        }

        public Criteria andWxUnionidGreaterThan(String value) {
            addCriterion("wx_unionid >", value, "wxUnionid");
            return (Criteria) this;
        }

        public Criteria andWxUnionidGreaterThanOrEqualTo(String value) {
            addCriterion("wx_unionid >=", value, "wxUnionid");
            return (Criteria) this;
        }

        public Criteria andWxUnionidLessThan(String value) {
            addCriterion("wx_unionid <", value, "wxUnionid");
            return (Criteria) this;
        }

        public Criteria andWxUnionidLessThanOrEqualTo(String value) {
            addCriterion("wx_unionid <=", value, "wxUnionid");
            return (Criteria) this;
        }
        public Criteria orWxUnionidIsNull() {
            orCriterion("wx_unionid is null");
            return (Criteria) this;
        }

        public Criteria orWxUnionidIsNotNull() {
            orCriterion("wx_unionid is not null");
            return (Criteria) this;
        }
        public Criteria orWxUnionidEqualTo(String value) {
            orCriterion("wx_unionid =", value, "wxUnionid");
            return (Criteria) this;
        }

        public Criteria orWxUnionidNotEqualTo(String value) {
            orCriterion("wx_unionid <>", value, "wxUnionid");
            return (Criteria) this;
        }

        public Criteria orWxUnionidGreaterThan(String value) {
            orCriterion("wx_unionid >", value, "wxUnionid");
            return (Criteria) this;
        }

        public Criteria orWxUnionidGreaterThanOrEqualTo(String value) {
            orCriterion("wx_unionid >=", value, "wxUnionid");
            return (Criteria) this;
        }

        public Criteria orWxUnionidLessThan(String value) {
            orCriterion("wx_unionid <", value, "wxUnionid");
            return (Criteria) this;
        }

        public Criteria orWxUnionidLessThanOrEqualTo(String value) {
            orCriterion("wx_unionid <=", value, "wxUnionid");
            return (Criteria) this;
        }
        public Criteria andWxUnionidLike(String value) {
            addCriterion("wx_unionid like", value, "wxUnionid");
            return (Criteria) this;
        }

        public Criteria andWxUnionidNotLike(String value) {
            addCriterion("wx_unionid not like", value, "wxUnionid");
            return (Criteria) this;
        }

        public Criteria orWxUnionidLike(String value) {
            orCriterion("wx_unionid like", value, "wxUnionid");
            return (Criteria) this;
        }

        public Criteria orWxUnionidNotLike(String value) {
            orCriterion("wx_unionid not like", value, "wxUnionid");
            return (Criteria) this;
        }
        
        
        public Criteria andWxUnionidIn(List<String> values) {
            addCriterion("wx_unionid in", values, "wxUnionid");
            return (Criteria) this;
        }

        public Criteria andWxUnionidNotIn(List<String> values) {
            addCriterion("wx_unionid not in", values, "wxUnionid");
            return (Criteria) this;
        }

        public Criteria andWxUnionidBetween(String value1, String value2) {
            addCriterion("wx_unionid between", value1, value2, "wxUnionid");
            return (Criteria) this;
        }

        public Criteria andWxUnionidNotBetween(String value1, String value2) {
            addCriterion("wx_unionid not between", value1, value2, "wxUnionid");
            return (Criteria) this;
        }

        public Criteria orWxUnionidIn(List<String> values) {
            orCriterion("wx_unionid in", values, "wxUnionid");
            return (Criteria) this;
        }

        public Criteria orWxUnionidNotIn(List<String> values) {
            orCriterion("wx_unionid not in", values, "wxUnionid");
            return (Criteria) this;
        }

        public Criteria orWxUnionidBetween(String value1, String value2) {
            orCriterion("wx_unionid between", value1, value2, "wxUnionid");
            return (Criteria) this;
        }

        public Criteria orWxUnionidNotBetween(String value1, String value2) {
            orCriterion("wx_unionid not between", value1, value2, "wxUnionid");
            return (Criteria) this;
        }
        public Criteria andQqOpenidIsNull() {
            addCriterion("qq_openid is null");
            return (Criteria) this;
        }
        
        public Criteria andQqOpenidIsNotNull() {
            addCriterion("qq_openid is not null");
            return (Criteria) this;
        }
        public Criteria andQqOpenidEqualTo(String value) {
            addCriterion("qq_openid =", value, "qqOpenid");
            return (Criteria) this;
        }
        
        public Criteria andQqOpenidNotEqualTo(String value) {
            addCriterion("qq_openid <>", value, "qqOpenid");
            return (Criteria) this;
        }

        public Criteria andQqOpenidGreaterThan(String value) {
            addCriterion("qq_openid >", value, "qqOpenid");
            return (Criteria) this;
        }

        public Criteria andQqOpenidGreaterThanOrEqualTo(String value) {
            addCriterion("qq_openid >=", value, "qqOpenid");
            return (Criteria) this;
        }

        public Criteria andQqOpenidLessThan(String value) {
            addCriterion("qq_openid <", value, "qqOpenid");
            return (Criteria) this;
        }

        public Criteria andQqOpenidLessThanOrEqualTo(String value) {
            addCriterion("qq_openid <=", value, "qqOpenid");
            return (Criteria) this;
        }
        public Criteria orQqOpenidIsNull() {
            orCriterion("qq_openid is null");
            return (Criteria) this;
        }

        public Criteria orQqOpenidIsNotNull() {
            orCriterion("qq_openid is not null");
            return (Criteria) this;
        }
        public Criteria orQqOpenidEqualTo(String value) {
            orCriterion("qq_openid =", value, "qqOpenid");
            return (Criteria) this;
        }

        public Criteria orQqOpenidNotEqualTo(String value) {
            orCriterion("qq_openid <>", value, "qqOpenid");
            return (Criteria) this;
        }

        public Criteria orQqOpenidGreaterThan(String value) {
            orCriterion("qq_openid >", value, "qqOpenid");
            return (Criteria) this;
        }

        public Criteria orQqOpenidGreaterThanOrEqualTo(String value) {
            orCriterion("qq_openid >=", value, "qqOpenid");
            return (Criteria) this;
        }

        public Criteria orQqOpenidLessThan(String value) {
            orCriterion("qq_openid <", value, "qqOpenid");
            return (Criteria) this;
        }

        public Criteria orQqOpenidLessThanOrEqualTo(String value) {
            orCriterion("qq_openid <=", value, "qqOpenid");
            return (Criteria) this;
        }
        public Criteria andQqOpenidLike(String value) {
            addCriterion("qq_openid like", value, "qqOpenid");
            return (Criteria) this;
        }

        public Criteria andQqOpenidNotLike(String value) {
            addCriterion("qq_openid not like", value, "qqOpenid");
            return (Criteria) this;
        }

        public Criteria orQqOpenidLike(String value) {
            orCriterion("qq_openid like", value, "qqOpenid");
            return (Criteria) this;
        }

        public Criteria orQqOpenidNotLike(String value) {
            orCriterion("qq_openid not like", value, "qqOpenid");
            return (Criteria) this;
        }
        
        
        public Criteria andQqOpenidIn(List<String> values) {
            addCriterion("qq_openid in", values, "qqOpenid");
            return (Criteria) this;
        }

        public Criteria andQqOpenidNotIn(List<String> values) {
            addCriterion("qq_openid not in", values, "qqOpenid");
            return (Criteria) this;
        }

        public Criteria andQqOpenidBetween(String value1, String value2) {
            addCriterion("qq_openid between", value1, value2, "qqOpenid");
            return (Criteria) this;
        }

        public Criteria andQqOpenidNotBetween(String value1, String value2) {
            addCriterion("qq_openid not between", value1, value2, "qqOpenid");
            return (Criteria) this;
        }

        public Criteria orQqOpenidIn(List<String> values) {
            orCriterion("qq_openid in", values, "qqOpenid");
            return (Criteria) this;
        }

        public Criteria orQqOpenidNotIn(List<String> values) {
            orCriterion("qq_openid not in", values, "qqOpenid");
            return (Criteria) this;
        }

        public Criteria orQqOpenidBetween(String value1, String value2) {
            orCriterion("qq_openid between", value1, value2, "qqOpenid");
            return (Criteria) this;
        }

        public Criteria orQqOpenidNotBetween(String value1, String value2) {
            orCriterion("qq_openid not between", value1, value2, "qqOpenid");
            return (Criteria) this;
        }
        public Criteria andEmailIsNull() {
            addCriterion("email is null");
            return (Criteria) this;
        }
        
        public Criteria andEmailIsNotNull() {
            addCriterion("email is not null");
            return (Criteria) this;
        }
        public Criteria andEmailEqualTo(String value) {
            addCriterion("email =", value, "email");
            return (Criteria) this;
        }
        
        public Criteria andEmailNotEqualTo(String value) {
            addCriterion("email <>", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThan(String value) {
            addCriterion("email >", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThanOrEqualTo(String value) {
            addCriterion("email >=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThan(String value) {
            addCriterion("email <", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThanOrEqualTo(String value) {
            addCriterion("email <=", value, "email");
            return (Criteria) this;
        }
        public Criteria orEmailIsNull() {
            orCriterion("email is null");
            return (Criteria) this;
        }

        public Criteria orEmailIsNotNull() {
            orCriterion("email is not null");
            return (Criteria) this;
        }
        public Criteria orEmailEqualTo(String value) {
            orCriterion("email =", value, "email");
            return (Criteria) this;
        }

        public Criteria orEmailNotEqualTo(String value) {
            orCriterion("email <>", value, "email");
            return (Criteria) this;
        }

        public Criteria orEmailGreaterThan(String value) {
            orCriterion("email >", value, "email");
            return (Criteria) this;
        }

        public Criteria orEmailGreaterThanOrEqualTo(String value) {
            orCriterion("email >=", value, "email");
            return (Criteria) this;
        }

        public Criteria orEmailLessThan(String value) {
            orCriterion("email <", value, "email");
            return (Criteria) this;
        }

        public Criteria orEmailLessThanOrEqualTo(String value) {
            orCriterion("email <=", value, "email");
            return (Criteria) this;
        }
        public Criteria andEmailLike(String value) {
            addCriterion("email like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotLike(String value) {
            addCriterion("email not like", value, "email");
            return (Criteria) this;
        }

        public Criteria orEmailLike(String value) {
            orCriterion("email like", value, "email");
            return (Criteria) this;
        }

        public Criteria orEmailNotLike(String value) {
            orCriterion("email not like", value, "email");
            return (Criteria) this;
        }
        
        
        public Criteria andEmailIn(List<String> values) {
            addCriterion("email in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotIn(List<String> values) {
            addCriterion("email not in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailBetween(String value1, String value2) {
            addCriterion("email between", value1, value2, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotBetween(String value1, String value2) {
            addCriterion("email not between", value1, value2, "email");
            return (Criteria) this;
        }

        public Criteria orEmailIn(List<String> values) {
            orCriterion("email in", values, "email");
            return (Criteria) this;
        }

        public Criteria orEmailNotIn(List<String> values) {
            orCriterion("email not in", values, "email");
            return (Criteria) this;
        }

        public Criteria orEmailBetween(String value1, String value2) {
            orCriterion("email between", value1, value2, "email");
            return (Criteria) this;
        }

        public Criteria orEmailNotBetween(String value1, String value2) {
            orCriterion("email not between", value1, value2, "email");
            return (Criteria) this;
        }
        public Criteria andMobileIsNull() {
            addCriterion("mobile is null");
            return (Criteria) this;
        }
        
        public Criteria andMobileIsNotNull() {
            addCriterion("mobile is not null");
            return (Criteria) this;
        }
        public Criteria andMobileEqualTo(String value) {
            addCriterion("mobile =", value, "mobile");
            return (Criteria) this;
        }
        
        public Criteria andMobileNotEqualTo(String value) {
            addCriterion("mobile <>", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileGreaterThan(String value) {
            addCriterion("mobile >", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileGreaterThanOrEqualTo(String value) {
            addCriterion("mobile >=", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileLessThan(String value) {
            addCriterion("mobile <", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileLessThanOrEqualTo(String value) {
            addCriterion("mobile <=", value, "mobile");
            return (Criteria) this;
        }
        public Criteria orMobileIsNull() {
            orCriterion("mobile is null");
            return (Criteria) this;
        }

        public Criteria orMobileIsNotNull() {
            orCriterion("mobile is not null");
            return (Criteria) this;
        }
        public Criteria orMobileEqualTo(String value) {
            orCriterion("mobile =", value, "mobile");
            return (Criteria) this;
        }

        public Criteria orMobileNotEqualTo(String value) {
            orCriterion("mobile <>", value, "mobile");
            return (Criteria) this;
        }

        public Criteria orMobileGreaterThan(String value) {
            orCriterion("mobile >", value, "mobile");
            return (Criteria) this;
        }

        public Criteria orMobileGreaterThanOrEqualTo(String value) {
            orCriterion("mobile >=", value, "mobile");
            return (Criteria) this;
        }

        public Criteria orMobileLessThan(String value) {
            orCriterion("mobile <", value, "mobile");
            return (Criteria) this;
        }

        public Criteria orMobileLessThanOrEqualTo(String value) {
            orCriterion("mobile <=", value, "mobile");
            return (Criteria) this;
        }
        public Criteria andMobileLike(String value) {
            addCriterion("mobile like", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileNotLike(String value) {
            addCriterion("mobile not like", value, "mobile");
            return (Criteria) this;
        }

        public Criteria orMobileLike(String value) {
            orCriterion("mobile like", value, "mobile");
            return (Criteria) this;
        }

        public Criteria orMobileNotLike(String value) {
            orCriterion("mobile not like", value, "mobile");
            return (Criteria) this;
        }
        
        
        public Criteria andMobileIn(List<String> values) {
            addCriterion("mobile in", values, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileNotIn(List<String> values) {
            addCriterion("mobile not in", values, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileBetween(String value1, String value2) {
            addCriterion("mobile between", value1, value2, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileNotBetween(String value1, String value2) {
            addCriterion("mobile not between", value1, value2, "mobile");
            return (Criteria) this;
        }

        public Criteria orMobileIn(List<String> values) {
            orCriterion("mobile in", values, "mobile");
            return (Criteria) this;
        }

        public Criteria orMobileNotIn(List<String> values) {
            orCriterion("mobile not in", values, "mobile");
            return (Criteria) this;
        }

        public Criteria orMobileBetween(String value1, String value2) {
            orCriterion("mobile between", value1, value2, "mobile");
            return (Criteria) this;
        }

        public Criteria orMobileNotBetween(String value1, String value2) {
            orCriterion("mobile not between", value1, value2, "mobile");
            return (Criteria) this;
        }
        public Criteria andGenderIsNull() {
            addCriterion("gender is null");
            return (Criteria) this;
        }
        
        public Criteria andGenderIsNotNull() {
            addCriterion("gender is not null");
            return (Criteria) this;
        }
        public Criteria andGenderEqualTo(String value) {
            addCriterion("gender =", value, "gender");
            return (Criteria) this;
        }
        
        public Criteria andGenderNotEqualTo(String value) {
            addCriterion("gender <>", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderGreaterThan(String value) {
            addCriterion("gender >", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderGreaterThanOrEqualTo(String value) {
            addCriterion("gender >=", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderLessThan(String value) {
            addCriterion("gender <", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderLessThanOrEqualTo(String value) {
            addCriterion("gender <=", value, "gender");
            return (Criteria) this;
        }
        public Criteria orGenderIsNull() {
            orCriterion("gender is null");
            return (Criteria) this;
        }

        public Criteria orGenderIsNotNull() {
            orCriterion("gender is not null");
            return (Criteria) this;
        }
        public Criteria orGenderEqualTo(String value) {
            orCriterion("gender =", value, "gender");
            return (Criteria) this;
        }

        public Criteria orGenderNotEqualTo(String value) {
            orCriterion("gender <>", value, "gender");
            return (Criteria) this;
        }

        public Criteria orGenderGreaterThan(String value) {
            orCriterion("gender >", value, "gender");
            return (Criteria) this;
        }

        public Criteria orGenderGreaterThanOrEqualTo(String value) {
            orCriterion("gender >=", value, "gender");
            return (Criteria) this;
        }

        public Criteria orGenderLessThan(String value) {
            orCriterion("gender <", value, "gender");
            return (Criteria) this;
        }

        public Criteria orGenderLessThanOrEqualTo(String value) {
            orCriterion("gender <=", value, "gender");
            return (Criteria) this;
        }
        public Criteria andGenderLike(String value) {
            addCriterion("gender like", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderNotLike(String value) {
            addCriterion("gender not like", value, "gender");
            return (Criteria) this;
        }

        public Criteria orGenderLike(String value) {
            orCriterion("gender like", value, "gender");
            return (Criteria) this;
        }

        public Criteria orGenderNotLike(String value) {
            orCriterion("gender not like", value, "gender");
            return (Criteria) this;
        }
        
        
        public Criteria andGenderIn(List<String> values) {
            addCriterion("gender in", values, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderNotIn(List<String> values) {
            addCriterion("gender not in", values, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderBetween(String value1, String value2) {
            addCriterion("gender between", value1, value2, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderNotBetween(String value1, String value2) {
            addCriterion("gender not between", value1, value2, "gender");
            return (Criteria) this;
        }

        public Criteria orGenderIn(List<String> values) {
            orCriterion("gender in", values, "gender");
            return (Criteria) this;
        }

        public Criteria orGenderNotIn(List<String> values) {
            orCriterion("gender not in", values, "gender");
            return (Criteria) this;
        }

        public Criteria orGenderBetween(String value1, String value2) {
            orCriterion("gender between", value1, value2, "gender");
            return (Criteria) this;
        }

        public Criteria orGenderNotBetween(String value1, String value2) {
            orCriterion("gender not between", value1, value2, "gender");
            return (Criteria) this;
        }
        public Criteria andSignatureIsNull() {
            addCriterion("signature is null");
            return (Criteria) this;
        }
        
        public Criteria andSignatureIsNotNull() {
            addCriterion("signature is not null");
            return (Criteria) this;
        }
        public Criteria andSignatureEqualTo(String value) {
            addCriterion("signature =", value, "signature");
            return (Criteria) this;
        }
        
        public Criteria andSignatureNotEqualTo(String value) {
            addCriterion("signature <>", value, "signature");
            return (Criteria) this;
        }

        public Criteria andSignatureGreaterThan(String value) {
            addCriterion("signature >", value, "signature");
            return (Criteria) this;
        }

        public Criteria andSignatureGreaterThanOrEqualTo(String value) {
            addCriterion("signature >=", value, "signature");
            return (Criteria) this;
        }

        public Criteria andSignatureLessThan(String value) {
            addCriterion("signature <", value, "signature");
            return (Criteria) this;
        }

        public Criteria andSignatureLessThanOrEqualTo(String value) {
            addCriterion("signature <=", value, "signature");
            return (Criteria) this;
        }
        public Criteria orSignatureIsNull() {
            orCriterion("signature is null");
            return (Criteria) this;
        }

        public Criteria orSignatureIsNotNull() {
            orCriterion("signature is not null");
            return (Criteria) this;
        }
        public Criteria orSignatureEqualTo(String value) {
            orCriterion("signature =", value, "signature");
            return (Criteria) this;
        }

        public Criteria orSignatureNotEqualTo(String value) {
            orCriterion("signature <>", value, "signature");
            return (Criteria) this;
        }

        public Criteria orSignatureGreaterThan(String value) {
            orCriterion("signature >", value, "signature");
            return (Criteria) this;
        }

        public Criteria orSignatureGreaterThanOrEqualTo(String value) {
            orCriterion("signature >=", value, "signature");
            return (Criteria) this;
        }

        public Criteria orSignatureLessThan(String value) {
            orCriterion("signature <", value, "signature");
            return (Criteria) this;
        }

        public Criteria orSignatureLessThanOrEqualTo(String value) {
            orCriterion("signature <=", value, "signature");
            return (Criteria) this;
        }
        public Criteria andSignatureLike(String value) {
            addCriterion("signature like", value, "signature");
            return (Criteria) this;
        }

        public Criteria andSignatureNotLike(String value) {
            addCriterion("signature not like", value, "signature");
            return (Criteria) this;
        }

        public Criteria orSignatureLike(String value) {
            orCriterion("signature like", value, "signature");
            return (Criteria) this;
        }

        public Criteria orSignatureNotLike(String value) {
            orCriterion("signature not like", value, "signature");
            return (Criteria) this;
        }
        
        
        public Criteria andSignatureIn(List<String> values) {
            addCriterion("signature in", values, "signature");
            return (Criteria) this;
        }

        public Criteria andSignatureNotIn(List<String> values) {
            addCriterion("signature not in", values, "signature");
            return (Criteria) this;
        }

        public Criteria andSignatureBetween(String value1, String value2) {
            addCriterion("signature between", value1, value2, "signature");
            return (Criteria) this;
        }

        public Criteria andSignatureNotBetween(String value1, String value2) {
            addCriterion("signature not between", value1, value2, "signature");
            return (Criteria) this;
        }

        public Criteria orSignatureIn(List<String> values) {
            orCriterion("signature in", values, "signature");
            return (Criteria) this;
        }

        public Criteria orSignatureNotIn(List<String> values) {
            orCriterion("signature not in", values, "signature");
            return (Criteria) this;
        }

        public Criteria orSignatureBetween(String value1, String value2) {
            orCriterion("signature between", value1, value2, "signature");
            return (Criteria) this;
        }

        public Criteria orSignatureNotBetween(String value1, String value2) {
            orCriterion("signature not between", value1, value2, "signature");
            return (Criteria) this;
        }
        public Criteria andBirthdayIsNull() {
            addCriterion("birthday is null");
            return (Criteria) this;
        }
        
        public Criteria andBirthdayIsNotNull() {
            addCriterion("birthday is not null");
            return (Criteria) this;
        }
        public Criteria andBirthdayEqualTo(Date value) {
            addCriterionForJDBCDate("birthday =", value, "birthday");
            return (Criteria) this;
        }
        
        public Criteria andBirthdayNotEqualTo(Date value) {
            addCriterionForJDBCDate("birthday <>", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayGreaterThan(Date value) {
            addCriterionForJDBCDate("birthday >", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("birthday >=", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayLessThan(Date value) {
            addCriterionForJDBCDate("birthday <", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("birthday <=", value, "birthday");
            return (Criteria) this;
        }
        public Criteria orBirthdayIsNull() {
            orCriterion("birthday is null");
            return (Criteria) this;
        }

        public Criteria orBirthdayIsNotNull() {
            orCriterion("birthday is not null");
            return (Criteria) this;
        }
        
        
        public Criteria andBirthdayIn(List<Date> values) {
            addCriterionForJDBCDate("birthday in", values, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayNotIn(List<Date> values) {
            addCriterionForJDBCDate("birthday not in", values, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("birthday between", value1, value2, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("birthday not between", value1, value2, "birthday");
            return (Criteria) this;
        }
        public Criteria andCompanyIsNull() {
            addCriterion("company is null");
            return (Criteria) this;
        }
        
        public Criteria andCompanyIsNotNull() {
            addCriterion("company is not null");
            return (Criteria) this;
        }
        public Criteria andCompanyEqualTo(String value) {
            addCriterion("company =", value, "company");
            return (Criteria) this;
        }
        
        public Criteria andCompanyNotEqualTo(String value) {
            addCriterion("company <>", value, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyGreaterThan(String value) {
            addCriterion("company >", value, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyGreaterThanOrEqualTo(String value) {
            addCriterion("company >=", value, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyLessThan(String value) {
            addCriterion("company <", value, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyLessThanOrEqualTo(String value) {
            addCriterion("company <=", value, "company");
            return (Criteria) this;
        }
        public Criteria orCompanyIsNull() {
            orCriterion("company is null");
            return (Criteria) this;
        }

        public Criteria orCompanyIsNotNull() {
            orCriterion("company is not null");
            return (Criteria) this;
        }
        public Criteria orCompanyEqualTo(String value) {
            orCriterion("company =", value, "company");
            return (Criteria) this;
        }

        public Criteria orCompanyNotEqualTo(String value) {
            orCriterion("company <>", value, "company");
            return (Criteria) this;
        }

        public Criteria orCompanyGreaterThan(String value) {
            orCriterion("company >", value, "company");
            return (Criteria) this;
        }

        public Criteria orCompanyGreaterThanOrEqualTo(String value) {
            orCriterion("company >=", value, "company");
            return (Criteria) this;
        }

        public Criteria orCompanyLessThan(String value) {
            orCriterion("company <", value, "company");
            return (Criteria) this;
        }

        public Criteria orCompanyLessThanOrEqualTo(String value) {
            orCriterion("company <=", value, "company");
            return (Criteria) this;
        }
        public Criteria andCompanyLike(String value) {
            addCriterion("company like", value, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyNotLike(String value) {
            addCriterion("company not like", value, "company");
            return (Criteria) this;
        }

        public Criteria orCompanyLike(String value) {
            orCriterion("company like", value, "company");
            return (Criteria) this;
        }

        public Criteria orCompanyNotLike(String value) {
            orCriterion("company not like", value, "company");
            return (Criteria) this;
        }
        
        
        public Criteria andCompanyIn(List<String> values) {
            addCriterion("company in", values, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyNotIn(List<String> values) {
            addCriterion("company not in", values, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyBetween(String value1, String value2) {
            addCriterion("company between", value1, value2, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyNotBetween(String value1, String value2) {
            addCriterion("company not between", value1, value2, "company");
            return (Criteria) this;
        }

        public Criteria orCompanyIn(List<String> values) {
            orCriterion("company in", values, "company");
            return (Criteria) this;
        }

        public Criteria orCompanyNotIn(List<String> values) {
            orCriterion("company not in", values, "company");
            return (Criteria) this;
        }

        public Criteria orCompanyBetween(String value1, String value2) {
            orCriterion("company between", value1, value2, "company");
            return (Criteria) this;
        }

        public Criteria orCompanyNotBetween(String value1, String value2) {
            orCriterion("company not between", value1, value2, "company");
            return (Criteria) this;
        }
        public Criteria andAddressIsNull() {
            addCriterion("address is null");
            return (Criteria) this;
        }
        
        public Criteria andAddressIsNotNull() {
            addCriterion("address is not null");
            return (Criteria) this;
        }
        public Criteria andAddressEqualTo(String value) {
            addCriterion("address =", value, "address");
            return (Criteria) this;
        }
        
        public Criteria andAddressNotEqualTo(String value) {
            addCriterion("address <>", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThan(String value) {
            addCriterion("address >", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThanOrEqualTo(String value) {
            addCriterion("address >=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThan(String value) {
            addCriterion("address <", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThanOrEqualTo(String value) {
            addCriterion("address <=", value, "address");
            return (Criteria) this;
        }
        public Criteria orAddressIsNull() {
            orCriterion("address is null");
            return (Criteria) this;
        }

        public Criteria orAddressIsNotNull() {
            orCriterion("address is not null");
            return (Criteria) this;
        }
        public Criteria orAddressEqualTo(String value) {
            orCriterion("address =", value, "address");
            return (Criteria) this;
        }

        public Criteria orAddressNotEqualTo(String value) {
            orCriterion("address <>", value, "address");
            return (Criteria) this;
        }

        public Criteria orAddressGreaterThan(String value) {
            orCriterion("address >", value, "address");
            return (Criteria) this;
        }

        public Criteria orAddressGreaterThanOrEqualTo(String value) {
            orCriterion("address >=", value, "address");
            return (Criteria) this;
        }

        public Criteria orAddressLessThan(String value) {
            orCriterion("address <", value, "address");
            return (Criteria) this;
        }

        public Criteria orAddressLessThanOrEqualTo(String value) {
            orCriterion("address <=", value, "address");
            return (Criteria) this;
        }
        public Criteria andAddressLike(String value) {
            addCriterion("address like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotLike(String value) {
            addCriterion("address not like", value, "address");
            return (Criteria) this;
        }

        public Criteria orAddressLike(String value) {
            orCriterion("address like", value, "address");
            return (Criteria) this;
        }

        public Criteria orAddressNotLike(String value) {
            orCriterion("address not like", value, "address");
            return (Criteria) this;
        }
        
        
        public Criteria andAddressIn(List<String> values) {
            addCriterion("address in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotIn(List<String> values) {
            addCriterion("address not in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressBetween(String value1, String value2) {
            addCriterion("address between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotBetween(String value1, String value2) {
            addCriterion("address not between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria orAddressIn(List<String> values) {
            orCriterion("address in", values, "address");
            return (Criteria) this;
        }

        public Criteria orAddressNotIn(List<String> values) {
            orCriterion("address not in", values, "address");
            return (Criteria) this;
        }

        public Criteria orAddressBetween(String value1, String value2) {
            orCriterion("address between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria orAddressNotBetween(String value1, String value2) {
            orCriterion("address not between", value1, value2, "address");
            return (Criteria) this;
        }
        public Criteria andZipcodeIsNull() {
            addCriterion("zipcode is null");
            return (Criteria) this;
        }
        
        public Criteria andZipcodeIsNotNull() {
            addCriterion("zipcode is not null");
            return (Criteria) this;
        }
        public Criteria andZipcodeEqualTo(String value) {
            addCriterion("zipcode =", value, "zipcode");
            return (Criteria) this;
        }
        
        public Criteria andZipcodeNotEqualTo(String value) {
            addCriterion("zipcode <>", value, "zipcode");
            return (Criteria) this;
        }

        public Criteria andZipcodeGreaterThan(String value) {
            addCriterion("zipcode >", value, "zipcode");
            return (Criteria) this;
        }

        public Criteria andZipcodeGreaterThanOrEqualTo(String value) {
            addCriterion("zipcode >=", value, "zipcode");
            return (Criteria) this;
        }

        public Criteria andZipcodeLessThan(String value) {
            addCriterion("zipcode <", value, "zipcode");
            return (Criteria) this;
        }

        public Criteria andZipcodeLessThanOrEqualTo(String value) {
            addCriterion("zipcode <=", value, "zipcode");
            return (Criteria) this;
        }
        public Criteria orZipcodeIsNull() {
            orCriterion("zipcode is null");
            return (Criteria) this;
        }

        public Criteria orZipcodeIsNotNull() {
            orCriterion("zipcode is not null");
            return (Criteria) this;
        }
        public Criteria orZipcodeEqualTo(String value) {
            orCriterion("zipcode =", value, "zipcode");
            return (Criteria) this;
        }

        public Criteria orZipcodeNotEqualTo(String value) {
            orCriterion("zipcode <>", value, "zipcode");
            return (Criteria) this;
        }

        public Criteria orZipcodeGreaterThan(String value) {
            orCriterion("zipcode >", value, "zipcode");
            return (Criteria) this;
        }

        public Criteria orZipcodeGreaterThanOrEqualTo(String value) {
            orCriterion("zipcode >=", value, "zipcode");
            return (Criteria) this;
        }

        public Criteria orZipcodeLessThan(String value) {
            orCriterion("zipcode <", value, "zipcode");
            return (Criteria) this;
        }

        public Criteria orZipcodeLessThanOrEqualTo(String value) {
            orCriterion("zipcode <=", value, "zipcode");
            return (Criteria) this;
        }
        public Criteria andZipcodeLike(String value) {
            addCriterion("zipcode like", value, "zipcode");
            return (Criteria) this;
        }

        public Criteria andZipcodeNotLike(String value) {
            addCriterion("zipcode not like", value, "zipcode");
            return (Criteria) this;
        }

        public Criteria orZipcodeLike(String value) {
            orCriterion("zipcode like", value, "zipcode");
            return (Criteria) this;
        }

        public Criteria orZipcodeNotLike(String value) {
            orCriterion("zipcode not like", value, "zipcode");
            return (Criteria) this;
        }
        
        
        public Criteria andZipcodeIn(List<String> values) {
            addCriterion("zipcode in", values, "zipcode");
            return (Criteria) this;
        }

        public Criteria andZipcodeNotIn(List<String> values) {
            addCriterion("zipcode not in", values, "zipcode");
            return (Criteria) this;
        }

        public Criteria andZipcodeBetween(String value1, String value2) {
            addCriterion("zipcode between", value1, value2, "zipcode");
            return (Criteria) this;
        }

        public Criteria andZipcodeNotBetween(String value1, String value2) {
            addCriterion("zipcode not between", value1, value2, "zipcode");
            return (Criteria) this;
        }

        public Criteria orZipcodeIn(List<String> values) {
            orCriterion("zipcode in", values, "zipcode");
            return (Criteria) this;
        }

        public Criteria orZipcodeNotIn(List<String> values) {
            orCriterion("zipcode not in", values, "zipcode");
            return (Criteria) this;
        }

        public Criteria orZipcodeBetween(String value1, String value2) {
            orCriterion("zipcode between", value1, value2, "zipcode");
            return (Criteria) this;
        }

        public Criteria orZipcodeNotBetween(String value1, String value2) {
            orCriterion("zipcode not between", value1, value2, "zipcode");
            return (Criteria) this;
        }
        public Criteria andSiteIsNull() {
            addCriterion("site is null");
            return (Criteria) this;
        }
        
        public Criteria andSiteIsNotNull() {
            addCriterion("site is not null");
            return (Criteria) this;
        }
        public Criteria andSiteEqualTo(String value) {
            addCriterion("site =", value, "site");
            return (Criteria) this;
        }
        
        public Criteria andSiteNotEqualTo(String value) {
            addCriterion("site <>", value, "site");
            return (Criteria) this;
        }

        public Criteria andSiteGreaterThan(String value) {
            addCriterion("site >", value, "site");
            return (Criteria) this;
        }

        public Criteria andSiteGreaterThanOrEqualTo(String value) {
            addCriterion("site >=", value, "site");
            return (Criteria) this;
        }

        public Criteria andSiteLessThan(String value) {
            addCriterion("site <", value, "site");
            return (Criteria) this;
        }

        public Criteria andSiteLessThanOrEqualTo(String value) {
            addCriterion("site <=", value, "site");
            return (Criteria) this;
        }
        public Criteria orSiteIsNull() {
            orCriterion("site is null");
            return (Criteria) this;
        }

        public Criteria orSiteIsNotNull() {
            orCriterion("site is not null");
            return (Criteria) this;
        }
        public Criteria orSiteEqualTo(String value) {
            orCriterion("site =", value, "site");
            return (Criteria) this;
        }

        public Criteria orSiteNotEqualTo(String value) {
            orCriterion("site <>", value, "site");
            return (Criteria) this;
        }

        public Criteria orSiteGreaterThan(String value) {
            orCriterion("site >", value, "site");
            return (Criteria) this;
        }

        public Criteria orSiteGreaterThanOrEqualTo(String value) {
            orCriterion("site >=", value, "site");
            return (Criteria) this;
        }

        public Criteria orSiteLessThan(String value) {
            orCriterion("site <", value, "site");
            return (Criteria) this;
        }

        public Criteria orSiteLessThanOrEqualTo(String value) {
            orCriterion("site <=", value, "site");
            return (Criteria) this;
        }
        public Criteria andSiteLike(String value) {
            addCriterion("site like", value, "site");
            return (Criteria) this;
        }

        public Criteria andSiteNotLike(String value) {
            addCriterion("site not like", value, "site");
            return (Criteria) this;
        }

        public Criteria orSiteLike(String value) {
            orCriterion("site like", value, "site");
            return (Criteria) this;
        }

        public Criteria orSiteNotLike(String value) {
            orCriterion("site not like", value, "site");
            return (Criteria) this;
        }
        
        
        public Criteria andSiteIn(List<String> values) {
            addCriterion("site in", values, "site");
            return (Criteria) this;
        }

        public Criteria andSiteNotIn(List<String> values) {
            addCriterion("site not in", values, "site");
            return (Criteria) this;
        }

        public Criteria andSiteBetween(String value1, String value2) {
            addCriterion("site between", value1, value2, "site");
            return (Criteria) this;
        }

        public Criteria andSiteNotBetween(String value1, String value2) {
            addCriterion("site not between", value1, value2, "site");
            return (Criteria) this;
        }

        public Criteria orSiteIn(List<String> values) {
            orCriterion("site in", values, "site");
            return (Criteria) this;
        }

        public Criteria orSiteNotIn(List<String> values) {
            orCriterion("site not in", values, "site");
            return (Criteria) this;
        }

        public Criteria orSiteBetween(String value1, String value2) {
            orCriterion("site between", value1, value2, "site");
            return (Criteria) this;
        }

        public Criteria orSiteNotBetween(String value1, String value2) {
            orCriterion("site not between", value1, value2, "site");
            return (Criteria) this;
        }
        public Criteria andAvatarIsNull() {
            addCriterion("avatar is null");
            return (Criteria) this;
        }
        
        public Criteria andAvatarIsNotNull() {
            addCriterion("avatar is not null");
            return (Criteria) this;
        }
        public Criteria andAvatarEqualTo(String value) {
            addCriterion("avatar =", value, "avatar");
            return (Criteria) this;
        }
        
        public Criteria andAvatarNotEqualTo(String value) {
            addCriterion("avatar <>", value, "avatar");
            return (Criteria) this;
        }

        public Criteria andAvatarGreaterThan(String value) {
            addCriterion("avatar >", value, "avatar");
            return (Criteria) this;
        }

        public Criteria andAvatarGreaterThanOrEqualTo(String value) {
            addCriterion("avatar >=", value, "avatar");
            return (Criteria) this;
        }

        public Criteria andAvatarLessThan(String value) {
            addCriterion("avatar <", value, "avatar");
            return (Criteria) this;
        }

        public Criteria andAvatarLessThanOrEqualTo(String value) {
            addCriterion("avatar <=", value, "avatar");
            return (Criteria) this;
        }
        public Criteria orAvatarIsNull() {
            orCriterion("avatar is null");
            return (Criteria) this;
        }

        public Criteria orAvatarIsNotNull() {
            orCriterion("avatar is not null");
            return (Criteria) this;
        }
        public Criteria orAvatarEqualTo(String value) {
            orCriterion("avatar =", value, "avatar");
            return (Criteria) this;
        }

        public Criteria orAvatarNotEqualTo(String value) {
            orCriterion("avatar <>", value, "avatar");
            return (Criteria) this;
        }

        public Criteria orAvatarGreaterThan(String value) {
            orCriterion("avatar >", value, "avatar");
            return (Criteria) this;
        }

        public Criteria orAvatarGreaterThanOrEqualTo(String value) {
            orCriterion("avatar >=", value, "avatar");
            return (Criteria) this;
        }

        public Criteria orAvatarLessThan(String value) {
            orCriterion("avatar <", value, "avatar");
            return (Criteria) this;
        }

        public Criteria orAvatarLessThanOrEqualTo(String value) {
            orCriterion("avatar <=", value, "avatar");
            return (Criteria) this;
        }
        public Criteria andAvatarLike(String value) {
            addCriterion("avatar like", value, "avatar");
            return (Criteria) this;
        }

        public Criteria andAvatarNotLike(String value) {
            addCriterion("avatar not like", value, "avatar");
            return (Criteria) this;
        }

        public Criteria orAvatarLike(String value) {
            orCriterion("avatar like", value, "avatar");
            return (Criteria) this;
        }

        public Criteria orAvatarNotLike(String value) {
            orCriterion("avatar not like", value, "avatar");
            return (Criteria) this;
        }
        
        
        public Criteria andAvatarIn(List<String> values) {
            addCriterion("avatar in", values, "avatar");
            return (Criteria) this;
        }

        public Criteria andAvatarNotIn(List<String> values) {
            addCriterion("avatar not in", values, "avatar");
            return (Criteria) this;
        }

        public Criteria andAvatarBetween(String value1, String value2) {
            addCriterion("avatar between", value1, value2, "avatar");
            return (Criteria) this;
        }

        public Criteria andAvatarNotBetween(String value1, String value2) {
            addCriterion("avatar not between", value1, value2, "avatar");
            return (Criteria) this;
        }

        public Criteria orAvatarIn(List<String> values) {
            orCriterion("avatar in", values, "avatar");
            return (Criteria) this;
        }

        public Criteria orAvatarNotIn(List<String> values) {
            orCriterion("avatar not in", values, "avatar");
            return (Criteria) this;
        }

        public Criteria orAvatarBetween(String value1, String value2) {
            orCriterion("avatar between", value1, value2, "avatar");
            return (Criteria) this;
        }

        public Criteria orAvatarNotBetween(String value1, String value2) {
            orCriterion("avatar not between", value1, value2, "avatar");
            return (Criteria) this;
        }
        public Criteria andIdcardtypeIsNull() {
            addCriterion("idcardtype is null");
            return (Criteria) this;
        }
        
        public Criteria andIdcardtypeIsNotNull() {
            addCriterion("idcardtype is not null");
            return (Criteria) this;
        }
        public Criteria andIdcardtypeEqualTo(String value) {
            addCriterion("idcardtype =", value, "idcardtype");
            return (Criteria) this;
        }
        
        public Criteria andIdcardtypeNotEqualTo(String value) {
            addCriterion("idcardtype <>", value, "idcardtype");
            return (Criteria) this;
        }

        public Criteria andIdcardtypeGreaterThan(String value) {
            addCriterion("idcardtype >", value, "idcardtype");
            return (Criteria) this;
        }

        public Criteria andIdcardtypeGreaterThanOrEqualTo(String value) {
            addCriterion("idcardtype >=", value, "idcardtype");
            return (Criteria) this;
        }

        public Criteria andIdcardtypeLessThan(String value) {
            addCriterion("idcardtype <", value, "idcardtype");
            return (Criteria) this;
        }

        public Criteria andIdcardtypeLessThanOrEqualTo(String value) {
            addCriterion("idcardtype <=", value, "idcardtype");
            return (Criteria) this;
        }
        public Criteria orIdcardtypeIsNull() {
            orCriterion("idcardtype is null");
            return (Criteria) this;
        }

        public Criteria orIdcardtypeIsNotNull() {
            orCriterion("idcardtype is not null");
            return (Criteria) this;
        }
        public Criteria orIdcardtypeEqualTo(String value) {
            orCriterion("idcardtype =", value, "idcardtype");
            return (Criteria) this;
        }

        public Criteria orIdcardtypeNotEqualTo(String value) {
            orCriterion("idcardtype <>", value, "idcardtype");
            return (Criteria) this;
        }

        public Criteria orIdcardtypeGreaterThan(String value) {
            orCriterion("idcardtype >", value, "idcardtype");
            return (Criteria) this;
        }

        public Criteria orIdcardtypeGreaterThanOrEqualTo(String value) {
            orCriterion("idcardtype >=", value, "idcardtype");
            return (Criteria) this;
        }

        public Criteria orIdcardtypeLessThan(String value) {
            orCriterion("idcardtype <", value, "idcardtype");
            return (Criteria) this;
        }

        public Criteria orIdcardtypeLessThanOrEqualTo(String value) {
            orCriterion("idcardtype <=", value, "idcardtype");
            return (Criteria) this;
        }
        public Criteria andIdcardtypeLike(String value) {
            addCriterion("idcardtype like", value, "idcardtype");
            return (Criteria) this;
        }

        public Criteria andIdcardtypeNotLike(String value) {
            addCriterion("idcardtype not like", value, "idcardtype");
            return (Criteria) this;
        }

        public Criteria orIdcardtypeLike(String value) {
            orCriterion("idcardtype like", value, "idcardtype");
            return (Criteria) this;
        }

        public Criteria orIdcardtypeNotLike(String value) {
            orCriterion("idcardtype not like", value, "idcardtype");
            return (Criteria) this;
        }
        
        
        public Criteria andIdcardtypeIn(List<String> values) {
            addCriterion("idcardtype in", values, "idcardtype");
            return (Criteria) this;
        }

        public Criteria andIdcardtypeNotIn(List<String> values) {
            addCriterion("idcardtype not in", values, "idcardtype");
            return (Criteria) this;
        }

        public Criteria andIdcardtypeBetween(String value1, String value2) {
            addCriterion("idcardtype between", value1, value2, "idcardtype");
            return (Criteria) this;
        }

        public Criteria andIdcardtypeNotBetween(String value1, String value2) {
            addCriterion("idcardtype not between", value1, value2, "idcardtype");
            return (Criteria) this;
        }

        public Criteria orIdcardtypeIn(List<String> values) {
            orCriterion("idcardtype in", values, "idcardtype");
            return (Criteria) this;
        }

        public Criteria orIdcardtypeNotIn(List<String> values) {
            orCriterion("idcardtype not in", values, "idcardtype");
            return (Criteria) this;
        }

        public Criteria orIdcardtypeBetween(String value1, String value2) {
            orCriterion("idcardtype between", value1, value2, "idcardtype");
            return (Criteria) this;
        }

        public Criteria orIdcardtypeNotBetween(String value1, String value2) {
            orCriterion("idcardtype not between", value1, value2, "idcardtype");
            return (Criteria) this;
        }
        public Criteria andIdcardIsNull() {
            addCriterion("idcard is null");
            return (Criteria) this;
        }
        
        public Criteria andIdcardIsNotNull() {
            addCriterion("idcard is not null");
            return (Criteria) this;
        }
        public Criteria andIdcardEqualTo(String value) {
            addCriterion("idcard =", value, "idcard");
            return (Criteria) this;
        }
        
        public Criteria andIdcardNotEqualTo(String value) {
            addCriterion("idcard <>", value, "idcard");
            return (Criteria) this;
        }

        public Criteria andIdcardGreaterThan(String value) {
            addCriterion("idcard >", value, "idcard");
            return (Criteria) this;
        }

        public Criteria andIdcardGreaterThanOrEqualTo(String value) {
            addCriterion("idcard >=", value, "idcard");
            return (Criteria) this;
        }

        public Criteria andIdcardLessThan(String value) {
            addCriterion("idcard <", value, "idcard");
            return (Criteria) this;
        }

        public Criteria andIdcardLessThanOrEqualTo(String value) {
            addCriterion("idcard <=", value, "idcard");
            return (Criteria) this;
        }
        public Criteria orIdcardIsNull() {
            orCriterion("idcard is null");
            return (Criteria) this;
        }

        public Criteria orIdcardIsNotNull() {
            orCriterion("idcard is not null");
            return (Criteria) this;
        }
        public Criteria orIdcardEqualTo(String value) {
            orCriterion("idcard =", value, "idcard");
            return (Criteria) this;
        }

        public Criteria orIdcardNotEqualTo(String value) {
            orCriterion("idcard <>", value, "idcard");
            return (Criteria) this;
        }

        public Criteria orIdcardGreaterThan(String value) {
            orCriterion("idcard >", value, "idcard");
            return (Criteria) this;
        }

        public Criteria orIdcardGreaterThanOrEqualTo(String value) {
            orCriterion("idcard >=", value, "idcard");
            return (Criteria) this;
        }

        public Criteria orIdcardLessThan(String value) {
            orCriterion("idcard <", value, "idcard");
            return (Criteria) this;
        }

        public Criteria orIdcardLessThanOrEqualTo(String value) {
            orCriterion("idcard <=", value, "idcard");
            return (Criteria) this;
        }
        public Criteria andIdcardLike(String value) {
            addCriterion("idcard like", value, "idcard");
            return (Criteria) this;
        }

        public Criteria andIdcardNotLike(String value) {
            addCriterion("idcard not like", value, "idcard");
            return (Criteria) this;
        }

        public Criteria orIdcardLike(String value) {
            orCriterion("idcard like", value, "idcard");
            return (Criteria) this;
        }

        public Criteria orIdcardNotLike(String value) {
            orCriterion("idcard not like", value, "idcard");
            return (Criteria) this;
        }
        
        
        public Criteria andIdcardIn(List<String> values) {
            addCriterion("idcard in", values, "idcard");
            return (Criteria) this;
        }

        public Criteria andIdcardNotIn(List<String> values) {
            addCriterion("idcard not in", values, "idcard");
            return (Criteria) this;
        }

        public Criteria andIdcardBetween(String value1, String value2) {
            addCriterion("idcard between", value1, value2, "idcard");
            return (Criteria) this;
        }

        public Criteria andIdcardNotBetween(String value1, String value2) {
            addCriterion("idcard not between", value1, value2, "idcard");
            return (Criteria) this;
        }

        public Criteria orIdcardIn(List<String> values) {
            orCriterion("idcard in", values, "idcard");
            return (Criteria) this;
        }

        public Criteria orIdcardNotIn(List<String> values) {
            orCriterion("idcard not in", values, "idcard");
            return (Criteria) this;
        }

        public Criteria orIdcardBetween(String value1, String value2) {
            orCriterion("idcard between", value1, value2, "idcard");
            return (Criteria) this;
        }

        public Criteria orIdcardNotBetween(String value1, String value2) {
            orCriterion("idcard not between", value1, value2, "idcard");
            return (Criteria) this;
        }
        public Criteria andRemarkIsNull() {
            addCriterion("remark is null");
            return (Criteria) this;
        }
        
        public Criteria andRemarkIsNotNull() {
            addCriterion("remark is not null");
            return (Criteria) this;
        }
        public Criteria andRemarkEqualTo(String value) {
            addCriterion("remark =", value, "remark");
            return (Criteria) this;
        }
        
        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("remark <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("remark >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("remark >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("remark <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("remark <=", value, "remark");
            return (Criteria) this;
        }
        public Criteria orRemarkIsNull() {
            orCriterion("remark is null");
            return (Criteria) this;
        }

        public Criteria orRemarkIsNotNull() {
            orCriterion("remark is not null");
            return (Criteria) this;
        }
        public Criteria orRemarkEqualTo(String value) {
            orCriterion("remark =", value, "remark");
            return (Criteria) this;
        }

        public Criteria orRemarkNotEqualTo(String value) {
            orCriterion("remark <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria orRemarkGreaterThan(String value) {
            orCriterion("remark >", value, "remark");
            return (Criteria) this;
        }

        public Criteria orRemarkGreaterThanOrEqualTo(String value) {
            orCriterion("remark >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria orRemarkLessThan(String value) {
            orCriterion("remark <", value, "remark");
            return (Criteria) this;
        }

        public Criteria orRemarkLessThanOrEqualTo(String value) {
            orCriterion("remark <=", value, "remark");
            return (Criteria) this;
        }
        public Criteria andRemarkLike(String value) {
            addCriterion("remark like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("remark not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria orRemarkLike(String value) {
            orCriterion("remark like", value, "remark");
            return (Criteria) this;
        }

        public Criteria orRemarkNotLike(String value) {
            orCriterion("remark not like", value, "remark");
            return (Criteria) this;
        }
        
        
        public Criteria andRemarkIn(List<String> values) {
            addCriterion("remark in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("remark not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("remark between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("remark not between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria orRemarkIn(List<String> values) {
            orCriterion("remark in", values, "remark");
            return (Criteria) this;
        }

        public Criteria orRemarkNotIn(List<String> values) {
            orCriterion("remark not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria orRemarkBetween(String value1, String value2) {
            orCriterion("remark between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria orRemarkNotBetween(String value1, String value2) {
            orCriterion("remark not between", value1, value2, "remark");
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
        public Criteria orStatusIsNull() {
            orCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria orStatusIsNotNull() {
            orCriterion("status is not null");
            return (Criteria) this;
        }
        public Criteria orStatusEqualTo(String value) {
            orCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria orStatusNotEqualTo(String value) {
            orCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria orStatusGreaterThan(String value) {
            orCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria orStatusGreaterThanOrEqualTo(String value) {
            orCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria orStatusLessThan(String value) {
            orCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria orStatusLessThanOrEqualTo(String value) {
            orCriterion("status <=", value, "status");
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

        public Criteria orStatusLike(String value) {
            orCriterion("status like", value, "status");
            return (Criteria) this;
        }

        public Criteria orStatusNotLike(String value) {
            orCriterion("status not like", value, "status");
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

        public Criteria orStatusIn(List<String> values) {
            orCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria orStatusNotIn(List<String> values) {
            orCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria orStatusBetween(String value1, String value2) {
            orCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria orStatusNotBetween(String value1, String value2) {
            orCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }
        public Criteria andCreatedIsNull() {
            addCriterion("created is null");
            return (Criteria) this;
        }
        
        public Criteria andCreatedIsNotNull() {
            addCriterion("created is not null");
            return (Criteria) this;
        }
        public Criteria andCreatedEqualTo(Date value) {
            addCriterionForJDBCDate("created =", value, "created");
            return (Criteria) this;
        }
        
        public Criteria andCreatedNotEqualTo(Date value) {
            addCriterionForJDBCDate("created <>", value, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedGreaterThan(Date value) {
            addCriterionForJDBCDate("created >", value, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("created >=", value, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedLessThan(Date value) {
            addCriterionForJDBCDate("created <", value, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("created <=", value, "created");
            return (Criteria) this;
        }
        public Criteria orCreatedIsNull() {
            orCriterion("created is null");
            return (Criteria) this;
        }

        public Criteria orCreatedIsNotNull() {
            orCriterion("created is not null");
            return (Criteria) this;
        }
        
        
        public Criteria andCreatedIn(List<Date> values) {
            addCriterionForJDBCDate("created in", values, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedNotIn(List<Date> values) {
            addCriterionForJDBCDate("created not in", values, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("created between", value1, value2, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("created not between", value1, value2, "created");
            return (Criteria) this;
        }
        public Criteria andCreateSourceIsNull() {
            addCriterion("create_source is null");
            return (Criteria) this;
        }
        
        public Criteria andCreateSourceIsNotNull() {
            addCriterion("create_source is not null");
            return (Criteria) this;
        }
        public Criteria andCreateSourceEqualTo(String value) {
            addCriterion("create_source =", value, "createSource");
            return (Criteria) this;
        }
        
        public Criteria andCreateSourceNotEqualTo(String value) {
            addCriterion("create_source <>", value, "createSource");
            return (Criteria) this;
        }

        public Criteria andCreateSourceGreaterThan(String value) {
            addCriterion("create_source >", value, "createSource");
            return (Criteria) this;
        }

        public Criteria andCreateSourceGreaterThanOrEqualTo(String value) {
            addCriterion("create_source >=", value, "createSource");
            return (Criteria) this;
        }

        public Criteria andCreateSourceLessThan(String value) {
            addCriterion("create_source <", value, "createSource");
            return (Criteria) this;
        }

        public Criteria andCreateSourceLessThanOrEqualTo(String value) {
            addCriterion("create_source <=", value, "createSource");
            return (Criteria) this;
        }
        public Criteria orCreateSourceIsNull() {
            orCriterion("create_source is null");
            return (Criteria) this;
        }

        public Criteria orCreateSourceIsNotNull() {
            orCriterion("create_source is not null");
            return (Criteria) this;
        }
        public Criteria orCreateSourceEqualTo(String value) {
            orCriterion("create_source =", value, "createSource");
            return (Criteria) this;
        }

        public Criteria orCreateSourceNotEqualTo(String value) {
            orCriterion("create_source <>", value, "createSource");
            return (Criteria) this;
        }

        public Criteria orCreateSourceGreaterThan(String value) {
            orCriterion("create_source >", value, "createSource");
            return (Criteria) this;
        }

        public Criteria orCreateSourceGreaterThanOrEqualTo(String value) {
            orCriterion("create_source >=", value, "createSource");
            return (Criteria) this;
        }

        public Criteria orCreateSourceLessThan(String value) {
            orCriterion("create_source <", value, "createSource");
            return (Criteria) this;
        }

        public Criteria orCreateSourceLessThanOrEqualTo(String value) {
            orCriterion("create_source <=", value, "createSource");
            return (Criteria) this;
        }
        public Criteria andCreateSourceLike(String value) {
            addCriterion("create_source like", value, "createSource");
            return (Criteria) this;
        }

        public Criteria andCreateSourceNotLike(String value) {
            addCriterion("create_source not like", value, "createSource");
            return (Criteria) this;
        }

        public Criteria orCreateSourceLike(String value) {
            orCriterion("create_source like", value, "createSource");
            return (Criteria) this;
        }

        public Criteria orCreateSourceNotLike(String value) {
            orCriterion("create_source not like", value, "createSource");
            return (Criteria) this;
        }
        
        
        public Criteria andCreateSourceIn(List<String> values) {
            addCriterion("create_source in", values, "createSource");
            return (Criteria) this;
        }

        public Criteria andCreateSourceNotIn(List<String> values) {
            addCriterion("create_source not in", values, "createSource");
            return (Criteria) this;
        }

        public Criteria andCreateSourceBetween(String value1, String value2) {
            addCriterion("create_source between", value1, value2, "createSource");
            return (Criteria) this;
        }

        public Criteria andCreateSourceNotBetween(String value1, String value2) {
            addCriterion("create_source not between", value1, value2, "createSource");
            return (Criteria) this;
        }

        public Criteria orCreateSourceIn(List<String> values) {
            orCriterion("create_source in", values, "createSource");
            return (Criteria) this;
        }

        public Criteria orCreateSourceNotIn(List<String> values) {
            orCriterion("create_source not in", values, "createSource");
            return (Criteria) this;
        }

        public Criteria orCreateSourceBetween(String value1, String value2) {
            orCriterion("create_source between", value1, value2, "createSource");
            return (Criteria) this;
        }

        public Criteria orCreateSourceNotBetween(String value1, String value2) {
            orCriterion("create_source not between", value1, value2, "createSource");
            return (Criteria) this;
        }
        public Criteria andLoggedIsNull() {
            addCriterion("logged is null");
            return (Criteria) this;
        }
        
        public Criteria andLoggedIsNotNull() {
            addCriterion("logged is not null");
            return (Criteria) this;
        }
        public Criteria andLoggedEqualTo(Date value) {
            addCriterionForJDBCDate("logged =", value, "logged");
            return (Criteria) this;
        }
        
        public Criteria andLoggedNotEqualTo(Date value) {
            addCriterionForJDBCDate("logged <>", value, "logged");
            return (Criteria) this;
        }

        public Criteria andLoggedGreaterThan(Date value) {
            addCriterionForJDBCDate("logged >", value, "logged");
            return (Criteria) this;
        }

        public Criteria andLoggedGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("logged >=", value, "logged");
            return (Criteria) this;
        }

        public Criteria andLoggedLessThan(Date value) {
            addCriterionForJDBCDate("logged <", value, "logged");
            return (Criteria) this;
        }

        public Criteria andLoggedLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("logged <=", value, "logged");
            return (Criteria) this;
        }
        public Criteria orLoggedIsNull() {
            orCriterion("logged is null");
            return (Criteria) this;
        }

        public Criteria orLoggedIsNotNull() {
            orCriterion("logged is not null");
            return (Criteria) this;
        }
        
        
        public Criteria andLoggedIn(List<Date> values) {
            addCriterionForJDBCDate("logged in", values, "logged");
            return (Criteria) this;
        }

        public Criteria andLoggedNotIn(List<Date> values) {
            addCriterionForJDBCDate("logged not in", values, "logged");
            return (Criteria) this;
        }

        public Criteria andLoggedBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("logged between", value1, value2, "logged");
            return (Criteria) this;
        }

        public Criteria andLoggedNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("logged not between", value1, value2, "logged");
            return (Criteria) this;
        }
        public Criteria andActivatedIsNull() {
            addCriterion("activated is null");
            return (Criteria) this;
        }
        
        public Criteria andActivatedIsNotNull() {
            addCriterion("activated is not null");
            return (Criteria) this;
        }
        public Criteria andActivatedEqualTo(Date value) {
            addCriterionForJDBCDate("activated =", value, "activated");
            return (Criteria) this;
        }
        
        public Criteria andActivatedNotEqualTo(Date value) {
            addCriterionForJDBCDate("activated <>", value, "activated");
            return (Criteria) this;
        }

        public Criteria andActivatedGreaterThan(Date value) {
            addCriterionForJDBCDate("activated >", value, "activated");
            return (Criteria) this;
        }

        public Criteria andActivatedGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("activated >=", value, "activated");
            return (Criteria) this;
        }

        public Criteria andActivatedLessThan(Date value) {
            addCriterionForJDBCDate("activated <", value, "activated");
            return (Criteria) this;
        }

        public Criteria andActivatedLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("activated <=", value, "activated");
            return (Criteria) this;
        }
        public Criteria orActivatedIsNull() {
            orCriterion("activated is null");
            return (Criteria) this;
        }

        public Criteria orActivatedIsNotNull() {
            orCriterion("activated is not null");
            return (Criteria) this;
        }
        
        
        public Criteria andActivatedIn(List<Date> values) {
            addCriterionForJDBCDate("activated in", values, "activated");
            return (Criteria) this;
        }

        public Criteria andActivatedNotIn(List<Date> values) {
            addCriterionForJDBCDate("activated not in", values, "activated");
            return (Criteria) this;
        }

        public Criteria andActivatedBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("activated between", value1, value2, "activated");
            return (Criteria) this;
        }

        public Criteria andActivatedNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("activated not between", value1, value2, "activated");
            return (Criteria) this;
        }
    }

    /**
     * 该类对应数据库表 user
     */
    public static class Criteria extends AbstractGeneratedCriteria {
        protected boolean andRelation;

        public boolean isAndRelation() {
            return andRelation;
        }

        protected Criteria() {
            super();
        }

        public void setAndRelation(boolean andRelation) {
            this.andRelation = andRelation;
        }
    }

    /**
     * 该类对应数据库表 user
     */
    public static class Criterion implements java.io.Serializable {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean orValue;

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

        public boolean isOrValue() {
            return orValue;
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

        protected Criterion(String condition, boolean orValue) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
            this.orValue = true;
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

        protected Criterion(String condition, Object value, boolean orValue) {
            this(condition, value, null);
            this.orValue = true;
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

        protected Criterion(String condition, Object value, Object secondValue, boolean orValue) {
            this(condition, value, secondValue, null);
            this.orValue = true;
        }
    }
}