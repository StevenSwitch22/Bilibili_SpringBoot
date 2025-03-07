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
        log.info("正在查询数据，正在给 Mapper 层要数据");
        List<Dept> list = deptMapper.list();

        log.info("正在查询数据，Mapper 层正在返回数据");
        System.out.println("Service list = " + list);
        return list;
    }

    @Override
    public void delete(Integer id) {
        //   Service 层接收到ID后，再把 id 传给 Mapper 层
        deptMapper.delete(id);
    }

    @Override
    public void insert(Dept dept) {
        //  这里接收 Control 层的数据，传给 Mapper 层
        log.info("现在正在添加数据，正在给 Mapper 层传递name：{}", dept);
        deptMapper.insert(dept);
        log.info("现在数据正在从 Mapper 层传回来：");
    }

    @Override
    public void update(Dept dept) {
        //   这里接收 上层的数据
        log.info("正在修改数据，在给 Mapper 层传递数据：{}", dept);
        deptMapper.update(dept);

        log.info("正在修改数据，Service 层正返回数据：{}", dept);
    }

    @Override
    public Dept show(Integer id) {
        //  接收上层传递过来的数据
        log.info("正在回显数据，在给 Mapper 层传递数据：{}", id);
        Dept show = deptMapper.show(id);

        log.info("正在回显数据，Service 层正返回数据：{}", show);
        return show;
    }
}
