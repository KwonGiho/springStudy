package com.example.demo.Model;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

/**
 * Created by kwongiho on 2017. 11. 20..
 */
@Service
public interface BoardRepository extends CrudRepository<Board,String> {
}
