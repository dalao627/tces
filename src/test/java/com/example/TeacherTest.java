package com.example;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author: SiJi
 * @date: 2019/09/19
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TeacherTest {

    //@Autowired
    //TeacherService teacherService;

    /**
     * 初始化老师信息
     */
   /* @Test
    public void initTeacher() {
        LocalDate date = LocalDate.of(1977, 12, 13);
        for (int i = 1; i < 1000; i++) {
            Teacher teacher = new Teacher(i, "jack" + i, "123456",
                                "男", 0, 2 ,
                    "1389025" + (int)(Math.random() * 9000 + 1000)
                    , date);
            teacherService.save(teacher);
            System.out.println("==============插入数据成功=============");
        }
    }*/
}
