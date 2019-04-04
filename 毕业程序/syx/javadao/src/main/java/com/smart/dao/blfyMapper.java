package com.smart.dao;

import com.smart.pojo.blfy;

import java.util.List;

public interface blfyMapper {
    List<blfy> findAll(String userName);
    List<blfy> findByName(blfy blfy);
    int insertblfy(blfy blfy);
    int deleteblfy(int id);

}
