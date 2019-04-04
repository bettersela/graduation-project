package com.smart.dao;

import com.smart.pojo.fzjl;

import java.util.List;

public interface fzjlMapper {
    List<fzjl> findAll(String userName);
    List<fzjl> findByDate(fzjl fzjl);
    int insertfzjl(fzjl fzjl);
    int deletefzjl(int id);
}
