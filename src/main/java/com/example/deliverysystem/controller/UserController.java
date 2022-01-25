package com.example.deliverysystem.controller;

import com.example.deliverysystem.entity.User;
import com.example.deliverysystem.repository.UserRepository;
import com.example.deliverysystem.utils.MyJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

import static com.example.deliverysystem.utils.MyFunction.findKeyByValue;
import static com.example.deliverysystem.utils.Token.tokenMap;

/**
 * @Author Lang wenchong
 * @Date 2021/12/25 17:31
 * @Version 1.0
 */

@RestController
@RequestMapping(value = "/api/user")
public class UserController {
    @Autowired
    UserRepository userRepository;

    @RequestMapping(value = "/login")
    private MyJson login(@RequestParam("username") String username,
                         @RequestParam("password") String password) {
        MyJson myJson = new MyJson();
        User u = userRepository.findUserByUsername(username);
        if (u == null || !u.getPassword().equals(password)) {
            myJson.setStatus(403);
            myJson.setMessage("Wrong username or password");
            return myJson;
        }
        String temp = findKeyByValue(username, tokenMap);
        String token = temp == null ? UUID.randomUUID().toString() : temp;
        tokenMap.put(token, username);
        myJson.setStatus(200);
        myJson.setResult(token);
        myJson.setMessage("Welcome " + username);
        return myJson;
    }
}
