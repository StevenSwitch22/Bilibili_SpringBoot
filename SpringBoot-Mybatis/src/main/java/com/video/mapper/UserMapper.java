package com.video.mapper;

import com.video.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 类名：
 *
 * @author Acer
 * 日期：2025/3/2
 * 时间：17:55
 */
@Mapper  // 运行时，会自动生成该接口的实现类对象（），并将该对象交给IOC容器管理
public interface UserMapper {
    @Select("select * from user;")
    // 考虑返回值类型为什么是List<User>，而不是其他类型
    public List<User> list();
}

// 我想看看数组存储对象的结果和集合存储对象的结果有什么不同，两者长什么样子？
// 长什么样子好像也就是[] {}的区别，其中的都是 User{} 这样的内容

// 考虑：为什么要使用接口的方式？我们现在在干嘛？我们现在正在 Dao 层编写文件是为了调用数据库的数据，
// 那么使用接口就是因为以后我们调用数据的方式有很多，可以是数据库，可以是一个文件，也可以是别人
// 提供的接口，所以我们要使用接口的方式来接收数据
// 那么你使用接口，按道理来说，你应该实现接口，且在这个实现类里面写具体的调用数据的方法
// 这个具体方法可以是调用文件，可以是 SQL 语句调用数据库
// 那么为什么在 Mybatis 里面不用实现类呢？因为 Mybatis 会自动帮我们生成实现类，
// 我们只需要 编写 SQL 语句就行了
// 然后就是在接口中定义方法的问题。要定义什么样的方法？
// 定义方法其实就是考虑要接收什么样的数据？
