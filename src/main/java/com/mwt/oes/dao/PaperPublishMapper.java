package com.mwt.oes.dao;

import com.mwt.oes.domain.PaperPushlishExample;
import com.mwt.oes.domain.PaperPushlish;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PaperPublishMapper {
  int countByExample(PaperPushlishExample example);

  int deleteByExample(PaperPushlishExample example);

  int insert(PaperPushlish record);

  int insertSelective(PaperPushlish record);

  List<PaperPushlish> selectByExample(PaperPushlishExample example);

  int updateByExampleSelective(@Param("record") PaperPushlish record, @Param("example") PaperPushlishExample example);

  int updateByExample(@Param("record") PaperPushlish record, @Param("example") PaperPushlishExample example);

}
