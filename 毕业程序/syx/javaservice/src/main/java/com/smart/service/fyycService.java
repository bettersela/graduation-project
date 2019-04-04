package com.smart.service;

import com.smart.dao.fyycMapper;
import com.smart.pojo.fyyc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class fyycService {
    @Autowired
    private fyycMapper fyycMapper;

    public int insertfyyc(String name,String shijian,String leixing,String yongliang,String userName){
        fyyc fyyc1=new fyyc();
        fyyc1.setName(name);
        fyyc1.setShijian(shijian);
        fyyc1.setLeixing(leixing);
        fyyc1.setYongliang(yongliang);
        fyyc1.setUserName(userName);
        fyycMapper.insertfyyc(fyyc1);
        return 1;
    }

    public int deletefyyc(int id){
        fyycMapper.deletefyyc(id);
        return 1;
    }

    public List<fyyc> findAll(String userName){
        return fyycMapper.findAll(userName);
    }

    public List<fyyc> findByName(String name,String userName){
        fyyc fyyc=new fyyc();
        fyyc.setName(name);
        fyyc.setUserName(userName);
        return fyycMapper.findByName(fyyc);
    }

}
