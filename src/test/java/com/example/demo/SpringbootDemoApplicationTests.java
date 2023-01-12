package com.example.demo;

import com.example.demo.domain.Mod;
import com.example.demo.domain.User;
import com.example.demo.mapper.master.UserMapper;
import com.example.demo.mapper.slave.ModMapper;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringbootDemoApplicationTests {
    @Resource
    private UserMapper userMapper;
    @Resource
    private ModMapper modMapper;

    @Test
    void contextLoads() {
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
