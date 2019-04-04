package com.smart.web;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.smart.service.ydService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/yd")
public class ydController {

    @Autowired
    private ydService ydService;

    @RequestMapping(value ="/insertyd",produces = "text/html;charset=UTF-8")
    public @ResponseBody
    String insertyd(String sday,String eday,String name,String time,String amount,String userName)throws IOException {
        String  sday1 = new String(sday.getBytes("ISO8859_1"), "UTF-8");
        String  eday1 = new String(eday.getBytes("ISO8859_1"), "UTF-8");
        String  name1 = new String(name.getBytes("ISO8859_1"), "UTF-8");
        String  time1 = new String(time.getBytes("ISO8859_1"), "UTF-8");
        String  amount1 = new String(amount.getBytes("ISO8859_1"), "UTF-8");
        int result= ydService.insertyd(sday1,eday1,name1,time1,amount1,userName);
        String s;
        if(result==1)
            s="ok";
        else
            s="no";
        return s;
    }

    @RequestMapping("/deleteyd")
    public @ResponseBody
    String deleteyd(int id){
        int result =ydService.deleteyd(id);
        String s;
        if(result==1)
            s="ok";
        else
            s="no";
        return s;
    }

    @RequestMapping(value ="/updateyd",produces = "text/html;charset=UTF-8")
    public @ResponseBody
    String updateyd(int id,String sday,String eday,String time,String amount)throws IOException {
        String  sday1 = new String(sday.getBytes("ISO8859_1"), "UTF-8");
        String  eday1 = new String(eday.getBytes("ISO8859_1"), "UTF-8");
        String  time1 = new String(time.getBytes("ISO8859_1"), "UTF-8");
        String  amount1 = new String(amount.getBytes("ISO8859_1"), "UTF-8");
        int result= ydService.updateyd(id,sday1,eday1,time1,amount1);
        String s;
        if(result==1)
            s="ok";
        else
            s="no";
        return s;
    }

    @RequestMapping(value="/findAllyd",produces = "text/html;charset=UTF-8")
    public @ResponseBody
    String findAllyd(String userName)throws IOException {
        String  userName1 = new String(userName.getBytes("ISO8859_1"), "UTF-8");
        System.out.println(userName1);
        List list=ydService.findAll(userName1);
        JSONArray array=new JSONArray();
        JSONArray jsonarray = JSONArray.parseArray(JSON.toJSONString(list));
        return jsonarray.toString();
        /*for(int i = 0 ; i < list.size() ; i++) {
            array.add(JSON.toJSONString(list.get(i)));
        }*/
        //JSONObject result=new JSONObject();
        //result.put("data",array);
        //return array.toString();
    }
    @RequestMapping(value="/findydByName",produces = "text/html;charset=UTF-8")
    public @ResponseBody
    String findydByName(String name,String userName)throws IOException {
        String  userName1 = new String(userName.getBytes("ISO8859_1"), "UTF-8");
        String  name1 = new String(name.getBytes("ISO8859_1"), "UTF-8");
        List list=ydService.findByName(name1,userName1);
        JSONArray array=new JSONArray();
        JSONArray jsonarray = JSONArray.parseArray(JSON.toJSONString(list));
        return jsonarray.toString();

    }
}
