package com.video.controller;

import com.video.pojo.Result;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 类名：
 *
 * @author Acer
 * 日期：2025/2/26
 * 时间：14:20
 */
@RestController
// Controller方法处于前端和后端的入口处和出口处
// 用于接收前端请求 向前端返回后端数据
public class EmpController {

    // 这里定义Result类型的方法 目的在于返回一个统一的结果给前端
    @RequestMapping("/listEmp")
    // 前端通过地址访问到后端 后端通过这个地址给前端返回数据
    public Result list() {
        Result result = new Result();
        return result;
    }
}
