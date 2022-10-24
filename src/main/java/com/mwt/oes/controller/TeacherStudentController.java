package com.mwt.oes.controller;

import com.mwt.oes.domain.ConnectTeacherStudentclass;
import com.mwt.oes.domain.Student;
import com.mwt.oes.service.ConnectTeacherStudentService;
import com.mwt.oes.service.StudentSystemService;
import com.mwt.oes.service.TeacherStudentService;
import com.mwt.oes.util.ServerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@CrossOrigin
@RestController
@RequestMapping("/api/teacher")
public class TeacherStudentController {
  @Autowired
  private TeacherStudentService teacherStudentService;

  @Autowired
  private ConnectTeacherStudentService connectTeacherStudentService;

  @Autowired
  private StudentSystemService studentSystemService;

  //    获取学生列表信息
  @RequestMapping("/getStudentsListall")
  public ServerResponse getStudentsList(@RequestParam("teacher_id") String teacher_id) {
    List<ConnectTeacherStudentclass> resultList1 = connectTeacherStudentService.searchConnectTeacherStudentclassInfo(teacher_id);
    List<Student> resultList2 = new ArrayList<Student>();
    for (int i = 0; i < resultList1.size(); ++i) {
      List<Student> resultList = teacherStudentService.searchStudentInfo("", "", "男", resultList1.get(i).getClassTno());
      for (int j = 0; j < resultList.size(); ++j) {
        resultList2.add(resultList.get(j));
      }
    }
    return ServerResponse.createBySuccess("获取全部学生信息成功", resultList2);
  }

  @RequestMapping("/getStudentsList")
  public ServerResponse getStudentsList() {
    List<Student> resultList = teacherStudentService.getStudentsList();
    return ServerResponse.createBySuccess("获取全部学生信息成功", resultList);
  }

  @RequestMapping("/getStudentClasses")
  public ServerResponse getStudentClasses() {
    List<Student> resultList = teacherStudentService.getStudentsList();
    List<String> res = new ArrayList<>();
    HashMap<String, Integer> hashMap = new HashMap<>();
    for (int i = 0; i < resultList.size(); ++i) {
      hashMap.put(resultList.get(i).getClassName(), 1);
    }
    Set<String> doubleSet = hashMap.keySet();
    for (String str : doubleSet) {
      res.add(str);
    }

    return ServerResponse.createBySuccess("获取全部班级成功", res);
  }

  //    更新学生信息
  @RequestMapping(value = "/updateStudentInfo", method = RequestMethod.POST)
  public ServerResponse updateStudentInfo(@RequestBody(required = false) Student student) {
    int result = teacherStudentService.updateStudentInfo(student);
    if (result > 0) {
      return ServerResponse.createBySuccess("更新学生信息成功", null);
    } else {
      return ServerResponse.createByError("数据库错误，更新学生信息失败");
    }
  }

  //    获取搜索学生列表信息
  @RequestMapping("/searchStudentInfo")
  public ServerResponse searchStudentInfo(@RequestParam("sno") String sno,
                                          @RequestParam("stuName") String stuName,
                                          @RequestParam("stuSex") String stuSex,
                                          @RequestParam("stuClassName") String stuClassName) {
    List<Student> resultList = teacherStudentService.searchStudentInfo(sno, stuName, stuSex, stuClassName);
    return ServerResponse.createBySuccess("获取搜索学生信息成功", resultList);
  }

  //    新增，通过教师id获取班级id
  @RequestMapping("/searchclassfromteacherInfo")
  public ServerResponse searchclassfromteacherInfo(
          @RequestParam("tno") String tno) {
    List<ConnectTeacherStudentclass> resultList = connectTeacherStudentService.searchConnectTeacherStudentclassInfo(tno);
    return ServerResponse.createBySuccess("获取搜索学生信息成功", resultList);
  }

  //    添加学生信息
  @RequestMapping(value = "/insertStudentInfo", method = RequestMethod.POST)
  public ServerResponse insertStudentInfo(@RequestBody(required = false) Student student) {
    boolean isRegistered = studentSystemService.snoIsExist(student.getSno());
    if (isRegistered) {
      return ServerResponse.createByError("此学号已被注册");
    }

    student.setStuCreateTime(new Date());
    int result = teacherStudentService.insertStudentInfo(student);
    if (result > 0) {
      return ServerResponse.createBySuccess("插入学生信息成功", null);
    } else {
      return ServerResponse.createByError("数据库错误，插入学生信息失败");
    }
  }

  //    获取成绩列表信息
  @RequestMapping("/getScoresList")
  public ServerResponse getScoresList() {
    Map<String, Object> map = new HashMap<>();
    List<Map<String, Object>> scoresList = teacherStudentService.getScoresList();
    map.put("scoresList", scoresList);
    List<Map<String, Object>> papersList = teacherStudentService.getPapersList();
    map.put("papersList", papersList);
    return ServerResponse.createBySuccess("获取全部成绩信息成功", map);
  }

  //  删除学生成绩
  @RequestMapping(value = "/deleteScore", method = RequestMethod.POST)
  public ServerResponse deleteScore(@RequestBody Map<String, Object> obj) {
    String sno = (String) obj.get("sno");
    Integer paperId = (Integer) obj.get("paperId");
    int result = teacherStudentService.deleteScore(sno, paperId);
    if (result > 0) {
      return ServerResponse.createBySuccess("删除成功", null);
    } else {
      return ServerResponse.createByError("数据库错误，删除失败");
    }
  }

  //    获取搜索成绩列表信息
  @RequestMapping("/searchScoresList")
  public ServerResponse searchScoresList(@RequestParam("sno") String sno,
                                         @RequestParam("paperId") Integer paperId) {
    List<Map<String, Object>> resultList = teacherStudentService.searchScoresList(sno, paperId);
    return ServerResponse.createBySuccess("获取搜索成绩信息成功", resultList);
  }

  //    获取全部已发布试卷信息
  @RequestMapping("/getPapersList")
  public ServerResponse getPapersList() {
    Map<String, Object> map = new HashMap<>();
    List<Map<String, Object>> papersList = teacherStudentService.getPapersList();
    map.put("papersList", papersList);
    return ServerResponse.createBySuccess("获取全部成绩信息成功", map);
  }

  // 获取成绩图标数据
  @RequestMapping("/getChartData")
  public ServerResponse getChartData(@RequestParam("paperId") Integer paperId) {
    Map<String, Object> resultMap = teacherStudentService.getChartData(paperId);
    return ServerResponse.createBySuccess("获取成绩图标数据成功", resultMap);
  }

  // 添加导入学生信息Excel文件
  @RequestMapping(value = "/insertStudentInfoList", method = RequestMethod.POST)
  public ServerResponse insertStudentInfoList(@RequestBody Map<String, Object> obj) {
    List<Map<String, Object>> studentList = (List<Map<String, Object>>) obj.get("studentList");
    Map<String, Object> result = teacherStudentService.insertStudentInfoList(studentList);
    return ServerResponse.createBySuccess("文件上传成功", result);
  }
}
