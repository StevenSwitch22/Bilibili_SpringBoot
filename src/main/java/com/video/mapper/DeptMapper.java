package com.video.mapper;

import com.video.pojo.Dept;
import com.video.pojo.Result;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * 类名：
 *
 * @author Acer
 * 日期：2025/3/6
 * 时间：18:07
 */
@Mapper
public interface DeptMapper {
    @Select("select * from dept")
    List<Dept> list();   //   这里返回的是多条记录，返回值应为 List

    @Delete("delete from dept where id = #{id}")
    //   Mapper 层接收到 id 后，执行语句，删除该 id 的记录即可，不用再向前端返回任何数据，不像查询一样
    void delete(Integer id);

    @Insert("insert into dept(name, create_time, update_time) values (#{name}, now(), now())")
    void insert(Dept dept);

    @Update("update dept set name = #{name} where id = #{id}")
    void update(Dept dept);

    @Select("select id, name, create_time, update_time from dept where id = #{id}")
    Dept show(Integer id);
}
