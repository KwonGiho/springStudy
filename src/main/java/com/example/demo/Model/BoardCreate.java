package com.example.demo.Model;

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
public class BoardCreate implements Serializable,Board{
    private int id;
    private String title;
    private String body;
}
