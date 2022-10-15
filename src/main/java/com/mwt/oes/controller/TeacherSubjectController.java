package com.mwt.oes.controller;

import com.mwt.oes.domain.ProgramingLanguage;
import com.mwt.oes.service.TeacherSubjectService;
import com.mwt.oes.util.ServerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/api/teacher")
public class TeacherSubjectController {
    @Autowired
    private TeacherSubjectService teacherSubjectService;

    // 获取全部科目信息
    @RequestMapping("getSubjectsList")
    public ServerResponse getSubjectsList() {
        List<Map<String, Object>> resultList = teacherSubjectService.getSubjectsList();
        return ServerResponse.createBySuccess("获取全部科目信息成功",resultList);
    }

    // 获取搜索科目信息
    @RequestMapping("/searchSubjectsList")
    public ServerResponse searchSubjectsList(@RequestParam("langName")String langName,
                                             @RequestParam("langDesc")String langDesc,
                                             @RequestParam("langCreatedBy")String langCreatedBy,
                                             @RequestParam("isRecommend")String isRecommend) {
        List<Map<String, Object>> resultList = teacherSubjectService.searchSubjectsList(langName, langDesc, langCreatedBy, isRecommend);
        return ServerResponse.createBySuccess("获取搜索科目信息成功",resultList);
    }

    // 添加科目信息
    @RequestMapping(value = "/insertSubjectInfo",method = RequestMethod.POST)
    public ServerResponse insertSubjectInfo(@RequestBody(required = false) ProgramingLanguage programingLanguage) {
        int result = teacherSubjectService.insertSubjectInfo(programingLanguage);
        if (result > 0) {
            return ServerResponse.createBySuccess("添加科目信息成功",null);
        }
        else {
            return ServerResponse.createByError("数据库错误，添加科目信息失败");
        }
    }

    // 更新科目信息
    @RequestMapping(value = "/updateSubjectInfo",method = RequestMethod.POST)
    public ServerResponse updateSubjectInfo(@RequestBody(required = false)ProgramingLanguage programingLanguage) {
        int result = teacherSubjectService.updateSubjectInfo(programingLanguage);
        if (result > 0) {
            return ServerResponse.createBySuccess("更新科目信息成功",null);
        }
        else {
            return ServerResponse.createByError("数据库错误，更新科目信息失败");
        }
    }

    // 删除科目信息
    @RequestMapping(value = "/deleteSubject",method = RequestMethod.POST)
    public ServerResponse deleteSubject(@RequestBody Map<String, Object> obj) {
        Integer langId = (Integer) obj.get("langId");
        int result = teacherSubjectService.deleteSubject(langId);
        if(result > 0) {
            return ServerResponse.createBySuccess("删除成功",null);
        } else {
            return ServerResponse.createByError("数据库错误，删除失败");
        }
    }
}
