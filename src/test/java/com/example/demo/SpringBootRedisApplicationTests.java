package com.example.demo;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.*;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * Created by kwongiho on 2017. 11. 20..
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = StudyMybatisApplication.class)
public class SpringBootRedisApplicationTests {
//
//    @Resource(name = "redisTemplate")
//    private ValueOperations<String, String> valueOperations;
//
//    @Resource(name = "redisTemplate")
//    private ListOperations<String, String> listOperations;
//
//    @Resource(name = "redisTemplate")
//    private HashOperations<String, String, String> hashOperations;
//
//    @Resource(name = "redisTemplate")
//    private SetOperations<String, String> setOperations;
//
//    @Resource(name = "redisTemplate")
//    private ZSetOperations<String, String> zSetOperations;
//
//    @Before
//    public void init() {
//        //list put
//        // listOperations.rightPush("test:task", "자기소개");
//        listOperations.rightPush("test:task", "취미소개");
//        listOperations.rightPush("test:task", "소망소개");
//        listOperations.rightPush("test:task", "선임이직");
//        //hash put
//        hashOperations.put("test:user:kingbbode", "name", "권뽀대");
//        hashOperations.put("test:user:kingbbode", "age", "28");
//        //set put
//        setOperations.add("test:user:kingbbode:hobby", "개발");
//        setOperations.add("test:user:kingbbode:hobby", "잠");
//        setOperations.add("test:user:kingbbode:hobby", "옷 구경");
//        //zset
//        zSetOperations.add("test:user:kingbbode:wish", "배포한 것에 장애없길", 1);
//        zSetOperations.add("test:user:kingbbode:wish", "배포한거 아니여도 장애없길", 2);
//        zSetOperations.add("test:user:kingbbode:wish", "경력직 채용", 3);
//        zSetOperations.add("test:user:kingbbode:wish", "잘자기", 4);
//    }
}

