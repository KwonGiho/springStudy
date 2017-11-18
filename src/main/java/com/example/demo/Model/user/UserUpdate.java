package com.example.demo.Model.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Created by kwongiho on 2017. 11. 18..
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserUpdate implements User,Serializable{
    private String id;
    private String password;
    private String afterPassword;
}
