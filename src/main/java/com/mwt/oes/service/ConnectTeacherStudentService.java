package com.mwt.oes.service;

import com.mwt.oes.domain.ConnectTeacherStudentclass;

import java.util.List;
import java.util.Map;

public interface ConnectTeacherStudentService {
  public List<ConnectTeacherStudentclass> searchConnectTeacherStudentclassInfo(String teacher_id);

  public Map<String, Object> insertConnectTeacherStudentclassInfoList(List<Map<String, Object>> connectteacherstudentList);

  public int insertConnectTeacherStudentclassInfo(ConnectTeacherStudentclass connectteacherstudentclass);
}
