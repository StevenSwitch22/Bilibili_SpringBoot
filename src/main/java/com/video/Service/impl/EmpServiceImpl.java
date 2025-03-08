package com.video.Service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.video.Service.EmpService;
import com.video.mapper.EmpMapper;
import com.video.pojo.Emp;
import com.video.pojo.PageBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

/**
 * 类名：
 *
 * @author Acer
 * 日期：2025/3/6
 * 时间：18:08
 */
@Slf4j
@Service
public class EmpServiceImpl implements EmpService {

    @Autowired
    private EmpMapper empMapper;
    @Override
    public PageBean pageList(String name, Integer gender, LocalDate begin, LocalDate end, Integer page, Integer pageSize) {
        //  使用 pageHelper 第一步，传入数据
        PageHelper.startPage(page, pageSize);

        //  此时该层要提前处理好page，方便查询
//        page = (page - 1) * pageSize;
        log.info("正在分页查询数据，在给 Mapper 层传递数据：{}：{}", page, pageSize);
        //  查到的数据要封装到 pageBean这个类里面
//        Integer count = empMapper.count();

        //   我猜测要执行两步查询，先查询“指定条件”的结果；再根据得到的结果分页查询
        //   OK，立马开干。先执行“指定条件”的查询结果

        //  OK， 此时已经得到带有条件的查询结果。那么就根据这个结果再执行分页查询
        List<Emp> empList = empMapper.pageList(name, gender, begin, end);

        Page<Emp> p = (Page<Emp>) empList;

        //  把接收到的Mapper 层中的数据封装到 PageBean 中
        PageBean pageBean = new PageBean(p.getTotal(), p.getResult());

        log.info("正在分页查询数据，Service 层正返回数据：{}", pageBean);
        return pageBean;
    }
}
