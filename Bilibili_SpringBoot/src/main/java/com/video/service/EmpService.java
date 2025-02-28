package com.video.service;

import com.video.pojo.Emp;

import java.util.List;

/**
 * 类名：
 *
 * @author Acer
 * 日期：2025/2/27
 * 时间：16:41
 */
public interface EmpService {
    // 获取每个员工信息后，对数据进行数据处理
    public List<Emp> listEmp();
}
