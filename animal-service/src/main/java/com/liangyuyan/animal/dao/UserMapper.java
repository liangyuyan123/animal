package com.liangyuyan.animal.dao;

import com.liangyuyan.animal.domain.User;

import java.util.Map;

public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int deleteUser(Integer id);

    int insert(User record);

    int updatePassword(Map<String,Object> map);

    User userLogin(User user);

    User selectByUserName(String userName);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}