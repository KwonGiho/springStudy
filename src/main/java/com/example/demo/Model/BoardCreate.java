package com.example.demo.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;

/**
 * Created by kwongiho on 2017. 11. 18..
 */
@Data
@AllArgsConstructor
@NoArgsConstructor

@Document(collection="board")
public class BoardCreate implements Serializable,Board {
    @Id
    @Field("_id")
    private String id;
    @Field("title")
    private String title;
    @Field("body")
    private String body;
}
