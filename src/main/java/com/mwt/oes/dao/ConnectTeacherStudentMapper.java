package com.mwt.oes.dao;

import com.mwt.oes.domain.ConnectTeacherStudentclass;
import com.mwt.oes.domain.ConnectTeacherStudentclassExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ConnectTeacherStudentMapper {
  int countByExample(ConnectTeacherStudentclassExample example);

  int deleteByExample(ConnectTeacherStudentclassExample example);

  int insert(ConnectTeacherStudentclass record);

  int insertSelective(ConnectTeacherStudentclass record);

  List<ConnectTeacherStudentclass> selectByExample(ConnectTeacherStudentclassExample example);

  int updateByExampleSelective(@Param("record") ConnectTeacherStudentclass record, @Param("example") ConnectTeacherStudentclassExample example);

  int updateByExample(@Param("record") ConnectTeacherStudentclass record, @Param("example") ConnectTeacherStudentclassExample example);
  
}
