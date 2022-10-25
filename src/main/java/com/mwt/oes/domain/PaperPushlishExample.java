package com.mwt.oes.domain;

import java.util.ArrayList;
import java.util.List;

public class PaperPushlishExample {
  protected String orderByClause;

  protected boolean distinct;

  protected List<Criteria> oredCriteria;

  public PaperPushlishExample() {
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

    public Criteria andTeacherTnoEqualTo(String value) {
      addCriterion("teacher_tno =", value, "teacherTno");
      return (Criteria) this;
    }

    public Criteria andTeacherTnoNotEqualTo(String value) {
      addCriterion("teacher_tno <>", value, "teacherTno");
      return (Criteria) this;
    }

    public Criteria andTeacherTnoGreaterThan(String value) {
      addCriterion("teacher_tno >", value, "TeacherTno");
      return (Criteria) this;
    }

    public Criteria andTeacherTnoGreaterThanOrEqualTo(String value) {
      addCriterion("teacher_tno >=", value, "teacherTno");
      return (Criteria) this;
    }

    public Criteria andTeacherTnoLessThan(String value) {
      addCriterion("teacher_tno <", value, "teacherTno");
      return (Criteria) this;
    }

    public Criteria andTeacherTnoLessThanOrEqualTo(String value) {
      addCriterion("teacher_tno <=", value, "teacherTno");
      return (Criteria) this;
    }

    public Criteria andTeacherTnoIn(List<String> values) {
      addCriterion("teacher_tno in", values, "teacherTno");
      return (Criteria) this;
    }

    public Criteria andTeacherTnoNotIn(List<String> values) {
      addCriterion("teacher_tno not in", values, "teacherTno");
      return (Criteria) this;
    }

    public Criteria andTeacherTnoBetween(String value1, String value2) {
      addCriterion("teacher_tno between", value1, value2, "teacherTno");
      return (Criteria) this;
    }

    public Criteria andTeacherTnoNotBetween(String value1, String value2) {
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

    public Criteria andClassTnoEqualTo(String value) {
      addCriterion("class_tno =", value, "classTno");
      return (Criteria) this;
    }

    public Criteria andClassTnoNotEqualTo(String value) {
      addCriterion("class_tno <>", value, "classTno");
      return (Criteria) this;
    }

    public Criteria andClassTnoGreaterThan(String value) {
      addCriterion("class_tno >", value, "classTno");
      return (Criteria) this;
    }

    public Criteria andClassTnoGreaterThanOrEqualTo(String value) {
      addCriterion("class_tno >=", value, "classTno");
      return (Criteria) this;
    }

    public Criteria andClassTnoLessThan(String value) {
      addCriterion("class_tno <", value, "classTno");
      return (Criteria) this;
    }

    public Criteria andClassTnoLessThanOrEqualTo(String value) {
      addCriterion("class_tno <=", value, "classTno");
      return (Criteria) this;
    }

    public Criteria andClassTnoIn(List<String> values) {
      addCriterion("class_tno in", values, "classTno");
      return (Criteria) this;
    }

    public Criteria andClassTnoNotIn(List<String> values) {
      addCriterion("class_tno not in", values, "classTno");
      return (Criteria) this;
    }

    public Criteria andClassTnoBetween(String value1, String value2) {
      addCriterion("class_tno between", value1, value2, "classTno");
      return (Criteria) this;
    }

    public Criteria andClassTnoNotBetween(String value1, String value2) {
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

    public Criteria andPaperIdEqualTo(String value) {
      addCriterion("paper_id =", value, "paperId");
      return (Criteria) this;
    }

    public Criteria andPaperIdNotEqualTo(String value) {
      addCriterion("paper_id <>", value, "paperId");
      return (Criteria) this;
    }

    public Criteria andPaperIdGreaterThan(String value) {
      addCriterion("paper_id >", value, "paperId");
      return (Criteria) this;
    }

    public Criteria andPaperIdGreaterThanOrEqualTo(String value) {
      addCriterion("paper_id >=", value, "paperId");
      return (Criteria) this;
    }

    public Criteria andPaperIdLessThan(String value) {
      addCriterion("paper_id <", value, "paperId");
      return (Criteria) this;
    }

    public Criteria andPaperIdLessThanOrEqualTo(String value) {
      addCriterion("paper_id <=", value, "paperId");
      return (Criteria) this;
    }

    public Criteria andPaperIdIn(List<String> values) {
      addCriterion("paper_id in", values, "paperId");
      return (Criteria) this;
    }

    public Criteria andPaperIdNotIn(List<String> values) {
      addCriterion("paper_id not in", values, "paperId");
      return (Criteria) this;
    }

    public Criteria andPaperIdBetween(String value1, String value2) {
      addCriterion("paper_id between", value1, value2, "paperId");
      return (Criteria) this;
    }

    public Criteria andPaperIdNotBetween(String value1, String value2) {
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
