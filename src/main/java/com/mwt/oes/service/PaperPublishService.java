package com.mwt.oes.service;

import com.mwt.oes.domain.PaperPushlishExample;
import com.mwt.oes.domain.PaperPushlish;
import java.util.List;
import java.util.Map;

public interface PaperPublishService {
  public List<PaperPushlish> searchPaperPublishclassInfo(String teacher_id);

//  public Map<String, Object> insertPaperPublishInfoList(List<Map<String, Object>> connectteacherstudentList);

  public int insertPaperPublishInfo(PaperPushlish connectteacherstudentclass);
}
