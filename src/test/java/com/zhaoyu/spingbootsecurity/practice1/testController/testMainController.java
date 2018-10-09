package com.zhaoyu.spingbootsecurity.practice1.testController;

import com.zhaoyu.spingbootsecurity.practice1.domain.User;
import com.zhaoyu.spingbootsecurity.practice1.repository.UserRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
public class testMainController {
    @Autowired
    private UserRepository userRepository;

    @Before
    public void start() {
        System.out.println("start");
    }

    @Test
    public void save() {
        userRepository.save(new User("zhaoyu", "1234", "7568@qq.com"));
        userRepository.save(new User("张欣", "1234", "1234@qq.com"));
        userRepository.save(new User("张欣", "1234", "3456@qq.com"));
    }

    @After
    public void end() {
        System.out.println("end");
    }
}
