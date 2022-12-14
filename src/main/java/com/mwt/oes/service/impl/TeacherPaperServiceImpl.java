package com.mwt.oes.service.impl;

import com.mwt.oes.dao.*;
import com.mwt.oes.domain.*;
import com.mwt.oes.service.StudentHomeService;
import com.mwt.oes.service.TeacherPaperService;
import com.mwt.oes.util.FindContentWithImage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class TeacherPaperServiceImpl implements TeacherPaperService {

    @Autowired
    ProgramingLanguageMapper programingLanguageMapper;
    @Autowired
    PaperMapper paperMapper;
    @Autowired
    StudentHomeService studentHomeService;
    @Autowired
    StudentPaperScoreMapper studentPaperScoreMapper;
    @Autowired
    PaperQueMapper paperQueMapper;
    @Autowired
    BankSingleChoiceQueMapper bankSingleChoiceQueMapper;
    @Autowired
    BankMultipleChoiceQueMapper bankMultipleChoiceQueMapper;
    @Autowired
    BankJudgeQueMapper bankJudgeQueMapper;
    @Autowired
    BankFillQueMapper bankFillQueMapper;

    @Override
    public List<Map<String, Object>> getPapersList() {
        List<Map<String, Object>> resultList = new ArrayList<>();
        PaperExample paperExample = new PaperExample();
        paperExample.setOrderByClause("paper_id asc");
//        paperExample.
        List<Paper> paperList = paperMapper.selectByExample(paperExample);
        for (Paper paper : paperList) {
            Map<String, Object> map = new HashMap<>();
            map.put("id", paperList.indexOf(paper) + 1);
            map.put("paperId", paper.getPaperId());
            map.put("paperName", paper.getPaperName());

            map.put("langId", paper.getLangId());
            ProgramingLanguage programingLanguage = programingLanguageMapper.selectByPrimaryKey(paper.getLangId());
            if(programingLanguage.getLangName() != null) {
                map.put("langName", programingLanguage.getLangName());
            }
            if(programingLanguage.getLangImgSrc() != null){
                map.put("langImgSrc", programingLanguage.getLangImgSrc());
            }
            map.put("paperDuration", paper.getPaperDuration());
            map.put("paperDifficulty", paper.getPaperDifficulty());
            map.put("paperAttention", paper.getPaperAttention());
            map.put("paperType", paper.getPaperType());
            map.put("singleScore", paper.getSingleScore());
            map.put("multipleScore", paper.getMultipleScore());
            map.put("judgeScore", paper.getJudgeScore());
            map.put("fillScore", paper.getFillScore());

            Map<String, Integer> queNum = studentHomeService.getPaperQueNumByPaperId(paper.getPaperId());
            int totalScore = queNum.get("singleNum")*paper.getSingleScore()
                    + queNum.get("multipleNum")*paper.getMultipleScore()
                    + queNum.get("judgeNum")*paper.getJudgeScore()
                    + queNum.get("fillNum")*paper.getFillScore();
            map.put("totalScore", totalScore);
            map.put("singleNum", queNum.get("singleNum"));
            map.put("multipleNum", queNum.get("multipleNum"));
            map.put("judgeNum", queNum.get("judgeNum"));
            map.put("fillNum", queNum.get("fillNum"));
            map.put("totalNum", queNum.get("totalNum"));

            map.put("participateNum", paper.getParticipateNum());
            map.put("paperCreateTime", paper.getPaperCreateTime());
            map.put("paperCreateTno",paper.getTno());
            map.put("paperStartTime",paper.getPaperStartTime());
            map.put("stuClassName",paper.getClassName());
            resultList.add(map);
        }
        return resultList;
    }

    @Override
    public List<Map<String, Object>> getLangOptions() {
        List<Map<String, Object>> resultList = new ArrayList<>();
        ProgramingLanguageExample programingLanguageExample = new ProgramingLanguageExample();
        programingLanguageExample.setOrderByClause("lang_id asc");
        List<ProgramingLanguage> programingLanguageList = programingLanguageMapper.selectByExample(programingLanguageExample);
        for (ProgramingLanguage programingLanguage : programingLanguageList) {
            Map<String, Object> map = new HashMap<>();
            map.put("label",programingLanguage.getLangName());
            map.put("key",programingLanguage.getLangId());
            resultList.add(map);
        }
        return resultList;
    }

    @Override
    public List<Map<String, Object>> searchPapersList(String paperName, Integer langId, Integer paperType) {
        List<Map<String, Object>> resultList = new ArrayList<>();
        PaperExample paperExample = new PaperExample();
        PaperExample.Criteria criteria = paperExample.createCriteria();
        if(!paperName.equals("undefined")) {
            criteria.andPaperNameLike("%" + paperName + "%");
        }
        if(langId != 0){
            criteria.andLangIdEqualTo(langId);
        }
        if(paperType != 0){
            criteria.andPaperTypeEqualTo(paperType);
        }
        paperExample.setOrderByClause("paper_id asc");
        List<Paper> paperList = paperMapper.selectByExample(paperExample);
        for (Paper paper : paperList) {
            Map<String, Object> map = new HashMap<>();
            map.put("id", paperList.indexOf(paper) + 1);
            map.put("paperId", paper.getPaperId());
            map.put("paperName", paper.getPaperName());

            map.put("langId", paper.getLangId());
            ProgramingLanguage programingLanguage = programingLanguageMapper.selectByPrimaryKey(paper.getLangId());
            map.put("langName", programingLanguage.getLangName());
            map.put("langImgSrc", programingLanguage.getLangImgSrc());

            map.put("paperDuration", paper.getPaperDuration());
            map.put("paperDifficulty", paper.getPaperDifficulty());
            map.put("paperType", paper.getPaperType());
            map.put("paperAttention", paper.getPaperAttention());
            map.put("singleScore", paper.getSingleScore());
            map.put("multipleScore", paper.getMultipleScore());
            map.put("judgeScore", paper.getJudgeScore());
            map.put("fillScore", paper.getFillScore());

            Map<String, Integer> queNum = studentHomeService.getPaperQueNumByPaperId(paper.getPaperId());
            int totalScore = queNum.get("singleNum")*paper.getSingleScore()
                    + queNum.get("multipleNum")*paper.getMultipleScore()
                    + queNum.get("judgeNum")*paper.getJudgeScore()
                    + queNum.get("fillNum")*paper.getFillScore();
            map.put("totalScore", totalScore);
            map.put("singleNum", queNum.get("singleNum"));
            map.put("multipleNum", queNum.get("multipleNum"));
            map.put("judgeNum", queNum.get("judgeNum"));
            map.put("fillNum", queNum.get("fillNum"));
            map.put("totalNum", queNum.get("totalNum"));

            map.put("participateNum", paper.getParticipateNum());
            map.put("paperCreateTime", paper.getPaperCreateTime());
            map.put("paperCreateTno",paper.getTno());
            map.put("paperStartTime",paper.getPaperStartTime());
            map.put("stuClassName",paper.getClassName());
            resultList.add(map);
        }
        return resultList;
    }

    @Override
    public int selectPaperScoreByPaperId(Integer paperId) {
        StudentPaperScoreExample studentPaperScoreExample = new StudentPaperScoreExample();
        StudentPaperScoreExample.Criteria criteria = studentPaperScoreExample.createCriteria();
        criteria.andPaperIdEqualTo(paperId);
        List<StudentPaperScore> resultList = studentPaperScoreMapper.selectByExample(studentPaperScoreExample);
        return resultList.size();
    }

    @Override
    public int deletePaper(Integer paperId) {
        //  ??????paper_que????????????
        PaperQueExample paperQueExample = new PaperQueExample();
        PaperQueExample.Criteria criteria = paperQueExample.createCriteria();
        criteria.andPaperIdEqualTo(paperId);
        int deletePaperQueResult = paperQueMapper.deleteByExample(paperQueExample);
        //  ??????paper????????????
        int deletePaperResult = paperMapper.deleteByPrimaryKey(paperId);
        return deletePaperResult;
    }

    @Override
    public Map<String, Object> getPaperQueDetailByPaperId(Integer paperId, Integer totalNum) {
        Map<String, Object> map = new HashMap<>();

        List<Map<String, Object>> singleData = new ArrayList<>();
        List<Map<String, Object>> multipleData = new ArrayList<>();
        List<Map<String, Object>> judgeData = new ArrayList<>();
        List<Map<String, Object>> fillData = new ArrayList<>();

        // ???????????????????????????
        List<BankSingleChoiceQue> singleChoiceQueList = bankSingleChoiceQueMapper.getSingleQueListByPaperId(paperId);
        for (BankSingleChoiceQue bankSingleChoiceQue : singleChoiceQueList) {
            int singleIndex = singleChoiceQueList.indexOf(bankSingleChoiceQue);
            Map<String, Object> singleMap = new HashMap<>();
            //??????id?????????????????????????????????
            singleMap.put("id",singleIndex + 5);

            //???????????????????????????
            Map<String, String> singleContentMap = FindContentWithImage.findContentWithImage(bankSingleChoiceQue.getSingleContent());
            singleMap.put("label",(singleIndex + 1) + "???" + singleContentMap.get("content"));

            //??????????????????????????????????????????
            List<Map<String, Object>> singleAnswersList = new ArrayList<>();
            Map<String, Object> singleChoiceA = new HashMap<>();
            singleChoiceA.put("id",singleIndex*8 + totalNum + 5);
            singleChoiceA.put("label",bankSingleChoiceQue.getChoiceA());
            singleAnswersList.add(singleChoiceA);
            Map<String, Object> singleChoiceB = new HashMap<>();
            singleChoiceB.put("id",singleIndex*8 + 1 + totalNum + 5);
            singleChoiceB.put("label",bankSingleChoiceQue.getChoiceB());
            singleAnswersList.add(singleChoiceB);
            if (bankSingleChoiceQue.getChoiceC() != null) {
                Map<String, Object> singleChoiceC = new HashMap<>();
                singleChoiceC.put("id",singleIndex*8 + 2 + totalNum + 5);
                singleChoiceC.put("label",bankSingleChoiceQue.getChoiceC());
                singleAnswersList.add(singleChoiceC);
            }
            if (bankSingleChoiceQue.getChoiceD() != null) {
                Map<String, Object> singleChoiceD = new HashMap<>();
                singleChoiceD.put("id",singleIndex*8 + 3 + totalNum + 5);
                singleChoiceD.put("label",bankSingleChoiceQue.getChoiceD());
                singleAnswersList.add(singleChoiceD);
            }
            if (bankSingleChoiceQue.getChoiceE() != null) {
                Map<String, Object> singleChoiceE = new HashMap<>();
                singleChoiceE.put("id",singleIndex*8 + 4 + totalNum + 5);
                singleChoiceE.put("label",bankSingleChoiceQue.getChoiceE());
                singleAnswersList.add(singleChoiceE);
            }
            if (bankSingleChoiceQue.getChoiceF() != null) {
                Map<String, Object> singleChoiceF = new HashMap<>();
                singleChoiceF.put("id",singleIndex*8 + 5 + totalNum + 5);
                singleChoiceF.put("label",bankSingleChoiceQue.getChoiceF());
                singleAnswersList.add(singleChoiceF);
            }
            if (bankSingleChoiceQue.getChoiceG() != null) {
                Map<String, Object> singleChoiceG = new HashMap<>();
                singleChoiceG.put("id",singleIndex*8 + 6 + totalNum + 5);
                singleChoiceG.put("label",bankSingleChoiceQue.getChoiceG());
                singleAnswersList.add(singleChoiceG);
            }
            Map<String, Object> singleAnswer = new HashMap<>();
            singleAnswer.put("id",singleIndex*8 + 7 + totalNum + 5);
            singleAnswer.put("label","???????????????" + bankSingleChoiceQue.getSingleAnswer());
            singleAnswersList.add(singleAnswer);

            singleMap.put("children",singleAnswersList);
            singleData.add(singleMap);
        }

        int singleNum = singleChoiceQueList.size();

        // ???????????????????????????
        List<BankMultipleChoiceQue> multipleChoiceQueList = bankMultipleChoiceQueMapper.getMultipleQueListByPaperId(paperId);
        for (BankMultipleChoiceQue bankMultipleChoiceQue : multipleChoiceQueList) {
            int multipleIndex = multipleChoiceQueList.indexOf(bankMultipleChoiceQue);
            Map<String, Object> multipleMap = new HashMap<>();
            //??????id??????????????????????????????????????????????????????
            multipleMap.put("id",multipleIndex + 5 + singleNum);

            //???????????????????????????
            Map<String, String> multipleContentMap = FindContentWithImage.findContentWithImage(bankMultipleChoiceQue.getMultipleContent());
            multipleMap.put("label",(multipleIndex + 1 + singleNum) + "???" + multipleContentMap.get("content"));

            //??????????????????????????????????????????
            List<Map<String, Object>> multipleAnswersList = new ArrayList<>();
            Map<String, Object> multipleChoiceA = new HashMap<>();
            multipleChoiceA.put("id",multipleIndex*8 + totalNum + 5 + singleNum*8);
            multipleChoiceA.put("label",bankMultipleChoiceQue.getChoiceA());
            multipleAnswersList.add(multipleChoiceA);
            Map<String, Object> multipleChoiceB = new HashMap<>();
            multipleChoiceB.put("id",multipleIndex*8 + 1 + totalNum + 5 + singleNum*8);
            multipleChoiceB.put("label",bankMultipleChoiceQue.getChoiceB());
            multipleAnswersList.add(multipleChoiceB);
            if (bankMultipleChoiceQue.getChoiceC() != null){
                Map<String, Object> multipleChoiceC = new HashMap<>();
                multipleChoiceC.put("id",multipleIndex*8 + 2 + totalNum + 5 + singleNum*8);
                multipleChoiceC.put("label",bankMultipleChoiceQue.getChoiceC());
                multipleAnswersList.add(multipleChoiceC);
            }
            if (bankMultipleChoiceQue.getChoiceD() != null){
                Map<String, Object> multipleChoiceD = new HashMap<>();
                multipleChoiceD.put("id",multipleIndex*8 + 3 + totalNum + 5 + singleNum*8);
                multipleChoiceD.put("label",bankMultipleChoiceQue.getChoiceD());
                multipleAnswersList.add(multipleChoiceD);
            }
            if (bankMultipleChoiceQue.getChoiceE() != null){
                Map<String, Object> multipleChoiceE = new HashMap<>();
                multipleChoiceE.put("id",multipleIndex*8 + 4 + totalNum + 5 + singleNum*8);
                multipleChoiceE.put("label",bankMultipleChoiceQue.getChoiceE());
                multipleAnswersList.add(multipleChoiceE);
            }
            if (bankMultipleChoiceQue.getChoiceF() != null){
                Map<String, Object> multipleChoiceF = new HashMap<>();
                multipleChoiceF.put("id",multipleIndex*8 + 5 + totalNum + 5 + singleNum*8);
                multipleChoiceF.put("label",bankMultipleChoiceQue.getChoiceF());
                multipleAnswersList.add(multipleChoiceF);
            }
            if (bankMultipleChoiceQue.getChoiceG() != null){
                Map<String, Object> multipleChoiceG = new HashMap<>();
                multipleChoiceG.put("id",multipleIndex*8 + 6 + totalNum + 5 + singleNum*8);
                multipleChoiceG.put("label",bankMultipleChoiceQue.getChoiceG());
                multipleAnswersList.add(multipleChoiceG);
            }

            Map<String, Object> multipleAnswer = new HashMap<>();
            multipleAnswer.put("id",multipleIndex*8 + 7 + totalNum + 5 + singleNum*8);
            multipleAnswer.put("label","???????????????" + bankMultipleChoiceQue.getMultipleAnswer());
            multipleAnswersList.add(multipleAnswer);

            multipleMap.put("children",multipleAnswersList);
            multipleData.add(multipleMap);
        }

        int multipleNum = multipleChoiceQueList.size();

        // ???????????????????????????
        List<BankJudgeQue> judgeQueList = bankJudgeQueMapper.getJudgeQueListByPaperId(paperId);
        for (BankJudgeQue bankJudgeQue : judgeQueList){
            int judgeIndex = judgeQueList.indexOf(bankJudgeQue);
            Map<String, Object> judgeMap = new HashMap<>();
            judgeMap.put("id",judgeIndex + 5 + singleNum + multipleNum);

            //???????????????????????????
            judgeMap.put("label",(judgeIndex + 1 + singleNum + multipleNum) + "???" + bankJudgeQue.getJudgeContent());

            //???????????????????????????
            List<Map<String, Object>> judgeAnswersList = new ArrayList<>();
            Map<String, Object> judgeAnswer = new HashMap<>();
            judgeAnswer.put("id",judgeIndex*1 + totalNum + 5 + singleNum*8 + multipleNum*8);
            judgeAnswer.put("label","???????????????" + bankJudgeQue.getJudgeAnswer());
            judgeAnswersList.add(judgeAnswer);

            judgeMap.put("children",judgeAnswersList);
            judgeData.add(judgeMap);
        }

        int judgeNum = judgeQueList.size();

        // ???????????????????????????
        List<BankFillQue> fillQueList = bankFillQueMapper.getFillQueListByPaperId(paperId);
        for (BankFillQue bankFillQue : fillQueList){
            int fillIndex = fillQueList.indexOf(bankFillQue);
            Map<String, Object> fillMap = new HashMap<>();
            fillMap.put("id",fillIndex + 5 + singleNum + multipleNum + judgeNum);

            //???????????????????????????
            fillMap.put("label",(fillIndex + 1 + singleNum + multipleNum + judgeNum) + "???" + bankFillQue.getFillContent());

            //???????????????????????????
            List<Map<String, Object>> fillAnswersList = new ArrayList<>();
            Map<String, Object> fillAnswer = new HashMap<>();
            fillAnswer.put("id",fillIndex*1 + totalNum + 5 + singleNum*8 + multipleNum*8 + judgeNum*1);
            fillAnswer.put("label","???????????????" + bankFillQue.getFillAnswer());
            fillAnswersList.add(fillAnswer);

            fillMap.put("children",fillAnswersList);
            fillData.add(fillMap);
        }

        map.put("singleData",singleData);
        map.put("multipleData",multipleData);
        map.put("judgeData",judgeData);
        map.put("fillData",fillData);
        return map;
    }

    @Override
    public int randomInsertPaperInfo(Map<String, Object> obj) {
        String paperName = (String) obj.get("paperName");
        Integer paperDuration = (Integer) obj.get("paperDuration");
        Integer paperDifficulty = (Integer) obj.get("paperDifficulty");
        String paperAttention = (String) obj.get("paperAttention");
        Integer singleScore = (Integer) obj.get("singleScore");
        Integer singleNum = (Integer) obj.get("singleNum");
        Integer multipleScore = (Integer) obj.get("multipleScore");
        Integer multipleNum = (Integer) obj.get("multipleNum");
        Integer judgeScore = (Integer) obj.get("judgeScore");
        Integer judgeNum = (Integer) obj.get("judgeNum");
        Integer fillScore = (Integer) obj.get("fillScore");
        Integer fillNum = (Integer) obj.get("fillNum");
        Integer langId = (Integer) obj.get("langId");
        Date startTime = (Date) obj.get("paperStartTime");

        Paper paper = new Paper();
        paper.setPaperName(paperName);
        paper.setPaperDuration(paperDuration);
        paper.setPaperDifficulty(paperDifficulty);
        paper.setPaperAttention(paperAttention);
        paper.setSingleScore(singleScore);
        paper.setMultipleScore(multipleScore);
        paper.setJudgeScore(judgeScore);
        paper.setFillScore(fillScore);
        paper.setLangId(langId);
        paper.setPaperCreateTime(new Date());
        paper.setPaperType(1);
        paper.setPaperStartTime(startTime);
        int paperId = paperMapper.selectMaxPaperId() + 1;
        paper.setPaperId(paperId);

        //  ?????????????????????paper???
        int result = paperMapper.insertSelective(paper);

        //  ???????????????????????????paper_que???
        //  ?????????
        List<BankSingleChoiceQue> bankSingleChoiceQueList = bankSingleChoiceQueMapper.getRandomSingleByCountAndLangId(langId, singleNum);
        for (BankSingleChoiceQue bankSingleChoiceQue : bankSingleChoiceQueList) {
            int singleId = bankSingleChoiceQue.getSingleId();
            PaperQue paperQue = new PaperQue();
            paperQue.setQueType(1);
            paperQue.setSingleId(singleId);
            paperQue.setPaperId(paperId);
            paperQueMapper.insertSelective(paperQue);
            //??????compose_flag??????
            bankSingleChoiceQue.setComposeFlag("1");
            bankSingleChoiceQueMapper.updateByPrimaryKeySelective(bankSingleChoiceQue);
        }

        //  ?????????
        List<BankMultipleChoiceQue> bankMultipleChoiceQueList = bankMultipleChoiceQueMapper.getRandomMultipleByCountAndLangId(langId, multipleNum);
        for (BankMultipleChoiceQue bankMultipleChoiceQue : bankMultipleChoiceQueList) {
            int multipleId = bankMultipleChoiceQue.getMultipleId();
            PaperQue paperQue = new PaperQue();
            paperQue.setQueType(2);
            paperQue.setMultipleId(multipleId);
            paperQue.setPaperId(paperId);
            paperQueMapper.insertSelective(paperQue);
            //??????compose_flag??????
            bankMultipleChoiceQue.setComposeFlag("1");
            bankMultipleChoiceQueMapper.updateByPrimaryKeySelective(bankMultipleChoiceQue);
        }

        //  ?????????
        List<BankJudgeQue> bankJudgeQueList = bankJudgeQueMapper.getRandomJudgeByCountAndLangId(langId, judgeNum);
        for (BankJudgeQue bankJudgeQue : bankJudgeQueList) {
            int judgeId = bankJudgeQue.getJudgeId();
            PaperQue paperQue = new PaperQue();
            paperQue.setQueType(3);
            paperQue.setJudgeId(judgeId);
            paperQue.setPaperId(paperId);
            paperQueMapper.insertSelective(paperQue);
            //??????compose_flag??????
            bankJudgeQue.setComposeFlag("1");
            bankJudgeQueMapper.updateByPrimaryKeySelective(bankJudgeQue);
        }

        //  ?????????
        List<BankFillQue> bankFillQueList = bankFillQueMapper.getRandomFillByCountAndLangId(langId, fillNum);
        for (BankFillQue bankFillQue : bankFillQueList) {
            int fillId = bankFillQue.getFillId();
            PaperQue paperQue = new PaperQue();
            paperQue.setQueType(4);
            paperQue.setFillId(fillId);
            paperQue.setPaperId(paperId);
            paperQueMapper.insertSelective(paperQue);
            //??????compose_flag??????
            bankFillQue.setComposeFlag("1");
            bankFillQueMapper.updateByPrimaryKeySelective(bankFillQue);
        }

        return result;
    }

    @Override
    public Map<String, Object> getPaperQueDetailByLangId(Integer langId) {
        Map<String, Object> map = new HashMap<>();

        List<Map<String, Object>> singleData = new ArrayList<>();
        List<Map<String, Object>> multipleData = new ArrayList<>();
        List<Map<String, Object>> judgeData = new ArrayList<>();
        List<Map<String, Object>> fillData = new ArrayList<>();

        BankSingleChoiceQueExample bankSingleChoiceQueExample = new BankSingleChoiceQueExample();
        BankSingleChoiceQueExample.Criteria criteriaSingle = bankSingleChoiceQueExample.createCriteria();
        criteriaSingle.andLangIdEqualTo(langId);
        List<BankSingleChoiceQue> bankSingleChoiceQueList = bankSingleChoiceQueMapper.selectByExample(bankSingleChoiceQueExample);
        for (BankSingleChoiceQue bankSingleChoiceQue : bankSingleChoiceQueList) {
            int singleId = bankSingleChoiceQue.getSingleId();
            Map<String, Object> singleMap = new HashMap<>();
            // ?????????singleId?????????1??????
            int id = (int) (Math.pow(10,String.valueOf(singleId).length()) + singleId);
            singleMap.put("id",id);
            //???????????????????????????
            Map<String, String> singleContentMap = FindContentWithImage.findContentWithImage(bankSingleChoiceQue.getSingleContent());
            String composeFlag = bankSingleChoiceQue.getComposeFlag();
            String composeStr = composeFlag.equals("1") ? "???????????????" : "???????????????";
            singleMap.put("label",composeStr + (bankSingleChoiceQueList.indexOf(bankSingleChoiceQue) + 1) + "???" + singleContentMap.get("content"));

            singleData.add(singleMap);
        }

        BankMultipleChoiceQueExample bankMultipleChoiceQueExample = new BankMultipleChoiceQueExample();
        BankMultipleChoiceQueExample.Criteria criteriaMultiple = bankMultipleChoiceQueExample.createCriteria();
        criteriaMultiple.andLangIdEqualTo(langId);
        List<BankMultipleChoiceQue> bankMultipleChoiceQueList = bankMultipleChoiceQueMapper.selectByExample(bankMultipleChoiceQueExample);
        for (BankMultipleChoiceQue bankMultipleChoiceQue : bankMultipleChoiceQueList) {
            int multipleId = bankMultipleChoiceQue.getMultipleId();
            Map<String, Object> multipleMap = new HashMap<>();
            // ?????????multipleId?????????2??????
            int id = (int) (Math.pow(10,String.valueOf(multipleId).length())*2 + multipleId);
            multipleMap.put("id",id);
            //???????????????????????????
            Map<String, String> multipleContentMap = FindContentWithImage.findContentWithImage(bankMultipleChoiceQue.getMultipleContent());
            String composeFlag = bankMultipleChoiceQue.getComposeFlag();
            String composeStr = composeFlag.equals("1") ? "???????????????" : "???????????????";
            multipleMap.put("label",composeStr + (bankMultipleChoiceQueList.indexOf(bankMultipleChoiceQue) + 1) + "???" + multipleContentMap.get("content"));

            multipleData.add(multipleMap);
        }

        BankJudgeQueExample bankJudgeQueExample = new BankJudgeQueExample();
        BankJudgeQueExample.Criteria criteriaJudge = bankJudgeQueExample.createCriteria();
        criteriaJudge.andLangIdEqualTo(langId);
        List<BankJudgeQue> bankJudgeQueList = bankJudgeQueMapper.selectByExample(bankJudgeQueExample);
        for (BankJudgeQue bankJudgeQue : bankJudgeQueList) {
            int judgeId = bankJudgeQue.getJudgeId();
            Map<String, Object> judgeMap = new HashMap<>();
            // ?????????judgeId?????????3??????
            int id = (int) (Math.pow(10,String.valueOf(judgeId).length())*3 + judgeId);
            judgeMap.put("id",id);
//            System.out.println(judgeId + "---" + id);
            //???????????????????????????
            String composeFlag = bankJudgeQue.getComposeFlag();
            String composeStr = composeFlag.equals("1") ? "???????????????" : "???????????????";
            judgeMap.put("label",composeStr + (bankJudgeQueList.indexOf(bankJudgeQue) + 1) + "???" + bankJudgeQue.getJudgeContent());

            judgeData.add(judgeMap);
        }

        BankFillQueExample bankFillQueExample = new BankFillQueExample();
        BankFillQueExample.Criteria criteriaFill = bankFillQueExample.createCriteria();
        criteriaFill.andLangIdEqualTo(langId);
        List<BankFillQue> bankFillQueList = bankFillQueMapper.selectByExample(bankFillQueExample);
        for (BankFillQue bankFillQue : bankFillQueList) {
            int fillId = bankFillQue.getFillId();
            Map<String, Object> fillMap = new HashMap<>();
            // ?????????fillId?????????4??????
            int id = (int) (Math.pow(10,String.valueOf(fillId).length())*4 + fillId);
            fillMap.put("id",id);
            //???????????????????????????
            String composeFlag = bankFillQue.getComposeFlag();
            String composeStr = composeFlag.equals("1") ? "???????????????" : "???????????????";
            fillMap.put("label",composeStr + (bankFillQueList.indexOf(bankFillQue) + 1) + "???" + bankFillQue.getFillContent());

            fillData.add(fillMap);
        }

        map.put("singleData",singleData);
        map.put("multipleData",multipleData);
        map.put("judgeData",judgeData);
        map.put("fillData",fillData);
        return map;
    }

    @Override
    public int fixedInsertPaperInfo(Map<String, Object> obj) {
        String paperName = (String) obj.get("paperName");
        Integer paperDuration = (Integer) obj.get("paperDuration");
        Integer paperDifficulty = (Integer) obj.get("paperDifficulty");
        String paperAttention = (String) obj.get("paperAttention");
        Integer singleScore = (Integer) obj.get("singleScore");
        List<Integer> singleNum = (List<Integer>) obj.get("singleNum");
        Integer multipleScore = (Integer) obj.get("multipleScore");
        List<Integer> multipleNum = (List<Integer>) obj.get("multipleNum");
        Integer judgeScore = (Integer) obj.get("judgeScore");
        List<Integer> judgeNum = (List<Integer>) obj.get("judgeNum");
        Integer fillScore = (Integer) obj.get("fillScore");
        List<Integer> fillNum = (List<Integer>) obj.get("fillNum");
        Integer langId = (Integer) obj.get("langId");
        Date startTime = (Date) obj.get("paperStartTime");

        Paper paper = new Paper();
        paper.setPaperName(paperName);
        paper.setPaperDuration(paperDuration);
        paper.setPaperDifficulty(paperDifficulty);
        paper.setPaperAttention(paperAttention);
        paper.setSingleScore(singleScore);
        paper.setMultipleScore(multipleScore);
        paper.setJudgeScore(judgeScore);
        paper.setFillScore(fillScore);
        paper.setLangId(langId);
        paper.setPaperCreateTime(new Date());
        paper.setPaperType(2);
        paper.setPaperStartTime(startTime);
        int paperId = paperMapper.selectMaxPaperId() + 1;
        paper.setPaperId(paperId);

        //  ?????????????????????paper???
        int result = paperMapper.insertSelective(paper);

        //?????????
        for (Integer singleId : singleNum) {
            PaperQue paperQue = new PaperQue();
            paperQue.setQueType(1);
            paperQue.setSingleId(singleId);
            paperQue.setPaperId(paperId);
            paperQueMapper.insertSelective(paperQue);
            //??????compose_flag??????
            BankSingleChoiceQue bankSingleChoiceQue = new BankSingleChoiceQue();
            bankSingleChoiceQue.setSingleId(singleId);
            bankSingleChoiceQue.setComposeFlag("1");
            bankSingleChoiceQueMapper.updateByPrimaryKeySelective(bankSingleChoiceQue);
        }
        //?????????
        for (Integer multipleId : multipleNum) {
            PaperQue paperQue = new PaperQue();
            paperQue.setQueType(2);
            paperQue.setMultipleId(multipleId);
            paperQue.setPaperId(paperId);
            paperQueMapper.insertSelective(paperQue);
            //??????compose_flag??????
            BankMultipleChoiceQue bankMultipleChoiceQue = new BankMultipleChoiceQue();
            bankMultipleChoiceQue.setMultipleId(multipleId);
            bankMultipleChoiceQue.setComposeFlag("1");
            bankMultipleChoiceQueMapper.updateByPrimaryKeySelective(bankMultipleChoiceQue);
        }
        //?????????
        for (Integer judgeId : judgeNum) {
            PaperQue paperQue = new PaperQue();
            paperQue.setQueType(3);
            paperQue.setJudgeId(judgeId);
            paperQue.setPaperId(paperId);
            paperQueMapper.insertSelective(paperQue);
            //??????compose_flag??????
            BankJudgeQue bankJudgeQue = new BankJudgeQue();
            bankJudgeQue.setJudgeId(judgeId);
            bankJudgeQue.setComposeFlag("1");
            bankJudgeQueMapper.updateByPrimaryKeySelective(bankJudgeQue);
        }
        //?????????
        for (Integer fillId : fillNum) {
            PaperQue paperQue = new PaperQue();
            paperQue.setQueType(4);
            paperQue.setFillId(fillId);
            paperQue.setPaperId(paperId);
            paperQueMapper.insertSelective(paperQue);
            //??????compose_flag??????
            BankFillQue bankFillQue = new BankFillQue();
            bankFillQue.setFillId(fillId);
            bankFillQue.setComposeFlag("1");
            bankFillQueMapper.updateByPrimaryKeySelective(bankFillQue);
        }

        return result;
    }
  @Override
  public Paper getTeaHuPsw(Integer tno) {
    Paper paper = paperMapper.selectByPrimaryKey(tno);
    return paper;
  }
}
