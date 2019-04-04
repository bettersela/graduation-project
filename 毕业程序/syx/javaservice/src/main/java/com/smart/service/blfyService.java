package com.smart.service;

import com.smart.dao.blfyMapper;
import com.smart.pojo.blfy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class blfyService {
    @Autowired
    private blfyMapper blfyMapper;

    public int insertblfy(String name,String shijian,String fanying,String chixushijian,String userName){
        blfy blfy1=new blfy();
        blfy1.setName(name);
        blfy1.setShijian(shijian);
        blfy1.setFanying(fanying);
        blfy1.setChixushijian(chixushijian);
        blfy1.setUserName(userName);
        blfyMapper.insertblfy(blfy1);
        return 1;
    }

    public int deleteblfy(int id){
        blfyMapper.deleteblfy(id);
        return 1;
    }

    public List<blfy> findAll(String userName){
        return blfyMapper.findAll(userName);
    }

    public List<blfy> findByName(String name,String userName){
        blfy blfy=new blfy();
        blfy.setName(name);
        blfy.setUserName(userName);
        return blfyMapper.findByName(blfy);
    }

}
