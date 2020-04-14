package com.cjh.demo.mapper;

import com.cjh.demo.model.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {
    int deleteByPrimaryKey(String uname);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(String uname);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    User login(User user);
}