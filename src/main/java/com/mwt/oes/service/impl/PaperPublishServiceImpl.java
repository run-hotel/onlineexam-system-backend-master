package com.mwt.oes.service.impl;

import com.mwt.oes.dao.PaperPublishMapper;
import com.mwt.oes.domain.PaperPushlish;
import com.mwt.oes.domain.PaperPushlishExample;
import com.mwt.oes.service.PaperPublishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PaperPublishServiceImpl implements PaperPublishService {
  @Autowired
  PaperPublishMapper paperPushlishMapper;

  @Override
  public List<PaperPushlish> searchPaperPublishclassInfo(String teacher_id) {
    PaperPushlishExample paperPushlishclassExample = new PaperPushlishExample();
    PaperPushlishExample.Criteria criteria = paperPushlishclassExample.createCriteria();
    if (teacher_id.equals("undefined") || teacher_id.equals("null")) {
//            System.out.println(stuClassName);
    } else {
      criteria.andTeacherTnoEqualTo(teacher_id);
    }
//    paperPushlishclassExample.setOrderByClause("sno asc");
    List<PaperPushlish> resultList = paperPushlishMapper.selectByExample(paperPushlishclassExample);
    return resultList;
  }

  @Override
  public int insertPaperPublishInfo(PaperPushlish paperPushlishclass) {
    int result = paperPushlishMapper.insert(paperPushlishclass);
    return result;
  }

}
