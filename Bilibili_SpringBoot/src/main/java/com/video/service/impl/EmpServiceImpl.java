package com.video.service.impl;

import com.video.dao.EmpDao;
import com.video.dao.impl.EmpDaoImpl;
import com.video.pojo.Emp;
import com.video.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 类名：
 *
 * @author Acer
 * 日期：2025/2/27
 * 时间：16:43
 */
@Component
public class EmpServiceImpl implements EmpService {
    @Autowired
    private EmpDao empDao;
    @Override
    public List<Emp> listEmp() {
        // 1. 调用dao层的方法 获取每个员工信息的List数据
        List<Emp> empList = empDao.listEmp();
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
        return empList;
    }
}
