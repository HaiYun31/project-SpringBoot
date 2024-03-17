package com.runa.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.runa.mapper.StaffMapper;
import com.runa.pojo.Staff;
import com.runa.pojo.PageBean;
import com.runa.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StaffServiceImpl implements StaffService {

    @Autowired
    private StaffMapper staffMapper;
    /**
     * 分页查询
     * @param page
     * @param pageSize
     * @return
     */
    @Override
    public PageBean page(Integer page, Integer pageSize) {
        // 1 设置分页参数
        PageHelper.startPage(page, pageSize);

        // 2 查询
        List<Staff> staffList = staffMapper.list();
        Page<Staff> p = (Page<Staff>) staffList;

        // 3 封装PangeBean对象
        PageBean pageBean = new PageBean(p.getTotal(),p.getResult());
        return pageBean;
    }
}