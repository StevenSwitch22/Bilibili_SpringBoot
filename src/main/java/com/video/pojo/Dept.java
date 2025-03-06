package com.video.pojo;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * 类名：
 *
 * @author Acer
 * 日期：2025/3/6
 * 时间：20:19
 */
@Data
public class Dept {
    private Integer id;
    private String name;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
}
