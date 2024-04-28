package com.adonis.usercenter.model.domain.request;

import lombok.Data;

import java.io.Serializable;

/**
 * 用户登录请求体
 *
 * @author adonis
 */
@Data
public class UserLoginRequest implements Serializable {
    public static final long serialVersionUID = -8628023485746538700L;

    private String userAccount;

    private String userPassword;
}
