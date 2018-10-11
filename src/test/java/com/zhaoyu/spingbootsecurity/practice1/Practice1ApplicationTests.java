package com.zhaoyu.spingbootsecurity.practice1;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Practice1ApplicationTests {

    @Test
    public void getPaasword() {

        String password=new BCryptPasswordEncoder(4).encode("123");
        System.out.println("加密|"+password+"|");
    }

}
