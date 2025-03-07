package com.video.Service.impl;

import com.video.Service.EmpService;
import com.video.mapper.EmpMapper;
import com.video.pojo.PageBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        log.info("正在查询数据，在给 Mapper 层传递数据：{}");
        //  此时该层要提前处理好page，方便查询
        page = (page - 1) * pageSize;
        //  查到的数据要封装到 pageBean这个类里面
        PageBean pageBean = empMapper.pageList(page, pageSize);

        log.info("正在查询数据，Service 层正返回数据：{}", pageBean);
        return pageBean;
    }
}
