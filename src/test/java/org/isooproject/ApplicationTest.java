package org.isooproject;

import org.isooproject.user.UserService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class ApplicationTest {

    @Autowired
    UserService userService;

    @Test
    public void testDI() {
        Assert.assertNotNull(userService);
        Assert.assertNotNull(userService.getUserRepository());
    }
}
