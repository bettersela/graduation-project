package com.smart.web;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.smart.service.fyycService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/fyyc")
public class fyycController {
    @Autowired
    private fyycService fyycService;

    @RequestMapping(value ="/insertfyyc",produces = "text/html;charset=UTF-8")
    public @ResponseBody
    String insertfyyc(String name,String shijian,String leixing,String yongliang,String userName)throws IOException {
        String  name1 = new String(name.getBytes("ISO8859_1"), "UTF-8");
        String  shijian1 = new String(shijian.getBytes("ISO8859_1"), "UTF-8");
        String  leixing1 = new String(leixing.getBytes("ISO8859_1"), "UTF-8");
        String  yongliang1 = new String(yongliang.getBytes("ISO8859_1"), "UTF-8");
        int result= fyycService.insertfyyc(name1,shijian1,leixing1,yongliang1,userName);
        String s;
        if(result==1)
            s="ok";
        else
            s="no";
        return s;
    }

    @RequestMapping("/deletefyyc")
    public @ResponseBody
    String deletefyyc(int id){
        int result =fyycService.deletefyyc(id);
        String s;
        if(result==1)
            s="ok";
        else
            s="no";
        return s;
    }
    @RequestMapping(value="/findAllfyyc",produces = "text/html;charset=UTF-8")
    public @ResponseBody
    String findAllfyyc(String userName)throws IOException {
        String  userName1 = new String(userName.getBytes("ISO8859_1"), "UTF-8");
        List list=fyycService.findAll(userName1);
        JSONArray jsonarray = JSONArray.parseArray(JSON.toJSONString(list));
        return jsonarray.toString();
    }
    @RequestMapping(value="/findfyycByName",produces = "text/html;charset=UTF-8")
    public @ResponseBody
    String findfyycByName(String name,String userName)throws IOException {
        String  userName1 = new String(userName.getBytes("ISO8859_1"), "UTF-8");
        String  name1 = new String(name.getBytes("ISO8859_1"), "UTF-8");
        List list=fyycService.findByName(name1,userName1);
        JSONArray jsonarray = JSONArray.parseArray(JSON.toJSONString(list));
        return jsonarray.toString();
    }
}
