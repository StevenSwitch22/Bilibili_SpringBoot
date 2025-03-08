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
    public PageBean pageList(Integer page, Integer pageSize) {
        //  使用 pageHelper 第一步，传入数据
        PageHelper.startPage(page, pageSize);

        //  此时该层要提前处理好page，方便查询
//        page = (page - 1) * pageSize;
        log.info("正在分页查询数据，在给 Mapper 层传递数据：{}：{}", page, pageSize);
        //  查到的数据要封装到 pageBean这个类里面
//        Integer count = empMapper.count();
        List<Emp> empList = empMapper.pageList();

        Page<Emp> p = (Page<Emp>) empList;

        //  把接收到的Mapper 层中的数据封装到 PageBean 中
        PageBean pageBean = new PageBean(p.getTotal(), p.getResult());

        log.info("正在分页查询数据，Service 层正返回数据：{}", pageBean);
        return pageBean;
    }
}
