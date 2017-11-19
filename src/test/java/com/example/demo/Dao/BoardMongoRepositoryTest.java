package com.example.demo.Dao;

/**
 * Created by kwongiho on 2017. 11. 19..
 */

import com.example.demo.Model.Board;
import com.example.demo.Model.BoardCreate;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class BoardMongoRepositoryTest {
    @Autowired
    private BoardMongoRepository boardMongoRepository;


    @Before
    public void setUp() throws Exception {
        Board board1 = new BoardCreate();
        board1.setTitle("new1");
        board1.setBody("kwongiho");

        Board board2 = new BoardCreate();
        board2.setTitle("new2");
        board2.setBody("Hiii hello world.");

        assertNull(board1.getId());
        assertNull(board2.getId());

        this.boardMongoRepository.save(board1);
        this.boardMongoRepository.save(board2);

        assertNotNull(board1.getId());
        assertNotNull(board2.getId());
    }

    @Test
    public void testFetchData(){
        /*Test data retrieval*/
        Board board = boardMongoRepository.findByTitle("new1");
        assertNotNull(board);
        assertEquals("kwongiho", board.getBody());
        /*Get all products, list should only have two*/
        Iterable<Board> boards = boardMongoRepository.findAll();
        int count = 0;
        for(Board b : boards){
            count++;
        }
        assertEquals(count, 2);
    }

    @Test
    public void testDataUpdate(){
        /*Test update*/
        Board board = boardMongoRepository.findByTitle("new1");
        board.setBody("gihogio");
        boardMongoRepository.save(board);
        Board board2= boardMongoRepository.findByTitle("new1");
        assertNotNull(board2);
        assertEquals(board2.getBody(), "gihogiho");
    }

    @After
    public void tearDown() throws Exception {
        this.boardMongoRepository.deleteAll();
    }


}
