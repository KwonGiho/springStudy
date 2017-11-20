package com.example.demo.controller;


import com.example.demo.Dao.BoardMongoRepository;
import com.example.demo.Model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by kwongiho on 2017. 11. 18..
 */
@RestController
public class BoardController {
    @Autowired
    private BoardMongoRepository boardMongoRepository;

    @Autowired
    private BoardRepository boardRepository;
//
//    private BoardService boardService;
//    @Autowired
//    public void setProductService(BoardService boardService) {
//
//        this.boardService = boardService;
//    }



    @PostMapping(value="/v1/board")
    public BoardSkeleton newBoard(@RequestBody Board boardCreate) {
        return boardMongoRepository.save(boardCreate);
    }

    @GetMapping(value="/v1/board/{title}")
    public BoardSkeleton findByTitle(@PathVariable String title) {
        return boardMongoRepository.findByTitle(title);
    }

    @PutMapping(value="/v1/board")
    public BoardSkeleton putBoard(@RequestBody BoardUpdate boardUpdate) {
        BoardSkeleton board = boardUpdate;
        board.setBody(boardUpdate.getNewBody());
        return boardMongoRepository.save(board);
    }

    @DeleteMapping(value="/v1/board")
    public BoardSkeleton deleteBoard(@RequestBody BoardDelete boardDelete) {
        boardMongoRepository.delete(boardDelete);
        return boardMongoRepository.findByTitle(boardDelete.getTitle());
    }


    /*-----------------------below, for redis----------------------*/


    @PostMapping(value="/v2/board")
    public BoardSkeleton createNewBoard(@RequestBody Board boardCreate) {
        //return this.boardRepository.save(boardCreate);
        return boardRepository.save(boardCreate);
    }

    @GetMapping(value="/v2/board/{id}")
    public BoardSkeleton searchBoard(@PathVariable String id) {
        //return boardRepository.findOne(id);
        return boardRepository.findOne(id);
    }

    @PutMapping(value="/v2/board")
    public BoardSkeleton modifyingBoard(@RequestBody BoardUpdate boardUpdate) {
        BoardSkeleton board = boardUpdate;
        board.setBody(boardUpdate.getNewBody());
        return boardMongoRepository.save(board);
    }

    @DeleteMapping(value="/v2/board")
    public BoardSkeleton removeBoard(@RequestBody BoardDelete boardDelete) {
        boardMongoRepository.delete(boardDelete);
        return boardMongoRepository.findByTitle(boardDelete.getTitle());
    }

}