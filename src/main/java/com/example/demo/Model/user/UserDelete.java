package com.example.demo.Model.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Created by kwongiho on 2017. 11. 18..
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class UserDelete implements User,Serializable{
    private String id;
    private String password;
    private Boolean isAgree;
}
