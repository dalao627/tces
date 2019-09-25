package com.example.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.beans.*;
import com.example.service.*;
import com.example.util.Utils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: SiJi
 * @date: 2019/09/19
 */
@Controller
public class ViewController {

    @Autowired
   private RoleService roleService;

    @Autowired
    private AdminService adminService;

    @Autowired
    private StudentService studentService;

    @Autowired
    private TeacherService teacherService;
    @Autowired
    private  CourseService courseService;

    /**
     * 管理员主界面
     *
     * @return 页面
     */
    @GetMapping("/admin")
    public String index() {
        return "admin";
    }

    /**
     * 登录界面
     *
     * @return 返回用户角色列表
     */
    @GetMapping("/login")
    public ModelAndView login() {
        List<Role> list = roleService.list();
        ModelAndView mv = new ModelAndView();
        mv.addObject("list", list);
        mv.setViewName("login");
        return mv;
    }



    @PostMapping("/login/{roleId}")
    @ResponseBody
    public Msg checkLogin(@PathVariable("roleId") Integer roleId, Integer no, String pass) {
        if (roleId == 1) {
            Admin admin = adminService.getOne(
                    new LambdaQueryWrapper<Admin>()
                            .eq(Admin::getAdminCount, no)
                            .eq(Admin::getAdminPassword, pass));
            if (admin != null) {
                return Msg.success().add("no", no);
            } else {
                return Msg.fail();
            }

        } else if (roleId == 2) {
            Teacher teacher = teacherService.getOne(
                    new LambdaQueryWrapper<Teacher>()
                            .eq(Teacher::getTeacherNo, no));
            if (teacher != null) {
                return Msg.success().add("no", no);
            } else {
                return Msg.fail();
            }
        } else {
            Student student = studentService.getOne(
                    new LambdaQueryWrapper<Student>()
                            .eq(Student::getStudentNo, no)
                            .eq(Student::getStudentName, pass));
            if (student != null) {
                return Msg.success().add("no", no);
            } else {
                return Msg.fail();
            }
        }

    }
}
