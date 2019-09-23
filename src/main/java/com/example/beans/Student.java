package com.example.beans;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 学生表
 * </p>
 *
 * @author siji
 * @since 2019-09-19
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Student extends Model<Student> {

    private static final long serialVersionUID=1L;

    @TableId(value = "student_id", type = IdType.AUTO)
    private Integer studentId;

    @TableField("student_no")
    private Integer studentNo;

    /**
     * 姓名
     */
    @TableField("student_name")
    private String studentName;

    /**
     * 密码
     */
    @TableField("student_password")
    private String studentPassword;

    /**
     * 性别
     */
    @TableField("student_sex")
    private String studentSex;

    /**
     * 班级id
     */
    @TableField("student_grade_id")
    private Integer studentGradeId;

    @TableField("student_status")
    private Integer studentStatus;

    @TableField("student_role_id")
    private Integer studentRoleId;


    @Override
    protected Serializable pkVal() {
        return this.studentId;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public Integer getStudentNo() {
        return studentNo;
    }

    public void setStudentNo(Integer studentNo) {
        this.studentNo = studentNo;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentPassword() {
        return studentPassword;
    }

    public void setStudentPassword(String studentPassword) {
        this.studentPassword = studentPassword;
    }

    public String getStudentSex() {
        return studentSex;
    }

    public void setStudentSex(String studentSex) {
        this.studentSex = studentSex;
    }

    public Integer getStudentGradeId() {
        return studentGradeId;
    }

    public void setStudentGradeId(Integer studentGradeId) {
        this.studentGradeId = studentGradeId;
    }

    public Integer getStudentStatus() {
        return studentStatus;
    }

    public void setStudentStatus(Integer studentStatus) {
        this.studentStatus = studentStatus;
    }

    public Integer getStudentRoleId() {
        return studentRoleId;
    }

    public void setStudentRoleId(Integer studentRoleId) {
        this.studentRoleId = studentRoleId;
    }
}
