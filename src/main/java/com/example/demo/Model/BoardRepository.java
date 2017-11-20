package com.example.demo.Model;

import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * Created by kwongiho on 2017. 11. 21..
 */

public interface BoardRepository {
    Board saveBoard(Board board);

    Board updateBoard(Board board);

    Board findBoard(String id);

    Map<String,Board> findAllBoard();

    void deleteBoard(String id);

}
