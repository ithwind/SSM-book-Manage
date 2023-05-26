package dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import pojo.User;

@Component
@Mapper
@Repository
public interface UserMapper {
    @Select("Select * from user where username = #{username}")
    User login(@Param(value = "username") String username);
    @Insert("insert into user (username, password, role) values (#{username}, #{password}, 'Normal')")
    int register(@Param(value = "username") String username,
                  @Param(value = "password") String password);
}
