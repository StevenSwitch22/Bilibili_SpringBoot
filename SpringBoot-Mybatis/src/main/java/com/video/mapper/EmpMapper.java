package com.video.mapper;

import com.video.pojo.Emp;
import org.apache.ibatis.annotations.*;

import java.time.LocalDate;
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

    // 新增员工message
    /*@Insert("insert into emp (username, name, gender, image, job, entry_time, dept_id, create_time, update_time) " +
            "values ('zeng@122.com', 'zeng', 1, 'zen1.jpg', 3, '2003-03-23', 2, now(), now());")*/
    // 发现 语句当中的数据都是写死的，但实际中应该是接收用户输入的数据，再把这份数据传递到语句中然后执行这条语句
    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("insert into emp (username, name, gender, image, job, entry_time, dept_id, create_time, update_time)" +
            "values (#{username}, #{name}, #{gender}, #{image}, #{job}, #{entryTime}, #{deptId}, #{createTime}, #{updateTime})")
    public void add(Emp emp);  // 接收的参数很多，故采取“请求响应”那一节的内容采取对象的方式接收数据

    @Delete("delete from emp where username = #{username}")
    public int delete(String username);

    @Update("update emp set username = #{username}, name = #{name}, gender = #{gender}, job = #{job}," +
            "entry_time = #{entryTime}, dept_id = #{deptId}, update_time = #{updateTime} where id = #{id}")
    public void update(Emp emp);

//    @Select("select * from emp where id = #{id}")
//    public Emp select(Integer id);

    //  给字段起别名，让其自动封装
//    @Select("select id, username, password, name, gender, image, job, " +
//            "entry_time entryTime, dept_id deptId, create_time createTime, update_time updateTime from emp where id = #{id}")
//    public Emp select(Integer id);
    //   此时已经配置驼峰
    @Select("select * from emp where id = #{id}")
    public Emp select(Integer id);

    //   用户提供了多个条件查询
    /*@Select("select * from emp where name like '%${name}%' and gender = #{gender} and " +
            "entry_time between #{begin} and #{end} order by update_time desc ")
    public List<Emp> selectMul(String name, Short gender, LocalDate begin, LocalDate end) ;*/

    /*@Select("select * from emp where name like concat('%', #{name}, '%') and gender = #{gender} and " +
            "entry_time between #{begin} and #{end} order by update_time desc ")*/
    public List<Emp> selectMul(String name, Short gender, LocalDate begin, LocalDate end) ;
}

// 为什么这里的emp对象没有加括号接收参数呢？不应该是emp（String username, String name）这样的方式吗？
