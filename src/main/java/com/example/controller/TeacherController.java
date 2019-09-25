package com.example.controller;


import com.example.beans.Msg;
import com.example.beans.Teacher;
import com.example.service.TeacherService;
import com.example.util.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 教师表 前端控制器
 * </p>
 *
 * @author siji
 * @since 2019-09-19
 */
@RestController
@RequestMapping("/admin/teacher")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;
    /**  删除教师信息 */
    @DeleteMapping("/{ids}")
    public Msg delete(@PathVariable("ids") String ids) {
       return Utils.delInfo(ids, teacherService);
    }

    /** 查询教师信息页面*/
    @GetMapping("/{pn}")
    public ModelAndView teacherAdmin(@PathVariable("pn") Integer pn) {
        List<Teacher> list = new ArrayList<>();
        return Utils.pageSelect(pn, teacherService, list, "teacherAdmin");
    }
}

