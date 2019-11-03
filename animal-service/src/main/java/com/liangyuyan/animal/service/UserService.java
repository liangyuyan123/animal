package com.liangyuyan.animal.service;

import com.liangyuyan.animal.domain.User;

import java.util.Map;

public interface UserService {
    public int registerUser(User user);

    public int deleteUser(int id);

    public int updatePassword(Map<String,Object> map);

    public User userLogin(User user);

}
