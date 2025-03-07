package com.video.Service;

import com.video.pojo.PageBean;
import org.springframework.stereotype.Service;

/**
 * 类名：
 *
 * @author Acer
 * 日期：2025/3/6
 * 时间：18:07
 */
@Service
public interface EmpService {
    PageBean pageList(Integer page, Integer pageSize);
}
