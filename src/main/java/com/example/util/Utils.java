package com.example.util;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.beans.Msg;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: SiJi
 * @date: 2019/09/19
 */
public class Utils {

    /**
     * 封装分页查询方法
     *
     * @param pn 查询页码
     * @param service 要使用的 service
     * @param list 用来保存查询到的信息
     * @param viewName 返回的视图
     * @return ModelAndView 页面 + 前台需要的数据
     */
    public static ModelAndView pageSelect(Integer pn, IService service, List list, String viewName) {
        ModelAndView mv = new ModelAndView();
        PageHelper.startPage(pn, 8);
        list = service.list();
        PageInfo pageInfo = new PageInfo(list, 5);
        mv.addObject("pageInfo", pageInfo);
        mv.addObject("list", list);
        mv.setViewName(viewName);
        return mv;
    }


    /**
     * 通用删除方法
     *
     * @param ids 所有idz字符串
     * @param service 业务类
     * @return Msg
     */
    public static Msg delInfo(String ids, IService service) {
        // 如果 ids 包含 "-" 则进行批量删除, 否则进行单个删除
        // 创建集合存放 id
        List<Integer> delId = new ArrayList<>();
        if (ids.contains("-")) {
            String[] split = ids.split("-");
            // 遍历数组, 将 id 存放到集合里
            for (String id : split) {
                delId.add(Integer.parseInt(id));
            }

            boolean isDel = service.removeByIds(delId);
            if (isDel) {
                return Msg.success();
            } else {
                return Msg.fail();
            }
        } else {
            // 单个删除
            int id = Integer.parseInt(ids);
            boolean isDel = service.removeById(id);
            if (isDel) {
                return Msg.success();
            } else {
                return Msg.fail();
            }
        }
    }


}
