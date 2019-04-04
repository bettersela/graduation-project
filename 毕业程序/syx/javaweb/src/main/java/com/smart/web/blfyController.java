package com.smart.web;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.smart.service.blfyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/blfy")
public class blfyController {
    @Autowired
    private blfyService blfyService;

    @RequestMapping(value ="/insertblfy",produces = "text/html;charset=UTF-8")
    public @ResponseBody
    String insertblfy(String name,String shijian,String fanying,String chixushijian,String userName)throws IOException {
        String  name1 = new String(name.getBytes("ISO8859_1"), "UTF-8");
        String  shijian1 = new String(shijian.getBytes("ISO8859_1"), "UTF-8");
        String  fanying1 = new String(fanying.getBytes("ISO8859_1"), "UTF-8");
        String  chixushijian1 = new String(chixushijian.getBytes("ISO8859_1"), "UTF-8");
        int result= blfyService.insertblfy(name1,shijian1,fanying1,chixushijian1,userName);
        String s;
        if(result==1)
            s="ok";
        else
            s="no";
        return s;
    }

    @RequestMapping("/deleteblfy")
    public @ResponseBody
    String deleteblfy(int id){
        int result =blfyService.deleteblfy(id);
        String s;
        if(result==1)
            s="ok";
        else
            s="no";
        return s;
    }
    @RequestMapping(value="/findAllblfy",produces = "text/html;charset=UTF-8")
    public @ResponseBody
    String findAllblfy(String userName)throws IOException {
        String  userName1 = new String(userName.getBytes("ISO8859_1"), "UTF-8");
        List list=blfyService.findAll(userName1);
        JSONArray jsonarray = JSONArray.parseArray(JSON.toJSONString(list));
        return jsonarray.toString();
    }
    @RequestMapping(value="/findblfyByName",produces = "text/html;charset=UTF-8")
    public @ResponseBody
    String findblfyByName(String name,String userName)throws IOException {
        String  userName1 = new String(userName.getBytes("ISO8859_1"), "UTF-8");
        String  name1 = new String(name.getBytes("ISO8859_1"), "UTF-8");
        List list=blfyService.findByName(name1,userName1);
        JSONArray jsonarray = JSONArray.parseArray(JSON.toJSONString(list));
        return jsonarray.toString();
    }

}
