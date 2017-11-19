package com.example.demo.controller;


import com.example.demo.Dao.BoardMongoRepository;
import com.example.demo.Model.Board;
import com.example.demo.Model.BoardCreate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by kwongiho on 2017. 11. 18..
 */
@RestController
public class BoardController {
    @Autowired
    private BoardMongoRepository boardMongoRepository;

    @PostMapping(value="/board")
    public Board newBoard(@RequestBody BoardCreate boardCreate) {
        return boardMongoRepository.save(boardCreate);
    }

    @GetMapping(value="/board/{title}")
    public Board findByTitle(@PathVariable String title) {
        return boardMongoRepository.findByTitle(title);
    }

}