package com.video;

import com.video.mapper.EmpMapper;
import com.video.mapper.UserMapper;
import com.video.pojo.Emp;
import com.video.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalDateTime;
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

    @Autowired
    private EmpMapper empMapper;

    @Test
    void delete(){
        int delete = empMapper.delete("zeng@122.cocm");
        System.out.println("delete = " + delete);
    }
    @Test
    public void insertTest() {

        //  以下为用户填写传入到后端的数据
        Emp emp = new Emp();
        emp.setUsername("zeng@122.cocm");
        emp.setName("zeng");
        emp.setImage("zen1.jpg");
        emp.setGender((short) 1);
        emp.setJob((short)3);
        emp.setEntryTime(LocalDate.of(2003, 3, 23));
        emp.setCreateTime(LocalDateTime.now());
        emp.setUpdateTime(LocalDateTime.now());
        emp.setDeptId(2);

        //  后端接收到数据后，开始调用Mapper接口的方法，将数据传入到数据库中
        empMapper.add(emp);
        System.out.println("password = "+ emp.getPassword());
        System.out.println("gender = " + emp.getGender());
        System.out.println("id = " + emp.getId());
    }

    @Test
    void updateTest() {
        //  此时表单上已经显示出了用户之前填写的数据，用户现在开始修改数据
        ///  那么我们用对象来接收用户输入的数据
        Emp emp = new Emp();
        emp.setId(11);   //  代表更新ID为11的数据
        emp.setUsername("xin!122.com");
        emp.setName("xin");
        emp.setGender((short) 0);
        emp.setImage("xin1.jpg");
        emp.setJob((short) 2);
        emp.setEntryTime(LocalDate.of(2013, 3, 23));
        emp.setUpdateTime(LocalDateTime.now());
        emp.setDeptId(3);

        //  开始执行将用户的数据更新到数据库中
        empMapper.update(emp);
        System.out.println("update emp = " + emp);
    }

    @Test
    void selectTest() {
        //  现在这个地方是前端，用户发起请求，我们要查询ID为23的用户的数据
        Emp select = empMapper.select(11);
        System.out.println(select);
    }

    @Test
    void Select(){
//        List<Emp> select = empMapper.selectMul("李", (short) 1, LocalDate.of(2003, 11, 12), LocalDate.of(2033, 11, 12));
//        List<Emp> select1 = empMapper.selectMul(null, (short) 1, null, null);
        List<Emp> select2 = empMapper.selectMul("x", null, null, null);
        System.out.println("select = " + select2);
    }

}
