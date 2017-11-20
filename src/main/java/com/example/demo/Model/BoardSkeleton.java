package com.example.demo.Model;

/**
 * Created by kwongiho on 2017. 11. 18..
 */

public interface BoardSkeleton {
    String getId();
    String getTitle();
    String getBody();
    void setTitle(String title);
    void setBody(String body);
}
