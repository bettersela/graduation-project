package com.smart.service;

import com.smart.dao.ydMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.smart.pojo.yd;

import java.util.List;

@Service
public class ydService {
    @Autowired
    private ydMapper ydMapper;

    public int insertyd(String sday,String eday,String name,String time,String amount,String userName){
        yd yd1=new yd();
        yd1.setSday(sday);
        yd1.setEday(eday);
        yd1.setName(name);
        yd1.setTime(time);
        yd1.setAmount(amount);
        yd1.setUserName(userName);
        ydMapper.insertyd(yd1);
        return 1;
    }

    public int deleteyd(int id){
        ydMapper.deleteyd(id);
        return 1;
    }

    public int updateyd(int id,String sday,String eday,String time,String amount){
        yd yd1=new yd();
        yd1.setId(id);
        yd1.setSday(sday);
        yd1.setEday(eday);
        yd1.setTime(time);
        yd1.setAmount(amount);
        ydMapper.updateyd(yd1);
        return 1;
    }

    public List<yd> findAll(String userName){
        return ydMapper.findAll(userName);
    }

    public List<yd> findByName(String name,String userName){
        yd yd=new yd();
        yd.setName(name);
        yd.setUserName(userName);
        return ydMapper.findByName(yd);
    }
}
