package com.example.demo.Model;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

/**
 * Created by kwongiho on 2017. 11. 20..
 */

public interface BoardRepository2 extends CrudRepository<Board,String> {
}
