package com.smart.service;

import com.smart.pojo.user;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class userService {
    @Autowired
    private com.smart.dao.userMapper userMapper;

    /*
     * 检验用户登录业务
     *
     */

    public user checkLogin(String userName, String password) {

        user user = userMapper.findByName(userName);

        if(user != null && user.getPassword().equals(password)){

            return user;
        }

        return null;
    }

    public int insert(String userName,String password,String name,String age,String birthday,String sex){
        user user1=userMapper.findByName(userName);
        if(user1!=null){
            System.out.println("用户名已存在");
            return 0;
        }
        else{
            System.out.println("111");
            user1=new user();
            user1.setUserName(userName);
            user1.setPassword(password);
            user1.setName(name);
            user1.setAge(age);
            user1.setBirthday(birthday);
            user1.setSex(sex);
            System.out.println("333");
            userMapper.insertUser(user1);
            System.out.println("222");
            return 1;
        }
    }

    public user findUser(String userName){
        return userMapper.findByName(userName);
    }
}
