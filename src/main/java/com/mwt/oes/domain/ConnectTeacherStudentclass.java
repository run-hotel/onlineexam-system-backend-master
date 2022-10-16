package com.mwt.oes.domain;

public class ConnectTeacherStudentclass {

  private String teacherTno;

  private String classTno;

  private String paperId;

  public String getPaperId() {
    return paperId;
  }

  public void setPaperId(String paperId) {
    this.paperId = paperId == null ? null : paperId.trim();
  }

  public String getClassTno() {
    return classTno;
  }

  public void setClassTno(String classTno) {
    this.classTno = classTno == null ? null : classTno.trim();
  }

  public String getTeacherTno() {
    return teacherTno;
  }

  public void setTeacherTno(String teacherTno) {
    this.teacherTno = teacherTno == null ? null : teacherTno.trim();
  }
}
