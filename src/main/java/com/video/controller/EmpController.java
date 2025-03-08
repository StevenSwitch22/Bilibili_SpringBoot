package com.video.controller;

import com.video.Service.EmpService;
import com.video.pojo.PageBean;
import com.video.pojo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

/**
 * 类名：
 *
 * @author Acer
 * 日期：2025/3/6
 * 时间：18:06
 */
@RestController
@Slf4j
public class EmpController {
    @Autowired
    private EmpService empService;


    //   这里是员工列表查询
    @GetMapping("/emps")
    public Result pageList(@RequestParam(defaultValue = "1") Integer page,
                           @RequestParam(defaultValue = "10") Integer pageSize) {
        log.info("正在分页查询数据，在给 Service 层传递数据：{}, {}", page, pageSize);
        PageBean pageBean = empService.pageList(page, pageSize);

        log.info("正在分页查询数据，Controller 层接收到数据：{}", pageBean);
        return new Result(1, "查询成功", pageBean);
    }
}
