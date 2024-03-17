package com.runa.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * 员工实体类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Staff {
    private Integer id; //ID
    private String name; //姓名
    private Short gender; //性别 , 1 男, 2 女
    private Short job; //职位
    private LocalDateTime createTime; //创建时间
    private LocalDateTime updateTime; //修改时间
}