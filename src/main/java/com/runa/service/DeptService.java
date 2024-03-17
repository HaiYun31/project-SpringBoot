package com.runa.service;

import com.runa.pojo.Dept;

import java.util.List;

public interface DeptService {
    /**
     * 查询全部  部门数据
     * @return
     */
    List<Dept> list();

    /**
     * 依据id删除部门
     *
     * @param id
     * @return
     */
    boolean delete(Integer id);

    /**
     * 新增部门
     * @param dept
     */
    void add(Dept dept);

    /**
     * 根据id查询部门
     * @param id
     * @return
     */
    Dept getById(Integer id);

    /**
     * 编辑用户
     */
    void update(Dept dept);


}