package com.mwt.oes.service.impl;

import com.mwt.oes.dao.ConnectTeacherStudentMapper;
import com.mwt.oes.domain.ConnectTeacherStudentclass;
import com.mwt.oes.domain.ConnectTeacherStudentclassExample;
import com.mwt.oes.service.ConnectTeacherStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConnectTeacherStudentServiceImpl implements ConnectTeacherStudentService {
  @Autowired
  ConnectTeacherStudentMapper connectTeacherStudentMapper;

  @Override
  public List<ConnectTeacherStudentclass> searchConnectTeacherStudentclassInfo(String teacher_id) {
    ConnectTeacherStudentclassExample connectTeacherStudentclassExample = new ConnectTeacherStudentclassExample();
    ConnectTeacherStudentclassExample.Criteria criteria = connectTeacherStudentclassExample.createCriteria();
    if (teacher_id.equals("undefined") || teacher_id.equals("null")) {
//            System.out.println(stuClassName);
    } else {
      criteria.andTeacherTnoEqualTo(teacher_id);
    }
//    connectTeacherStudentclassExample.setOrderByClause("sno asc");
    List<ConnectTeacherStudentclass> resultList = connectTeacherStudentMapper.selectByExample(connectTeacherStudentclassExample);
    return resultList;
  }
}
