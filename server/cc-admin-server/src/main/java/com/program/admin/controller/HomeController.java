package com.program.admin.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.program.user.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

/**
 * Created by cuipp22399 on 17/1/18.
 */
@Controller
public class HomeController {
    private static final Logger log = LoggerFactory.getLogger(HomeController.class);

    @Reference(version = "1.0.0")
    private UserService userService;

    @RequestMapping({"/index", "/"})
    public String index(Model model) {
        return "admin/index";
    }

    @RequestMapping("/login")
    public String login() {
        return "/admin/login";
    }

    @RequestMapping(value = "/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            new SecurityContextLogoutHandler().logout(request, response, auth);
            log.info("用户[{}]于{}注销登录成功", auth.getName(), new Date());
        }
        Authentication auth1 = SecurityContextHolder.getContext().getAuthentication();
        return "admin/login";
    }
}
