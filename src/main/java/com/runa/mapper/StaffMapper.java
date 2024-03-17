package com.runa.mapper;

import com.runa.pojo.Staff;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 员工管理
 */
@Mapper
public interface StaffMapper {
    /**
     * 员工信息查询
     * @return
     */
    @Select("select * from staff")
    public List<Staff> list();

}