package com.example.demo.Mapper;

import com.example.demo.Model.UserRegister;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Service;

/**
 * Created by kwongiho on 2017. 11. 18..
 */
@Mapper
@Service
public interface UserMapper {
    @Select("Select * from user where id=#{id}")
    UserRegister findById(@Param("id") String id);

    @Insert("insert into user values(#{id},#{password})")
    int insert(@Param("id") String id,@Param("password") String password);

    @Update("update user set password=#{afterPassword} where id=#{id} and password=#{password}")
    int update(@Param("id") String id,@Param("password") String password, @Param("afterPassword") String afterPassword);

}
