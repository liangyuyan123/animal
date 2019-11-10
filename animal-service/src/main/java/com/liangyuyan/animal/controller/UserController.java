package com.liangyuyan.animal.controller;

import com.liangyuyan.animal.domain.User;
import com.liangyuyan.animal.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    private UserService  userService;

    @RequestMapping("/user/register")
    public String registerUser(@RequestBody User user){
       int isSucces = userService.registerUser(user);
       return String.valueOf(isSucces);
    }

    @RequestMapping(value = "/user/login",method = RequestMethod.GET)
    public User loginUser(@RequestParam("un") String userName ,
                            @RequestParam("pwd") String password,
                            @RequestParam("ut") String userType){
        User user = new User(userName,password,userType);
        User u = userService.userLogin(user);
        return u;
    }

    @RequestMapping("/user/delete/{id}")
    public String deleteUser(@PathVariable int id){
        int isSucces = userService.deleteUser(id);
        return String.valueOf(isSucces);
    }

    @RequestMapping("/user/updatePassword")
    public String updatePassword(@RequestParam("un") String userName ,@RequestParam("pwd") String password){
        Map<String,Object> userMap = new HashMap<>();
        userMap.put("userName",userName);
        userMap.put("password",password);
        int isSucces = userService.updatePassword(userMap);
        return String.valueOf(isSucces);
    }
}
