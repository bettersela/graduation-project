package com.smart.dao;

import com.smart.pojo.fyyc;

import java.util.List;

public interface fyycMapper {
    List<fyyc> findAll(String userName);
    List<fyyc> findByName(fyyc fyyc);
    int insertfyyc(fyyc fyyc);
    int deletefyyc(int id);
}
