package com.liangyuyan.animal.service.impl;

import com.liangyuyan.animal.dao.UserMapper;
import com.liangyuyan.animal.domain.User;
import com.liangyuyan.animal.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public int registerUser(User user) {
        User u= null;
        u = userMapper.selectByUserName(user.getUserName());
        int isSuccess = 0;
        if ( u == null ){
            isSuccess = userMapper.insert(user);
        }
        return isSuccess;
    }

    @Override
    public int deleteUser(int id) {
        int isSuccess = userMapper.deleteUser(id);
        return isSuccess;
    }

    @Override
    public int updatePassword(Map<String, Object> map) {
        int isSuccess = userMapper.updatePassword(map);
        return isSuccess;
    }

    @Override
    public User userLogin(User user) {
        User u = userMapper.userLogin(user);
        return u;
    }

}
