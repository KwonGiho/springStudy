package com.example.demo.Model.user;

import org.junit.Test;

/**
 * Created by kwongiho on 2017. 11. 18..
 */
public class UserTest {

    @Test
    public void testUser() {
        UserRegister user = new UserRegister("rlgh9351","password1234");
        System.out.println(user.getId()=="rlgh9351");
    }


}
