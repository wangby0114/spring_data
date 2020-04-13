package com.wangby.controller;

import com.wangby.entity.Account;
import com.wangby.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @RequestMapping("/login")
    public String login() {

        return "account/login";
    }

    @RequestMapping("/validataAccount")
    @ResponseBody
    public String validataAccount(String loginName, String password, HttpServletRequest request) {
        Account account = accountService.findByLoginNameAndPassword(loginName, password);
        if (account == null) {
            return "登录失败";
        } else {
            //登录成功，存入session，同时返回登录成功
            request.getSession().setAttribute("account", account);
            return "success";
        }
    }

    @RequestMapping("/logOut")
    public String logOut(HttpServletRequest request) {
        request.getSession().removeAttribute("account");
        return "/index";
    }

    @RequestMapping("/list")
    public String list() {

        accountService.findAllList();
        return "account/list";
    }

}
