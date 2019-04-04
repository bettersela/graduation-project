package com.smart.service;

import com.smart.dao.fzjlMapper;
import com.smart.pojo.fzjl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class fzjlService {
    @Autowired
    private fzjlMapper fzjlMapper;

    public int insertfzjl(String year,String month,String day,String shichang,String leixing,String zhuangtai,String userName){
            fzjl fzjl1=new fzjl();
            fzjl1.setYear(year);
            fzjl1.setMonth(month);
            fzjl1.setDay(day);
            fzjl1.setShichang(shichang);
            fzjl1.setLeixing(leixing);
            fzjl1.setZhuangtai(zhuangtai);
            fzjl1.setUserName(userName);
            fzjlMapper.insertfzjl(fzjl1);
            return 1;
    }

    public int deletefzjl(int id){
            fzjlMapper.deletefzjl(id);
            return 1;
    }

    public List<fzjl> findAll(String userName){
        return fzjlMapper.findAll(userName);
    }

    public List<fzjl> findByDate(String year,String month,String day,String userName){
        fzjl fzjl=new fzjl();
        fzjl.setYear(year);
        fzjl.setMonth(month);
        fzjl.setDay(day);
        fzjl.setUserName(userName);
        return fzjlMapper.findByDate(fzjl);
    }
}
