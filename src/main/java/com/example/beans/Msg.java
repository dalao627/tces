package com.example.beans;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: SiJi
 * @date: 2019/09/19
 */
@Data
public class Msg {
    private Integer code;
    private String msg;
    private Map<String,Object> extend = new HashMap<String,Object>();

    /**
     * 成功
     * @return
     */
    public static Msg success(){
        Msg result = new Msg();
        result.setCode(200);
        result.setMsg("处理成功");
        return result;
    }

    /**
     * 失败
     * @return
     */
    public static Msg fail(){
        Msg result = new Msg();
        result.setCode(100);
        result.setMsg("处理失败");
        return result;
    }

    /**
     * 保存信息
     * @param key
     * @param value
     * @return
     */
    public Msg add(String key,Object value){
        getExtend().put(key,value);
        return this;
    }
}
