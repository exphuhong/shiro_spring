package com.IFox.shiro.bean.control;

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
        if (username.equals("tom") && password.equals("123456")) {
            return "success";
        }
        return "error";
    }
}
