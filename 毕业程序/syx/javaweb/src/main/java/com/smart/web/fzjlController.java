package com.smart.web;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.smart.pojo.user;
import com.smart.service.fzjlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/fzjl")
public class fzjlController {
    @Autowired
    private fzjlService fzjlService;

    @RequestMapping(value ="/insertfzjl",produces = "text/html;charset=UTF-8")
    public @ResponseBody
    String insertfzjl(String year,String month,String day,String shichang,String leixing,String zhuangtai,String userName)throws IOException {
        String  shichang1 = new String(shichang.getBytes("ISO8859_1"), "UTF-8");
        String  leixing1 = new String(leixing.getBytes("ISO8859_1"), "UTF-8");
        String  zhuangtai1 = new String(zhuangtai.getBytes("ISO8859_1"), "UTF-8");
        int result= fzjlService.insertfzjl(year,month,day,shichang1,leixing1,zhuangtai1,userName);
        String s;
        if(result==1)
            s="ok";
        else
            s="no";
        return s;
    }

    @RequestMapping(value ="/deletefzjl",produces = "text/html;charset=UTF-8")
    public @ResponseBody
    String deletefzjl(int id){
        int result =fzjlService.deletefzjl(id);
        String s;
        if(result==1)
            s="ok";
        else
            s="no";
        return s;
    }
    @RequestMapping(value="/findAllfzjl",produces = "text/html;charset=UTF-8")
    public @ResponseBody
    String findAllfzjl(String userName)throws IOException {
        String  userName1 = new String(userName.getBytes("ISO8859_1"), "UTF-8");
        List list=fzjlService.findAll(userName1);
        JSONArray jsonarray = JSONArray.parseArray(JSON.toJSONString(list));
        return jsonarray.toString();
    }
    @RequestMapping(value="/findfzjlByDate",produces = "text/html;charset=UTF-8")
    public @ResponseBody
    String findfzjlByDate(String year,String month,String day,String userName)throws IOException {
        String  userName1 = new String(userName.getBytes("ISO8859_1"), "UTF-8");
        List list=fzjlService.findByDate(year,month,day,userName1);
        JSONArray jsonarray = JSONArray.parseArray(JSON.toJSONString(list));
        return jsonarray.toString();
    }
}
