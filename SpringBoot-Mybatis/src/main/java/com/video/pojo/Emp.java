package com.video.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * 类名：
 *
 * @author Acer
 * 日期：2025/3/4
 * 时间：22:09
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Emp {
    private Integer id;
    private String username;
    private String password;
    private String name;
    private Short gender;
    private String image;
    private Short job;
    private LocalDate entryTime;
    private Integer deptId;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
}
