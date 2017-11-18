package com.example.demo.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Created by kwongiho on 2017. 11. 18..
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRegister implements Serializable,User{
    private String id;
    private String password;
}
