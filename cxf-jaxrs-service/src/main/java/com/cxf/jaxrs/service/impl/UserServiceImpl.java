package com.cxf.jaxrs.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.cxf.jaxrs.pojo.User;
import com.cxf.jaxrs.service.UserService;
import com.cxf.jaxrs.vo.Result;
import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.List;

public class UserServiceImpl implements UserService {

    @Override
    public String get(Integer id) {
        System.out.println("get id..." + id);
        Result<User> result = new Result<>(HttpStatus.OK, this.getUser());
        // 将返回对象转成json string
        return JSON.toJSONString(result);
    }

    @Override
    public String save(String jsonObject) {
        // json格式字符串转对象
        User user = JSONObject.parseObject(jsonObject, User.class);
        System.out.println("save user..." + user);
        Result<User> result = new Result<>(HttpStatus.OK, this.getUser());

        return JSON.toJSONString(result);
    }

    @Override
    public String update(String jsonObject) {
        User user = JSONObject.parseObject(jsonObject, User.class);
        System.out.println("update User..." + user);
        Result<User> result = new Result<>(HttpStatus.OK, this.getUser());
        return JSON.toJSONString(result);
    }

    @Override
    public String delete(Integer id) {
        System.out.println("delete id..." + id);
        Result<User> result = new Result<>(HttpStatus.BAD_REQUEST, "Bad Request");
        return JSON.toJSONString(result);
    }

    @Override
    public String queryList(String jsonObject) {
        User user = JSONObject.parseObject(jsonObject, User.class);
        System.out.println("queryList User..." + user);
        List<User> users = new ArrayList<>();
        users.add(this.getUser());
        users.add(this.getUser());
        Result<User> result = new Result<>(HttpStatus.OK, users);
        System.out.println(JSON.toJSONString(result));
        return JSON.toJSONString(result);
    }

    // 模拟数据库返回数据
    private User getUser() {
        User user = new User();
        user.setId(999);
        user.setAge(12);
        user.setName("响应数据");
        return user;
    }
}
