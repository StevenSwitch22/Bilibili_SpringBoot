package com.video.Service;

import com.video.pojo.PageBean;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

/**
 * 类名：
 *
 * @author Acer
 * 日期：2025/3/6
 * 时间：18:07
 */
@Service
public interface EmpService {
    PageBean pageList(String name, Integer gender, LocalDate begin, LocalDate end, Integer page, Integer pageSize);
}
