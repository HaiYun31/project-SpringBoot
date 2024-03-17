package com.runa.service;

import com.runa.pojo.PageBean;

public interface StaffService {
    /**
     * 分页和查询
     * @param page
     * @param pageSize
     * @return
     */
    PageBean page(Integer page, Integer pageSize);

}