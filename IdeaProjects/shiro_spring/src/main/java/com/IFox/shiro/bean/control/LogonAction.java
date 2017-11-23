package com.IFox.shiro.bean.control;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by exphuhong
 * Date 17-11-22.
 * Start
 */
@Controller
public class LogonAction {
    @RequestMapping("/logon")
    public String logon(@RequestParam("username") String username, @RequestParam("password") String password) {
        //创建Subject实例
        Subject currentUser = SecurityUtils.getSubject();

        //判断当前用户是否已经登录
        if (!currentUser.isAuthenticated()) {
            //将用户名以及密码封装
            UsernamePasswordToken token = new UsernamePasswordToken(username, password);

            try {
                currentUser.login(token);
            } catch (AuthenticationException e) {
                System.out.println("登录失败");
                return "error";
            }
        }
        return "success";
    }
    @RequestMapping("/check")
    public String check() {
        Subject current = SecurityUtils.getSubject();
        if (current.isAuthenticated()) {
            return "admin1";
        } else {
            return "admin123";
        }
    }
}
