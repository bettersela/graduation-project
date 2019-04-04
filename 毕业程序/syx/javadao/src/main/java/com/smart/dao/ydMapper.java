package com.smart.dao;

import java.util.List;
import com.smart.pojo.yd;

public interface ydMapper {
    List<yd> findByName(yd yd);
    List<yd> findAll(String userName);
    int insertyd(yd yd);
    int deleteyd(int id);
    int updateyd(yd yd);
}
