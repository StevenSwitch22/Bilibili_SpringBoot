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

        log.info("正在查询数据，正在给 Service 层要数据");
        //   现在要查询部门的全部信息。调用 Service 层处理好的数据
        List<Dept> list = deptService.list();//  这里不应该是调用 Impl 的方法吗？为什么要调用接口的？


        //   这个时候从 Service 层获取的是数据，正好封装到 Result 里面
        log.info("正在查询数据，Service 层正在返回数据");
        System.out.println("list = " + list);
        return new Result(1, "success", list);
    }


    //   这是删除部门的执行方法
    @DeleteMapping("/depts/{id}")
    public Result delete(@PathVariable Integer id) {
        //   此时把前端获取到的 id 传给 Service 层
        log.info("此时在接收前端传给我的id：{}", id);
        deptService.delete(id);
        log.info("删除成功！！！");
        return new Result(1, "删除成功", null);
    }


    //   该方法处理新增部门
    @PostMapping("/depts")
    //   注意这里接收的请求参数不是简单的字符串，而是一个JSON格式的数据
    //   那么接收JSON格式的数据就用实体类来接收再加个注解  -->  请求响应
    public Result insert(@RequestBody Dept dept) {
        //   接受前端要添加哪个部门

        //   把拿过来的名字要传给 Service 层
        log.info("现在正在添加数据，在给 Service 传递name：{}", dept.getName());
        deptService.insert(dept);

        //   让过程更加清晰可见，输入日志
        log.info("现在数据正在从 Service 层传回来：");
        return new Result(1, "添加成功", null);
    }
}
