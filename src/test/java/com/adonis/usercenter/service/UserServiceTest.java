package com.adonis.usercenter.service;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;

import com.adonis.usercenter.model.domain.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.DigestUtils;

import javax.annotation.Resource;

/**
 * 用户服务测试
 *
 * @author adonis
 */
@SpringBootTest
public class UserServiceTest {

    @Resource
    private UserService userService;

    @Test
    void testDigest() throws NoSuchAlgorithmException {
        String newPassword = DigestUtils.md5DigestAsHex(("abcd" + "mypassword").getBytes());
        System.out.println(newPassword);
    }

    @Test
    void userRegister() {
        String userAccount = "adonis";
        String userPassword = "";
        String checkPassword = "123456";
        String idCode = "1";
        long result = userService.userRegister(userAccount, userPassword, checkPassword, idCode);
        Assertions.assertEquals(-1, result);

        userAccount = "ad";
        result = userService.userRegister(userAccount, userPassword, checkPassword, idCode);
        Assertions.assertEquals(-1, result);

        userAccount = "adonis";
        userPassword = "123456";
        result = userService.userRegister(userAccount, userPassword, checkPassword, idCode);
        Assertions.assertEquals(-1, result);

        userAccount = "ado nis";
        userPassword = "12345678";
        result = userService.userRegister(userAccount, userPassword, checkPassword, idCode);
        Assertions.assertEquals(-1, result);

        checkPassword = "123456789";
        result = userService.userRegister(userAccount, userPassword, checkPassword, idCode);
        Assertions.assertEquals(-1, result);

        userAccount = "1234";
        checkPassword = "12345678";
        result = userService.userRegister(userAccount, userPassword, checkPassword, idCode);
        Assertions.assertEquals(-1, result);

        userAccount = "adonis01";
        result = userService.userRegister(userAccount, userPassword, checkPassword, idCode);
        Assertions.assertEquals(-1, result);
    }

    @Test
    public void testAddUser() {
        User user = new User();
        user.setUsername("testUser");
        user.setUserAccount("123");
        user.setAvatarUrl("https://pic.code-nav.cn/user_avatar/1747537878507896833/ZVW3Wp8C-%E5%BE%AE%E4%BF%A1%E5%9B%BE%E7%89%87_20240221213145.jpg");
        user.setGender(0);
        user.setUserPassword("xxx");
        user.setPhone("123");
        user.setEmail("456");

        boolean result = userService.save(user);
        System.out.println(user.getId());
        Assertions.assertTrue(result);
    }
}