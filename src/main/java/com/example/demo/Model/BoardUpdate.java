package com.example.demo.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Created by kwongiho on 2017. 11. 19..
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BoardUpdate implements BoardSkeleton,Serializable {
    private String id;
    private String title;
    private String body;
    private String newBody;

}
