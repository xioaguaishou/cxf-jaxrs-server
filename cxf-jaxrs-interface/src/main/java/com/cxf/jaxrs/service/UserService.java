package com.cxf.jaxrs.service;

import com.cxf.jaxrs.pojo.User;
import com.cxf.jaxrs.vo.Result;

import javax.jws.WebService;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

// 声明是web service接口
@WebService
public interface UserService {

    @GET // 请求方式
    @Path("/{id}") // 请求路径
    @Produces({MediaType.APPLICATION_JSON})
    String get(@PathParam("id") Integer id);

    @POST
    @Consumes({MediaType.APPLICATION_JSON}) // 接收数据类型
    @Produces({MediaType.APPLICATION_JSON}) // 返回数据类型
    String save(String jsonObject); // json格式的字符串: {"id": 123, "name": "name", "age": 12}

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    String update(String jsonObject);

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    String delete(@PathParam("id") Integer id);

    @POST
    @Path("/list")
    @Consumes({MediaType.APPLICATION_JSON}) // 接收数据类型
    @Produces({MediaType.APPLICATION_JSON}) // 返回数据类型
    String queryList(String jsonObject);

}
