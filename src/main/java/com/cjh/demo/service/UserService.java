package com.cjh.demo.service;

import com.cjh.demo.model.User;
import org.springframework.stereotype.Repository;

/**
 * @author
 * @site
 * @company
 * @create 2020-04-11 13:40
 */
@Repository
public interface UserService {

    User login(User user);
}
