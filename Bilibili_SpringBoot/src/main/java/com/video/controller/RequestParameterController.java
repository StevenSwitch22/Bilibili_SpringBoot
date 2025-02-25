package com.video.controller;

import com.video.pojo.User;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.JstlUtils;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

/**
 * 类名：
 *
 * @author Acer
 * 日期：2025/2/16
 * 时间：22:09
 */

// 测试在地址栏输入地址后如何在后端接受参数
@RestController
public class RequestParameterController {
//    @RequestMapping("/simpleParam")
//    public String simpleParam(HttpServletRequest request) {
//        // 获取请求参数
//        String name = request.getParameter("name");  // Alt + Enter achieve!!!
//        String ageStr = request.getParameter("age");
//
//        int age = Integer.parseInt(ageStr);
//        System.out.println(name + ":" + age);
//        return "OK";
//    }

    // SpringBoot method
//    @RequestMapping("/simpleParam")
//    public String simpleParam(String name, Integer age) {
//        // 获取请求参数
//        System.out.println(name + ":" + age);
//        return "OK";
//    }

    //  Request parameters are inconsistent with Method parameters
    @RequestMapping("/simpleParam")
    public String simpleParam(@RequestParam(value = "name", required = false) String userName, Integer age) {
        // 获取请求参数
        System.out.println(userName + ":" + age);
        return "OK";
    }

    // A variable with mutiple values, using Array
    @RequestMapping("/arrayParam")
    // Array name must match the request Parameter: hobby --> hobby
    public String arrayParam(String[] hobby) {
//        System.out.println(hobby[0] + ":" + hobby[1]);
        System.out.println(Arrays.toString(hobby));
        return "OK";
    }

    // A variable with mutiple values, using List
    @RequestMapping("/listParam")
    // Array name must match the request Parameter: hobby --> hobby
    public String listParam(@RequestParam List<String> hobby) {
        System.out.println("List hobby: " + hobby);
        return "OK";
    }

    @RequestMapping("/dateParam")
    public String dateParam(@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime updateTime) {
        System.out.println(updateTime);
        return "OK";
    }

    @RequestMapping("/jsonParam")
    public String jsonParam(@RequestBody User user) {
        System.out.println(user);
        return "OK";
    }

    @RequestMapping("/path/{i}/{status}")
    public String pathParam(@PathVariable Integer i, @PathVariable String status) {
        System.out.println("i = " + i + " status = " + status);
        return "OK";
    }
}
