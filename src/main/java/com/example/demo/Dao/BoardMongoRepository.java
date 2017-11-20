package com.example.demo.Dao;

import com.example.demo.Model.BoardSkeleton;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Service;

/**
 * Created by kwongiho on 2017. 11. 18..
 */
@Service
@EnableCaching
public interface BoardMongoRepository extends MongoRepository<BoardSkeleton,String>{

    BoardSkeleton findByTitle(String title);

}
