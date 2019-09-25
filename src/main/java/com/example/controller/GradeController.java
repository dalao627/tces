package com.example.controller;


import com.example.beans.Grade;
import com.example.service.GradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 班级表 前端控制器
 * </p>
 *
 * @author siji
 * @since 2019-09-19
 */
@RestController
@RequestMapping("/grade")
public class GradeController {

    @Autowired
    private GradeService gradeService;
    /** 插入班级*/
    @GetMapping("/init")
    public  void  insertGrade(){
        List<Grade> list =new ArrayList<>();
        for (int i = 0; i < 150; i++) {
            Grade grade=new Grade();
            grade.setGradeId(i);
            grade.setGradeName("java"+((int)(Math.random()*10))+"班");
            list.add(grade);
            //System.out.println(list);
        }
        gradeService.updateBatchById(list);
    }

}

