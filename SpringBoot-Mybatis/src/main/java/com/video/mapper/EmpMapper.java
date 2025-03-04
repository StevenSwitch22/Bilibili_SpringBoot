package com.video.mapper;

import com.video.pojo.Emp;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 类名：
 *
 * @author Acer
 * 日期：2025/3/4
 * 时间：22:17
 */
@Mapper
public interface EmpMapper {

    public List<Emp> list();
}
