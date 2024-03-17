package com.runa.controller;

import com.runa.pojo.Dept;
import com.runa.pojo.Result;
import com.runa.service.DeptService;
import lombok.extern.slf4j.Slf4j;
import net.sf.jsqlparser.util.validation.ValidationException;
import net.sf.jsqlparser.util.validation.metadata.DatabaseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 部门管理Controller
 */
@Slf4j
@RestController
@RequestMapping("/depts")
public class DeptController {

    @Autowired
    private DeptService deptService;

    /**
     * 查询部门数据
     */

    @GetMapping
    public Result list() {
        log.info("查询全部部门数据");

        // 调用 service查询部门数据
        List<Dept> deptList = deptService.list();

        return Result.success(deptList);

    }

    /**
     * 删除部门
     */
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        log.info("根据id删除部门：{}", id);

        try {
            // 检查要删除的部门是否存在
            Dept dept = deptService.getById(id);
            if (dept == null) {
                return Result.error("找不到该部门");
            }
            // 尝试删除部门，如果删除失败，则返回相应的错误信息
            boolean deleteSuccess = deptService.delete(id);
            if (deleteSuccess==false) {
                return Result.error("删除部门失败，请稍后重试");
            }
            return Result.success();
        } catch (Exception e) {
            log.error("删除部门时出现错误：{}", e.getMessage());
            return Result.error("删除部门时出现错误，请联系管理员");
        }
    }


    /**
     * 添加部门
     */
    @PostMapping
    public Result add(@RequestBody Dept dept) {
        log.info("新增部门：{}", dept);

        try {
            // 调用service新增部门，id自动生成
            deptService.add(dept);
            return Result.success();
        } catch (DatabaseException e) {
            // 如果出现数据库错误，返回相应的错误信息
            return Result.error("数据库操作失败：" + e.getMessage());
        } catch (ValidationException e) {
            // 如果存在验证错误，返回相应的错误信息
            return Result.error("输入信息验证失败：" + e.getMessage());
        } catch (Exception e) {
            // 如果出现其他未知异常，返回通用错误信息
            return Result.error("发生未知错误，请联系管理员");
        }
    }


    /**
     * 根据ID查询部门
     */
    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id) {
        log.info("根据id查询部门：{}", id);

        try {
            // 调用service查询部门
            Dept dept = deptService.getById(id);

            if (dept == null) {
                return Result.error("找不到该部门");
            } else {
                return Result.success(dept);
            }
        } catch (DatabaseException e) {
            // 如果出现数据库错误，返回相应的错误信息
            return Result.error("数据库操作失败：" + e.getMessage());
        } catch (Exception e) {
            // 如果出现其他未知异常，返回通用错误信息
            return Result.error("发生未知错误，请联系管理员");
        }
    }


    /**
     * 编辑部门
     */
    @PutMapping
    public Result update(@RequestBody Dept dept) {
        try {
            log.info("编辑部门：{}==={}", dept.getId(), dept.getName());

            // 检查部门是否存在
            Dept existingDept = deptService.getById(dept.getId());
            if (existingDept == null) {
                return Result.error("找不到该部门");
            }

            // 调用service编辑部门
            deptService.update(dept);

            return Result.success(dept);

        } catch (DatabaseException e) {
            // 如果出现数据库错误，返回相应的错误信息
            return Result.error("数据库操作失败：" + e.getMessage());
        } catch (ValidationException e) {
            // 如果存在验证错误，返回相应的错误信息
            return Result.error("输入信息验证失败：" + e.getMessage());
        } catch (Exception e) {
            // 如果出现其他未知异常，返回通用错误信息
            return Result.error("发生未知错误，请联系管理员");
        }
    }
}
