package com.video.controller;

import com.video.pojo.Address;
import com.video.pojo.Result;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * 类名：
 *
 * @author Acer
 * 日期：2025/2/19
 * 时间：21:12
 */
@RestController
public class ResponseParameterController {
    @RequestMapping("/hello")
    public Result Hello() {
//        return new Result(1, "successs", "Hello.....");
        return Result.success("Hello.....");
    }

    //不再返回“OK”这样一个字符串，而是返回一个对象
    @RequestMapping("/getAddress")
    public Result getAddress() {
        Address address = new Address();
        address.setProvince("bei");
        address.setCity(("tian"));
        System.out.println(address);
//        return address;
        return Result.success(address);
    }

    //不再返回“OK”这样一个字符串，而是返回一个集合
    @RequestMapping("/getList")
    public Result getList() {
        List<Address> list = new ArrayList<>();

        //变量多用对象封装，对象多用什么封装？用集合封装，既可以封装变量，也可以封装对象
        Address address1 = new Address();
        address1.setCity("wu");
        address1.setProvince("han");

        Address address2 = new Address();
        address2.setProvince("nan");
        address2.setCity("jing");

        Address address3 = new Address();
        address3.setCity("xia");
        address3.setProvince("men");

        list.add(address1);
        list.add(address2);
        list.add(address3);
        System.out.println(list);
        return Result.success(list);
    }
}
