package com.example.demo.controller;

import com.example.demo.Mapper.UserMapper;
import com.example.demo.Model.UserRegister;
import com.example.demo.Model.UserUpdate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by kwongiho on 2017. 11. 18..
 */
@RestController
public class HelloWorldController {

    @Autowired
    UserMapper userMapper;

    private Logger logger = LoggerFactory.getLogger(getClass());
    @GetMapping(value="/{id}")
    public String welcome(@PathVariable String id) {
        logger.info("welcome({})",id);
        return "Hello "+ id;
    }
    @GetMapping(value="/user/{id}")
    public String searchUser(@PathVariable String id) {
        logger.info("searchUser({})",id);
        return userMapper.findById(id).toString();
    }
    @PostMapping(value="/user")
    public int insertUser(@RequestBody UserRegister user ) {
        logger.info("inserUser({},{})",user.getId(),user.getPassword());
        return userMapper.insert(user.getId(),user.getPassword());
    }
    @PutMapping(value="/user")
    public int updateUser(@RequestBody UserUpdate userUpdate) {
        logger.info("updateUser({},{}->{})",userUpdate.getId(),userUpdate.getPassword(),userUpdate.getAfterPassword());
        return userMapper.update(userUpdate.getId(),userUpdate.getPassword(),userUpdate.getAfterPassword());
    }
}
