package com.example.controller;


import com.example.beans.Course;
import com.example.service.CourseService;
import com.example.util.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 课程表 前端控制器
 * </p>
 *
 * @author siji
 * @since 2019-09-19
 */
@RestController
@RequestMapping("/admin/course")
public class CourseController {

    @Autowired
    private CourseService courseService;
    /** 插入课程信息*/

    @GetMapping("/init")
    public void init() {
        List<Course> list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            Course course = new Course(null, "java" + i, (int) (Math.random() * 40 + 10), 4);
            list.add(course);
        }
        courseService.saveBatch(list);
    }
    /**查看课程信息*/
    @GetMapping("/{pn}")
    public ModelAndView courseall(@PathVariable("pn") Integer pn) {
        List<Course> list = new ArrayList<>();
        return Utils.pageSelect(pn, courseService, list, "student");
    }
}

