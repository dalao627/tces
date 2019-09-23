package com.example.beans;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.time.LocalDate;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 教师表
 * </p>
 *
 * @author siji
 * @since 2019-09-19
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Teacher extends Model<Teacher> {

    private static final long serialVersionUID=1L;

    /**
     * id
     */
    @TableId(value = "teacher_id", type = IdType.AUTO)
    private Integer teacherId;

    /**
     * 工号
     */
    @TableField("teacher_no")
    private Integer teacherNo;

    /**
     * 名字
     */
    @TableField("teacher_name")
    private String teacherName;

    /**
     * 密码
     */
    @TableField("teacher_password")
    private String teacherPassword;

    /**
     * 性别
     */
    @TableField("teacher_sex")
    private String teacherSex;

    /**
     * 0:未评价 1:已评价
     */
    @TableField("teacher_status")
    private Integer teacherStatus;

    /**
     * 职位
     */
    @TableField("teacher_role_id")
    private Integer teacherRoleId;

    /**
     * 联系方式
     */
    @TableField("teacher_tel")
    private String teacherTel;

    /**
     * 生日
     */
    @TableField("teacher_birth")
    private LocalDate teacherBirth;


    @Override
    protected Serializable pkVal() {
        return this.teacherId;
    }

    public Integer getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Integer teacherId) {
        this.teacherId = teacherId;
    }

    public Integer getTeacherNo() {
        return teacherNo;
    }

    public void setTeacherNo(Integer teacherNo) {
        this.teacherNo = teacherNo;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getTeacherPassword() {
        return teacherPassword;
    }

    public void setTeacherPassword(String teacherPassword) {
        this.teacherPassword = teacherPassword;
    }

    public String getTeacherSex() {
        return teacherSex;
    }

    public void setTeacherSex(String teacherSex) {
        this.teacherSex = teacherSex;
    }

    public Integer getTeacherStatus() {
        return teacherStatus;
    }

    public void setTeacherStatus(Integer teacherStatus) {
        this.teacherStatus = teacherStatus;
    }

    public Integer getTeacherRoleId() {
        return teacherRoleId;
    }

    public void setTeacherRoleId(Integer teacherRoleId) {
        this.teacherRoleId = teacherRoleId;
    }

    public String getTeacherTel() {
        return teacherTel;
    }

    public void setTeacherTel(String teacherTel) {
        this.teacherTel = teacherTel;
    }

    public LocalDate getTeacherBirth() {
        return teacherBirth;
    }

    public void setTeacherBirth(LocalDate teacherBirth) {
        this.teacherBirth = teacherBirth;
    }
}
