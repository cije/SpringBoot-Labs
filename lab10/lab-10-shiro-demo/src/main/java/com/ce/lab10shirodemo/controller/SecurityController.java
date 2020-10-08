package com.ce.lab10shirodemo.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.ExpiredCredentialsException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @author c__e
 * @date Created in 2020/10/8 20:59
 */
@Controller
public class SecurityController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @GetMapping("/login")
    public String loginPage() {
        return "login.html";
    }

    @ResponseBody
    @PostMapping("/login")
    public String login(HttpServletRequest request) {
        // <1> 判断是否已经登录
        Subject subject = SecurityUtils.getSubject();
        if (subject.getPrincipal() != null) {
            return "你已经登录账号：" + subject.getPrincipal();
        }

        // <2> 获得登录失败的原因
        String shiroLoginFailure = (String) request.getAttribute(FormAuthenticationFilter.DEFAULT_ERROR_KEY_ATTRIBUTE_NAME);
        // 翻译成人类看的懂的提示
        String msg = "";
        if (UnknownAccountException.class.getName().equals(shiroLoginFailure)) {
            msg = "账号不存在";
        } else if (IncorrectCredentialsException.class.getName().equals(shiroLoginFailure)) {
            msg = "密码不正确";
        } else if (LockedAccountException.class.getName().equals(shiroLoginFailure)) {
            msg = "账号被锁定";
        } else if (ExpiredCredentialsException.class.getName().equals(shiroLoginFailure)) {
            msg = "账号已过期";
        } else {
            msg = "未知";
            logger.error("[login][未知登录错误：{}]", shiroLoginFailure);
        }
        return "登录失败，原因：" + msg;
    }

    @ResponseBody
    @GetMapping("/login_success")
    public String loginSuccess() {
        return "登录成功";
    }

    @ResponseBody
    @GetMapping("/unauthorized")
    public String unauthorized() {
        return "你没有权限";
    }
}
