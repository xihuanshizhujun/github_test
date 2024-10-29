package com.example.controller;

import com.example.common.AutoLog;
import com.example.common.Result;
import com.example.entity.Admin;
import com.example.entity.Params;
import com.example.service.AdminService;
import com.github.pagehelper.PageInfo;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/admin")
public class AdminController {

    @Resource
    private AdminService adminService;

    @PostMapping("/register")
    public Result register(@RequestBody Admin admin) {
        adminService.add(admin);
        return Result.success();
    }

    @PostMapping("/login")
    @AutoLog("登录该系统")
    public Result login(@RequestBody Admin admin) {
        Admin loginUser = adminService.login(admin);
        return Result.success(loginUser);
    }

    @GetMapping("/search")
    public Result findBySearch(Params params) {
        //controll层需要用info来接收service层的方法
        PageInfo<Admin> info = adminService.findBySearch(params);
        return Result.success(info);
    }
//接收前端对数据的post
    @PostMapping
    public Result save(@RequestBody Admin admin) {
        if (admin.getId() == null) {  //新增
            adminService.add(admin);
        } else {
            adminService.update(admin);  //修改
        }
        return Result.success();
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        adminService.delete(id);
        return Result.success();
    }
}