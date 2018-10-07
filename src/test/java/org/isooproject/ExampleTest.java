package org.isooproject;

import org.isooproject.user.UserService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Example.class)
public class ExampleTest {

    // @Autowired로 의존성 주입을 받을 수 있는지 없는지 테스트
    @Autowired
    UserService userService;

    @Test
    public void di() {
        Assert.assertNotNull(userService);

    }
}
