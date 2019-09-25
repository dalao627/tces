package com.example.util;

import lombok.Data;

@Data
public class ResultMsg {
    private  String content;
    private  Integer count;
    public  ResultMsg( Integer count,String content){
        this.content=content;
        this.count=count;
    }

}
