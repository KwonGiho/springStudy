package com.example.demo;

import com.example.demo.Model.Board;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericToStringSerializer;

/**
 * Created by kwongiho on 2017. 11. 20..
 */
@Configuration
public class RedisConfig {

    @Value("${spring.redis.host}")
    private String host;

    @Value("${spring.redis.port}")
    private int port;
    @Bean
    JedisConnectionFactory jedisConnectionFactory() {
        JedisConnectionFactory jedisConFactory = new JedisConnectionFactory();
        jedisConFactory.setHostName(host);
        jedisConFactory.setPort(port);
        jedisConFactory.setUsePool(true);

        return jedisConFactory;
    }

    @Bean
    public RedisTemplate<String, Board> redisTemplate() {
        final RedisTemplate<String, Board> template = new RedisTemplate<String, Board>();
        template.setConnectionFactory(jedisConnectionFactory());
        template.setValueSerializer(new GenericToStringSerializer<Board>(Board.class));
        return template;
    }

}
