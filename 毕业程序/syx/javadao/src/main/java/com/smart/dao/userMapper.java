
package com.smart.dao;

import com.smart.pojo.user;

public interface userMapper {
    user findByName(String userName);
    int insertUser(user user);
}