package com.cjh.demo.controller;

import com.cjh.demo.model.User;
import com.cjh.demo.service.UserService;
import com.cjh.demo.util.CodeMsg;
import com.cjh.demo.util.ResultData;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author
 * @site
 * @company
 * @create 2020-04-11 14:38
 */
@Controller
@RequestMapping("/User")
@Api(value = "UserController",description = "用户登录")
public class UserController {

    @Autowired
    private UserService userService;

    @ResponseBody
    @ApiOperation(value = "用户登录",notes ="用户登录" )
    @ApiResponse(code = 200,message = "用户登录成功")
    @PostMapping("/login")
    public ResultData<User> login(User user){

        User login = userService.login(user);
        if(login != null){
            //登录成功
            return new ResultData("登录成功",login);
        }
        else{
            return  new ResultData(CodeMsg.LOGIN_ERR,login);
        }
    }

}
