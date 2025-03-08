package com.video.mapper;

import com.video.pojo.Emp;
import com.video.pojo.PageBean;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 类名：
 *
 * @author Acer
 * 日期：2025/3/6
 * 时间：18:07
 */
@Mapper
public interface EmpMapper {
    @Select("select count(*) from emp")
    Integer count();

    @Select("select * from emp limit #{page}, #{pageSize}")  //  #{page}, #{pageSize}
    List<Emp> pageList(Integer page, Integer pageSize);
}
