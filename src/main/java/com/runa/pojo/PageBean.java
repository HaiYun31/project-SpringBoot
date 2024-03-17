package com.runa.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 分页查询的结果类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageBean {

    //  这里的定义名称要与接口文档一致
    private long total; // 总记录数
    private List rows; //数据列表

}