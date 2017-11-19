package com.example.demo.Dao;

import com.example.demo.Model.user.UserRegister;
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

    @Delete("delete from user where id=#{id} and password=#{password}")
    int delete(@Param("id") String id, @Param("password") String password);

}
