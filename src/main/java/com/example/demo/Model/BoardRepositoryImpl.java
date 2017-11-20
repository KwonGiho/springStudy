package com.example.demo.Model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Map;

/**
 * Created by kwongiho on 2017. 11. 21..
 */
@Component
@Repository
public class BoardRepositoryImpl implements BoardRepository{

    private static final String KEY = "board";

    private RedisTemplate<String,Board> redisTemplate;
    private HashOperations hashOps;

    @Autowired
    public BoardRepositoryImpl(RedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @PostConstruct
    private void init() {
        hashOps = redisTemplate.opsForHash();
    }


    @Override
    public Board saveBoard(Board board) {
        hashOps.put(KEY,board.getId(),board);
        return findBoard(board.getId());
    }

    @Override
    public Board updateBoard(Board board) {
        hashOps.put(KEY,board.getId(),board);
        return findBoard(board.getId());
    }

    @Override
    public Board findBoard(String id) {
        return (Board)hashOps.get(KEY,id);
    }

    @Override
    public Map<String, Board> findAllBoard() {
        return hashOps.entries(KEY);
    }

    @Override
    public void deleteBoard(String id) {
        hashOps.delete(KEY,id);
    }
}
