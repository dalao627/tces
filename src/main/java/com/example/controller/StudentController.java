package com.example.controller;


import com.alibaba.fastjson.JSONObject;
import com.example.beans.Msg;
import com.example.beans.Student;
import com.example.service.StudentService;
import com.example.util.Utils;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 学生表 前端控制器
 * </p>
 *
 * @author siji
 * @since 2019-09-19
 */
@RestController
@RequestMapping("/admin/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    /**
     * 学生信息录入
     */
    @GetMapping("/init")
    public void intserStudent() {
        List<Student> list = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            Student student = new Student();
            student.setStudentId(i);
            student.setStudentNo((int) (Math.random() * 1000 + 500));
            student.setStudentName("王柏" + (int) (Math.random() * i));
            student.setStudentPassword((int) (Math.random() * 10) + "12" + (int) (Math.random() * 10));
            if (i % 2 == 0) {
                student.setStudentSex("女");
            } else {
                student.setStudentSex("男");
            }
            student.setStudentGradeId((int) (Math.random() * 100 + 40));
            if (i % 2 == 0) {
                student.setStudentStatus(0);
            } else {
                student.setStudentStatus(1);
            }
            student.setStudentRoleId(3);
            list.add(student);

        }
        studentService.updateBatchById(list);
    }

    /**
     * 查询所有学生信息页面
     */
    @GetMapping("/{pn}")
    public ModelAndView studentall(@PathVariable("pn") Integer pn) {
        List<Student> list = new ArrayList<>();
        return Utils.pageSelect(pn, studentService, list, "student");
    }

    /**
     * 删除学生信息
     */
    @DeleteMapping("/{ids}")
    public Msg delete(@PathVariable("ids") String ids) {
        return Utils.delInfo(ids, studentService);
    }

    /**
     * 根据ID查询某个学生信息
     */
    @GetMapping("/update/{id}")
    public String updateId( @PathVariable("id") Integer id) {
        Student stu = studentService.getById(id);
        JSONObject jsonObject = new JSONObject();
        String jsonDatas=jsonObject.toJSONString(stu);
        return jsonDatas;
    }
    /**
     * 根据ID修改学生信息
     *
     */
    @PutMapping("/{upId}")
    public boolean upStudent(@PathVariable("upId") Integer Id,Integer studentId,Integer studentNo,String studentName,String studentSex,Integer studentGradeId,String studentStatus){
        Student stu=new Student();
        stu.setStudentId(Id);
        stu.setStudentNo(studentNo);
        stu.setStudentNo(studentNo);
        stu.setStudentName(studentName);
        stu.setStudentSex(studentSex);
        stu.setStudentGradeId(studentGradeId);
        stu.setStudentStatus(studentStatus == "已评价"?1:0);
       boolean student=studentService.updateById(stu);
        return student;
    }

}

