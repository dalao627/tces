package com.example.controller;


import com.example.beans.EvaluateItem;
import com.example.service.EvaluateItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/**
 * <p>
 * 评价标准选项表 前端控制器
 * </p>
 *
 * @author siji
 * @since 2019-09-19
 */
@RestController
@RequestMapping("/evaluateItem")
public class EvaluateItemController {
    @Autowired
    private EvaluateItemService evaluateItemService;
    /** 插入题库数据*/
    @GetMapping("/init")
    public void insertEvaluate() {
        List<EvaluateItem> list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            EvaluateItem evaluateItem = new EvaluateItem();
            evaluateItem.setItemDesc("综合表现" + i);
            evaluateItem.setItemType((int) (Math.random() * 4));
            evaluateItem.setOption1("优秀");
            evaluateItem.setOption2("良好");
            evaluateItem.setOption3("一般");
            evaluateItem.setOption4("较差");
            list.add(evaluateItem);
        }
       // System.out.println(list);
        evaluateItemService.saveBatch(list);
    }

}

