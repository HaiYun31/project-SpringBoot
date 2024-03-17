package com.runa.controller;

import com.runa.pojo.PageBean;
import com.runa.pojo.Result;

import com.runa.service.StaffService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 员工管理Controller
 */
@Slf4j
@RequestMapping("/staff")
@RestController
public class StaffController {

    @Autowired
    private StaffService staffService;

    @GetMapping
    public Result page(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer pageSize) {
        try {
            log.info("分页和查询，参数：开始页 {}, 每页显示：{}", page, pageSize);
            // 调用Service方法进行查询
            PageBean pageBean = staffService.page(page, pageSize);
            return Result.success(pageBean);
        } catch (Exception e) {
            log.error("分页查询出错：{}", e.getMessage());
            return Result.error("分页查询出错");
        }
    }
}