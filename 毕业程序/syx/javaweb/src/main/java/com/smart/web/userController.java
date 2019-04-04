package com.smart.web;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.smart.pojo.user;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/user")
@SessionAttributes("user")
public class userController {
    @Autowired
    private com.smart.service.userService userService;

    //正常访问login页面
    @RequestMapping("/login")
    public String login(){
        return "login";
    }

    @RequestMapping("/s")
    public String s(){
        return "success";
    }

    @RequestMapping("/s1")
    public String s1(){
        return "success1";
    }

    @RequestMapping("/s2")
    public String s2(){
        return "success2";
    }

    //表单提交过来的路径
   /* @RequestMapping("/checkLogin")
    public String checkLogin(user user, Model model){
        //调用service方法
        user = userService.checkLogin(user.getUserName(), user.getPassword());
        //若有user则添加到model里并且跳转到成功页面
        if(user != null){
            model.addAttribute("user",user);
            return "success";
        }
        return "fail";
    }*/
    @RequestMapping(value = "/checkLogin",produces = "text/html;charset=UTF-8")
    public @ResponseBody
    String checkUserLogin(String userName,String password){
        System.out.println(userName);
        System.out.println(password);
        user user = userService.checkLogin(userName, password);
        String s;
        if(user==null)
            s="null";
        else{
            s = JSON.toJSONString(user);
            System.out.println(s);

        }
        return s;
    }

    @RequestMapping(value ="/insertUser",produces = "text/html;charset=UTF-8")
    public @ResponseBody
    String insertUser(String userName,String password,String name,String age,String birthday,String sex)throws IOException {
        String  name1 = new String(name.getBytes("ISO8859_1"), "UTF-8");
        String  age1 = new String(age.getBytes("ISO8859_1"), "UTF-8");
        String  birthday1 = new String(birthday.getBytes("ISO8859_1"), "UTF-8");
        String  sex1 = new String(sex.getBytes("ISO8859_1"), "UTF-8");
        int result= userService.insert(userName,password,name1,age1,birthday1,sex1);
        String s;
        if(result==1)
            s="ok";
        else
            s="no";
        System.out.println(s);
        return s;
    }

    @RequestMapping(value="/findUser",produces = "text/html;charset=UTF-8")
    public @ResponseBody
    String findUser(String userName){
        String s;
        user user= userService.findUser(userName);
        s = JSON.toJSONString(user);
        return s;
    }


}
