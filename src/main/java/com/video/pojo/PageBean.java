package com.video.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

/**
 * 类名：
 *
 * @author Acer
 * 日期：2025/3/7
 * 时间：21:53
 */
@Data
@AllArgsConstructor
public class PageBean {
    private Integer total;
    private List<Emp> rows;
}
