package com.runa.service.impl;

import com.runa.mapper.DeptMapper;
import com.runa.pojo.Dept;
import com.runa.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {
    @Autowired
    private DeptMapper deptMapper;

    /**
     * 查询部门
     * @return
     */
    @Override
    public List<Dept> list() {

        return deptMapper.list();
    }

    /**
     * 根据ID删除部门
     *
     * @param id
     * @return
     */
    @Override
    public boolean delete(Integer id) {
        try {
            deptMapper.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }


    /**
     * 新增部门
     * @param dept
     */
    @Override
    public void add(Dept dept) {
        dept.setCreateTime(LocalDateTime.now());
        dept.setUpdateTime(LocalDateTime.now());

        deptMapper.insert(dept);
    }

    /**
     * 根据id查询部门
     * @param id
     * @return
     */
    @Override
    public Dept getById(Integer id) {
        return deptMapper.getById(id);
    }

    /**
     * 编辑部门
     * @param dept
     */
    @Override
    public void update(Dept dept) {
        dept.setUpdateTime(LocalDateTime.now());
        deptMapper.update(dept);

    }


}