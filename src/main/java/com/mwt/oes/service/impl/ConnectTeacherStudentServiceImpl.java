package com.mwt.oes.service.impl;

import com.mwt.oes.dao.ConnectTeacherStudentMapper;
import com.mwt.oes.domain.ConnectTeacherStudentclass;
import com.mwt.oes.domain.ConnectTeacherStudentclassExample;
import com.mwt.oes.service.ConnectTeacherStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

  @Override
  public int insertConnectTeacherStudentclassInfo(ConnectTeacherStudentclass connectteacherstudentclass) {
    int result = connectTeacherStudentMapper.insert(connectteacherstudentclass);
    return result;
  }

  @Override
  public Map<String, Object> insertConnectTeacherStudentclassInfoList(List<Map<String, Object>> connectteacherstudentList) {
    Map<String, Object> map = new HashMap<>();
    List<Map<String, Object>> responseList = new ArrayList<>();
    int successItemCount = 0;
    for (Map<String, Object> studentSingle : connectteacherstudentList) {
      Map<String, Object> responseConnectTeacherStudentclass = new HashMap<>();
      String teacherTno = (String) studentSingle.get("teacherTno");
      String classTno = (String) studentSingle.get("classTno");
      String paperId = (String) studentSingle.get("paperId");
      responseConnectTeacherStudentclass.put("老师id", teacherTno);
      responseConnectTeacherStudentclass.put("班级id", classTno);
      responseConnectTeacherStudentclass.put("课程id", paperId);
      boolean isRegistered = false;
//              studentSystemService.snoIsExist(sno);
      if (isRegistered) {
        responseConnectTeacherStudentclass.put("上传状态", "失败，该学号已被注册");
      } else {
        responseConnectTeacherStudentclass.put("上传状态", "成功");
        successItemCount++;
        ConnectTeacherStudentclass stu = new ConnectTeacherStudentclass();
        stu.setTeacherTno(teacherTno);
        stu.setClassTno(classTno);
        stu.setPaperId(paperId);
        int insertResult = connectTeacherStudentMapper.insertSelective(stu);
      }
      responseList.add(responseConnectTeacherStudentclass);
    }
    map.put("responseList", responseList);
    map.put("allItemCount", connectteacherstudentList.size());
    map.put("successItemCount", successItemCount);
    map.put("failItemCount", connectteacherstudentList.size() - successItemCount);
    return map;
  }
}
