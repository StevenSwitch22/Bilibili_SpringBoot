package com.video.Service.impl;

import com.video.Service.DeptService;
import com.video.mapper.DeptMapper;
import com.video.pojo.Dept;
import com.video.pojo.Result;
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
public class DeptServiceImpl implements DeptService {
    @Autowired
    private DeptMapper deptMapper;
    @Override
    public List<Dept> list() {
        //   Service 层肯定要向 Mapper 层要数据
        List<Dept> list = deptMapper.list();
        log.info("这里是 Mapper 层返回给 Service 层的数据：");
        System.out.println("Service list = " + list);
        return list;
    }

    @Override
    public void delete(Integer id) {
        //   Service 层接收到ID后，再把 id 传给 Mapper 层
        deptMapper.delete(id);
    }

    @Override
    public void insert(String name) {
        //  Service 层把拿到的传给 Mapper 层
        deptMapper.insert(name);

        log.info("此时正在Service --> Mapper：name：", name);
        //  此时也不用考虑返回给 Controller 层什么
    }
}
