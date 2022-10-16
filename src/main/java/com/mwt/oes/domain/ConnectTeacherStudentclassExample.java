package com.mwt.oes.domain;

import java.util.ArrayList;
import java.util.List;

public class ConnectTeacherStudentclassExample {
  protected String orderByClause;

  protected boolean distinct;

  protected List<Criteria> oredCriteria;

  public ConnectTeacherStudentclassExample() {
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

    /*
        TeacherTno
     */
    public Criteria andTeacherTnoIsNull() {
      addCriterion("teacher_tno is null");
      return (Criteria) this;
    }

    public Criteria andTeacherTnoIsNotNull() {
      addCriterion("teacher_tno is not null");
      return (Criteria) this;
    }

    public Criteria andTeacherTnoEqualTo(Integer value) {
      addCriterion("teacher_tno =", value, "teacherTno");
      return (Criteria) this;
    }

    public Criteria andTeacherTnoNotEqualTo(Integer value) {
      addCriterion("teacher_tno <>", value, "teacherTno");
      return (Criteria) this;
    }

    public Criteria andTeacherTnoGreaterThan(Integer value) {
      addCriterion("teacher_tno >", value, "TeacherTno");
      return (Criteria) this;
    }

    public Criteria andTeacherTnoGreaterThanOrEqualTo(Integer value) {
      addCriterion("teacher_tno >=", value, "teacherTno");
      return (Criteria) this;
    }

    public Criteria andTeacherTnoLessThan(Integer value) {
      addCriterion("teacher_tno <", value, "teacherTno");
      return (Criteria) this;
    }

    public Criteria andTeacherTnoLessThanOrEqualTo(Integer value) {
      addCriterion("teacher_tno <=", value, "teacherTno");
      return (Criteria) this;
    }

    public Criteria andTeacherTnoIn(List<Integer> values) {
      addCriterion("teacher_tno in", values, "teacherTno");
      return (Criteria) this;
    }

    public Criteria andTeacherTnoNotIn(List<Integer> values) {
      addCriterion("teacher_tno not in", values, "teacherTno");
      return (Criteria) this;
    }

    public Criteria andTeacherTnoBetween(Integer value1, Integer value2) {
      addCriterion("teacher_tno between", value1, value2, "teacherTno");
      return (Criteria) this;
    }

    public Criteria andTeacherTnoNotBetween(Integer value1, Integer value2) {
      addCriterion("teacher_tno not between", value1, value2, "teacherTno");
      return (Criteria) this;
    }
    /*
      ClassTno
     */

    public Criteria andClassTnoIsNull() {
      addCriterion("class_tno is null");
      return (Criteria) this;
    }

    public Criteria andClassTnoIsNotNull() {
      addCriterion("class_tno is not null");
      return (Criteria) this;
    }

    public Criteria andClassTnoEqualTo(Integer value) {
      addCriterion("class_tno =", value, "classTno");
      return (Criteria) this;
    }

    public Criteria andClassTnoNotEqualTo(Integer value) {
      addCriterion("class_tno <>", value, "classTno");
      return (Criteria) this;
    }

    public Criteria andClassTnoGreaterThan(Integer value) {
      addCriterion("class_tno >", value, "classTno");
      return (Criteria) this;
    }

    public Criteria andClassTnoGreaterThanOrEqualTo(Integer value) {
      addCriterion("class_tno >=", value, "classTno");
      return (Criteria) this;
    }

    public Criteria andClassTnoLessThan(Integer value) {
      addCriterion("class_tno <", value, "classTno");
      return (Criteria) this;
    }

    public Criteria andClassTnoLessThanOrEqualTo(Integer value) {
      addCriterion("class_tno <=", value, "classTno");
      return (Criteria) this;
    }

    public Criteria andClassTnoIn(List<Integer> values) {
      addCriterion("class_tno in", values, "classTno");
      return (Criteria) this;
    }

    public Criteria andClassTnoNotIn(List<Integer> values) {
      addCriterion("class_tno not in", values, "classTno");
      return (Criteria) this;
    }

    public Criteria andClassTnoBetween(Integer value1, Integer value2) {
      addCriterion("class_tno between", value1, value2, "classTno");
      return (Criteria) this;
    }

    public Criteria andClassTnoNotBetween(Integer value1, Integer value2) {
      addCriterion("class_tno not between", value1, value2, "classTno");
      return (Criteria) this;
    }

    public Criteria andPaperIdIsNull() {
      addCriterion("paper_id is null");
      return (Criteria) this;
    }

    public Criteria andPaperIdIsNotNull() {
      addCriterion("paper_id is not null");
      return (Criteria) this;
    }

    public Criteria andPaperIdEqualTo(Integer value) {
      addCriterion("paper_id =", value, "paperId");
      return (Criteria) this;
    }

    public Criteria andPaperIdNotEqualTo(Integer value) {
      addCriterion("paper_id <>", value, "paperId");
      return (Criteria) this;
    }

    public Criteria andPaperIdGreaterThan(Integer value) {
      addCriterion("paper_id >", value, "paperId");
      return (Criteria) this;
    }

    public Criteria andPaperIdGreaterThanOrEqualTo(Integer value) {
      addCriterion("paper_id >=", value, "paperId");
      return (Criteria) this;
    }

    public Criteria andPaperIdLessThan(Integer value) {
      addCriterion("paper_id <", value, "paperId");
      return (Criteria) this;
    }

    public Criteria andPaperIdLessThanOrEqualTo(Integer value) {
      addCriterion("paper_id <=", value, "paperId");
      return (Criteria) this;
    }

    public Criteria andPaperIdIn(List<Integer> values) {
      addCriterion("paper_id in", values, "paperId");
      return (Criteria) this;
    }

    public Criteria andPaperIdNotIn(List<Integer> values) {
      addCriterion("paper_id not in", values, "paperId");
      return (Criteria) this;
    }

    public Criteria andPaperIdBetween(Integer value1, Integer value2) {
      addCriterion("paper_id between", value1, value2, "paperId");
      return (Criteria) this;
    }

    public Criteria andPaperIdNotBetween(Integer value1, Integer value2) {
      addCriterion("paper_id not between", value1, value2, "paperId");
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