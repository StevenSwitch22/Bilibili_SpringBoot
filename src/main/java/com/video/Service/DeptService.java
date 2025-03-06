package com.video.Service;

import com.video.pojo.Dept;
import com.video.pojo.Result;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 类名：
 *
 * @author Acer
 * 日期：2025/3/6
 * 时间：18:07
 */
@Service
public interface DeptService {
    List<Dept> list();  //  这里肯定是把返回值类型定义为 Result，

    void delete(Integer id);
}
