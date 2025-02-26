package com.video.controller;

import com.video.pojo.Emp;
import com.video.pojo.Result;
import com.video.utils.XMLParserUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
        // 1. 加载并解析emp.xml 文件 把文件中的数据读取到对象当中
//        String file = "D:\\Java\\Bilibili_SpringBoot\\src\\main\\resources\\emp.xml";
        // 上面的路径如果文件被移动了 就会出现问题
        // 故通过类加载器来获取文件的路径
        String file = EmpController.class.getClassLoader().getResource("emp.xml").getFile();
        // parse方法第一个参数是要解析哪个文件 第二个参数是解析的文件的数据要往哪个类中封装
        List<Emp> empList = XMLParserUtils.parse(file, Emp.class);

        // 2. 对数据进行转换处理 处理 gender 和 job gender: 1 男 2 女 job: 1 老师 2 学生 3 工人
        // 我们需要先遍历集合 基于stream流来处理 拿到里面的每个元素
        empList.stream().forEach(emp -> {
            //首先处理第一个字段gender
            String gender = emp.getGender();
            if ("1".equals(gender)) {
                emp.setGender("男");
            } else {
                emp.setGender("女");
            }

            //处理第二个字段job
            String job = emp.getJob();
            if ("1".equals(job)) {
                emp.setJob("老师");
            } else if ("2".equals(job)) {
                emp.setJob("学生");
            } else {
                emp.setJob("工人");
            }
        });

        // 3. 向前端响应数据
        // 这里只需要把数据装到Result不就行了 那么return应该返回JSON数据
        return Result.success(empList);
    }
}
