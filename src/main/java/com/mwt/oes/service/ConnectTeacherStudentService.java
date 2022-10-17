package com.mwt.oes.service;

import com.mwt.oes.domain.ConnectTeacherStudentclass;

import java.util.List;

public interface ConnectTeacherStudentService {
  public List<ConnectTeacherStudentclass> searchConnectTeacherStudentclassInfo(String teacher_id);

}
