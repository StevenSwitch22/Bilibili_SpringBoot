package com.video.controller;

import com.video.Service.DeptService;
import com.video.pojo.Dept;
import com.video.pojo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 类名：
 *
 * @author Acer
 * 日期：2025/3/6
 * 时间：18:06
 */
@Slf4j
@RestController
public class DeptController {

    /**
     * 现在想象接收前端访问某个地址，你要给前端响应数据
     */
    @Autowired
    private DeptService deptService;


    @GetMapping("/depts")
    public Result message() {
//        System.out.println(Result.success());
        ///    尝试使用日志的方式让结果显示在控制台上
        log.info("返回给前端的数据：");

        //   现在要查询部门的全部信息。调用 Service 层处理好的数据
        List<Dept> list = deptService.list();//  这里不应该是调用 Impl 的方法吗？为什么要调用接口的？


        //   这个时候从 Service 层获取的是数据，正好封装到 Result 里面
        log.info("这里是 Service 层返回给 Controller 层的数据：");
        System.out.println("list = " + list);
        return new Result(1, "success", list);
    }


    //   这是删除部门的执行方法
    @DeleteMapping("/depts/{id}")
    public Result delete(@PathVariable Integer id) {
        //   此时把前端获取到的 id 传给 Service 层
        deptService.delete(id);
        return Result.success();
    }


    //   该方法处理新增部门
    @PostMapping("/depts")
    public Result insert(String name) {
        //   接受前端要添加哪个部门

        //   把拿过来的名字要传给 Service 层
        deptService.insert(name);

        //   让过程更加清晰可见，输入日志
        log.info("此时正在Controller --> Service：name：", name);
        return new Result(1, "添加成功", null);
    }
}
