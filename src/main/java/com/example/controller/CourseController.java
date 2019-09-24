package com.example.controller;


import com.example.beans.Msg;
import com.example.service.CourseService;
import com.example.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

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
@RequestMapping("/course")
public class CourseController {
    @Autowired
    private CourseService courseService;

    @DeleteMapping("/{ids}")
    public Msg delete(@PathVariable("ids") String ids) {
        // 如果 ids 包含 "-" 则进行批量删除, 否则进行单个删除
        // 创建集合存放 id
        List<Integer> delId = new ArrayList<>();
        if (ids.contains("-")) {
            String[] split = ids.split("-");
            // 遍历数组, 将 id 存放到集合里
            for (String id : split) {
                delId.add(Integer.parseInt(id));
            }

            boolean isDel = courseService.removeByIds(delId);
            if (isDel) {
                return Msg.success();
            } else {
                return Msg.fail();
            }
        } else {
            // 单个删除
            int id = Integer.parseInt(ids);
            boolean isDel = courseService.removeById(id);
            if (isDel) {
                return Msg.success();
            } else {
                return Msg.fail();
            }
        }
    }


}

