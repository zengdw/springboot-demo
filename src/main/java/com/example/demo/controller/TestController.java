package com.example.demo.controller;

import com.example.demo.domain.Mod;
import com.example.demo.domain.User;
import com.example.demo.mapper.master.UserMapper;
import com.example.demo.mapper.slave.ModMapper;
import jakarta.annotation.Resource;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zengd
 * @version 1.0
 * @date 2023/1/13 10:06
 */
@RestController
public class TestController {
    @Resource
    private UserMapper userMapper;
    @Resource
    private ModMapper modMapper;

    @GetMapping("/test")
    @Transactional(rollbackFor = Exception.class)
    public void test() {
        User user = new User();
        user.setId(1);
        user.setName("test");
        userMapper.add(user);

        Mod mod = new Mod();
        mod.setId(1);
        mod.setUserId(1);
        mod.setMod("mod");
        modMapper.add(mod);
    }
}
