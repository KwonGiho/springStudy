package com.example.demo.Model;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by kwongiho on 2017. 11. 19..
 */
@Data
public class BoardDelete implements BoardSkeleton,Serializable{
    private String id;
    private String title;
    private String body;
}
