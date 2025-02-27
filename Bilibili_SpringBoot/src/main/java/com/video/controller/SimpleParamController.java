package com.video.controller;

import com.video.pojo.Address;
import com.video.pojo.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@RestController
public class SimpleParamController {
    @RequestMapping("/simpleParam")
    public String simpleParm(String name, Integer age) {
        System.out.println(name + "：" + age);
        return "OK";
    }

    @RequestMapping("/simplePojo")
    public String simplePojo(User user) {
        System.out.println(user);
        System.out.println(user.getName() + ":" + user.getAge());
        return "OK";
    }

    @RequestMapping("/complexPojo")
    // 实体参数学的是一种思维，把属性封装到一个对象当中，
    // 把对象封装到一个对象当中，仅仅用一个对象接受前端传递过来的参数就够了
    public String complexPojo(User user) {
        System.out.println(user);
        return "OK2";
    }


    // 响应就是在前端看到的返回什么内容
    // 这个时候的响应不一定要求前端向后端传递数据，你传不传递后端都能给你返回数据
    // 响应数据---不止可以响应字符串，也可以响应对象，响应数组/集合
    // 响应字符串
    @RequestMapping("/hello")
    public String hello() {
        System.out.println("hello@@@@@1！！！");
        return "hello@@@@";
    }

    // 响应对象
    @RequestMapping("/getAddress")
    public Address getAddress() {
        Address address = new Address();
        address.setProvince("yun");
        address.setCity("nan");
        System.out.println(address);
        return address;
    }

    // 响应数组/集合
    @RequestMapping("/getList")
    public List<Object> getList() {
        List<Object> list = new ArrayList<>();

        //在集合中添加变量，对象
        User user = new User();
        user.setName("jia");
        user.setAge(22);

        Address address = new Address();
        address.setProvince("kun");
        address.setCity("ming");

        list.add(user);
        list.add(address);
        System.out.println(user);
        System.out.println(address);
        System.out.println(list);
        return list;
    }


    // 发现问题：上面三个接口返回的内容不统一，有的返回字符串，有点返回对象
    // 有的返回数组。
    // 采用一个统一的返回数据格式
    // 那么怎么让返回的数据统一格式呢？
    // 我们平常都会设置一个返回值类型，根据这个返回值类型返回数据
    // 上面之所以返回的数据格式各式各样，不就是因为返回值类型不一致嘛
    // 那么这个返回值类型可以定义为一个类，在这个类中定义统一的数据返回格式
    // 最后返回数据的时候就返回类的对象即可。
    // 包括你在返回的时候不也是返回对象吗 第二个返回Address这个类的对象
    // 第三个返回ArrayList这个类的对象。然后你只需要把数据装在对象的方法当中

}
