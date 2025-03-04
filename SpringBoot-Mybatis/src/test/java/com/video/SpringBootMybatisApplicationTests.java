package com.video;

import com.video.mapper.UserMapper;
import com.video.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class SpringBootMybatisApplicationTests {

    @Autowired
    private UserMapper userMapper;
    @Test
    public void mybatisTest() {
        // 1. 调用dao层的方法 获取每个员工信息的List数据
        // Mapper 接口是编写好了，那么我们如何查看接口接收过来的数据？
        // Mapper是个接口，但一旦加入@Mapper注解，程序运行就会自动生成该对象，并将该对象交给IOC容器管理
        // 此时容器当中已经有该接口的Bean对象
        List<User> list = userMapper.list();
        System.out.println(list);


    }

}
