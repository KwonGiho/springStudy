package com.example.demo.controller;


import com.example.demo.Dao.BoardMongoRepository;
import com.example.demo.Model.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * Created by kwongiho on 2017. 11. 18..
 */
@RestController
public class BoardController {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private BoardMongoRepository boardMongoRepository;

    @Autowired
    private BoardRepository2 boardRepository;

    private static final String KEY = "board";


    @PostMapping(value="/v1/board")
    public BoardSkeleton newBoard(@RequestBody Board board) {
        logger.info("/v1/board : {}",board);
        return boardMongoRepository.save(board);
    }


    @Cacheable(value="mongoGetCache", key="#title")
    @GetMapping(value="/v1/board/{title}")
    public BoardSkeleton findByTitle(@PathVariable String title) {
        logger.info("/v1/board/{} ",title);
        return boardMongoRepository.findByTitle(title);
    }

    @PutMapping(value="/v1/board")
    public BoardSkeleton putBoard(@RequestBody BoardUpdate boardUpdate) {
        logger.info("/v1/board/{} ",boardUpdate);
        BoardSkeleton board = boardUpdate;
        board.setBody(boardUpdate.getNewBody());
        return boardMongoRepository.save(board);
    }

    @DeleteMapping(value="/v1/board")
    public BoardSkeleton deleteBoard(@RequestBody BoardDelete boardDelete) {
        logger.info("/v1/board/{} ",boardDelete);
        boardMongoRepository.delete(boardDelete);
        return boardMongoRepository.findByTitle(boardDelete.getTitle());
    }


    /*-----------------------below, for redis----------------------*/


    @PostMapping(value="/v2/board")
    public BoardSkeleton createNewBoard2(@RequestBody Board board) {
        logger.info("/v2/board : {}",board);
        return boardRepository.save(board);
    }

    @GetMapping(value="/v2/board/{id}")
    public BoardSkeleton searchBoard2(@PathVariable String id) {
        logger.info("/v2/board/{}",id);
        return boardRepository.findOne(id);
    }
    @GetMapping(value="/v2/board")
    public void searchAllBoard2() {
        logger.info("/v2/board/{}" , "All");
        Iterable<Board> iterable = boardRepository.findAll();

        //return null;
    }

    @PutMapping(value="/v2/board")
    public BoardSkeleton modifyingBoard2(@RequestBody BoardUpdate boardUpdate) {
        logger.info("/v2/board : {}",boardUpdate);
        BoardSkeleton board = boardUpdate;
        board.setBody(boardUpdate.getNewBody());
        return boardMongoRepository.save(board);
    }

    @DeleteMapping(value="/v2/board")
    public BoardSkeleton removeBoard2(@RequestBody BoardDelete boardDelete) {
        logger.info("/v2/board : {}",boardDelete);
        boardMongoRepository.delete(boardDelete);
        return boardMongoRepository.findByTitle(boardDelete.getTitle());
    }

    /*---------------------- follow tutorials ----------------------------*/

    @Autowired
    BoardRepositoryImpl boardRepositoryImpl;


    @PostMapping(value="/v3/board")
    public BoardSkeleton createNewBoard(@RequestBody Board board) {
        logger.info("/v3/board : {}",board);
        return boardRepositoryImpl.saveBoard(board);
    }

    @GetMapping(value="/v3/board/{id}")
    public BoardSkeleton searchBoard(@PathVariable String id) {
        logger.info("/v3/board/{}",id);
        return boardRepositoryImpl.findBoard(id);
    }
    @GetMapping(value="/v3/board")
    public Map<String,Board> searchAllBoard() {
        logger.info("/v3/board/{}","All");
//        List<Object> lists  = new ArrayList<>();
//        Map<Object,Object> maps=  boardRepositoryImpl.findAllBoard();
        //maps.
        return boardRepositoryImpl.findAllBoard();
    }

    @PutMapping(value="/v3/board")
    public BoardSkeleton modifyingBoard(@RequestBody BoardUpdate boardUpdate) {
        logger.info("/v3/board : {}",boardUpdate);
        Board board = new Board();
        board.setBody(boardUpdate.getNewBody());
        board.setTitle(boardUpdate.getTitle());
        board.setId(boardUpdate.getId());


        return boardRepositoryImpl.saveBoard(board);
    }

    @DeleteMapping(value="/v3/board")
    public void removeBoard(@RequestBody String id) {
        logger.info("/v3/board : {}",id);
        boardRepositoryImpl.deleteBoard(id);
    }

}