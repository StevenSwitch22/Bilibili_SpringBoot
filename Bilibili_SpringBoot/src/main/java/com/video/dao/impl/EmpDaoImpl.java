package com.video.dao.impl;

import com.video.controller.EmpController;
import com.video.dao.EmpDao;
import com.video.pojo.Emp;
import com.video.utils.XMLParserUtils;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 类名：
 *
 * @author Acer
 * 日期：2025/2/27
 * 时间：16:35
 */
@Component
public class EmpDaoImpl implements EmpDao {
    @Override
    public List<Emp> listEmp() {
        // 1. 加载并解析emp.xml 文件 把文件中的数据读取到对象当中
//        String file = "D:\\Java\\Bilibili_SpringBoot\\src\\main\\resources\\emp.xml";
        // 上面的路径如果文件被移动了 就会出现问题
        // 故通过类加载器来获取文件的路径
        String file = EmpController.class.getClassLoader().getResource("emp.xml").getFile();
        // parse方法第一个参数是要解析哪个文件 第二个参数是解析的文件的数据要往哪个类中封装
        List<Emp> empList = XMLParserUtils.parse(file, Emp.class);
        return empList;
    }
}
