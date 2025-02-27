package com.video.dao;

import com.video.pojo.Emp;

import java.util.List;

/**
 * 类名：
 *
 * @author Acer
 * 日期：2025/2/27
 * 时间：16:10
 */
public interface EmpDao {
    // 在接口中定义一个方法，获取员工信息
    // IDEA 快捷键：alt + 箭头键 切换打开的文件
    // Copilot 快捷键：ctrl + 箭头键 同意部分代码
    public List<Emp> listEmp();
}
