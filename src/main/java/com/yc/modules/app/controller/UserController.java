package com.yc.modules.app.controller;

import com.yc.common.dto.BaseResultDTO;
import com.yc.modules.app.form.LoginForm;
import com.yc.modules.app.form.RegisterForm;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/app/user")
@Api("用户相关接口")
public class UserController {

    @ApiOperation("注册")
    @PostMapping("register")
    public BaseResultDTO register(@RequestBody RegisterForm form) {
        return BaseResultDTO.ok();
    }

    @ApiOperation("登录")
    @RequestMapping("login")
    public BaseResultDTO login(@RequestBody LoginForm form) {
        return BaseResultDTO.ok();
    }

}