package com.lan.running.controller;

import com.lan.running.bean.Admin;
import com.lan.running.service.AdminService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * Author: Vlan
 * Date: 2019/10/31 11:38
 */
@Controller
@CrossOrigin(origins = "*",maxAge = 3600)
@RequestMapping("/admin")
public class AdminController {
    @Resource
    private AdminService adminService;
    
    @RequestMapping("")
    public String index(){
        return "index";
    }

    @ResponseBody
    @RequestMapping("/login")
    public int login(Admin admin,HttpSession session){
        session.setAttribute("username",admin.getName());
        return adminService.login(admin);
    }
    
    @RequestMapping("/main")
    public String main(){
        return "main";
    }

    @RequestMapping("/userManage")
    public String userManage(){
        return "userManage";
    }
    
    @RequestMapping("/log")
    public String logPage(){
        return "log";
    }

    @RequestMapping("/userAnalysis")
    public String getUserAnalysis(){
        return "userAnalysis";
    }

    @RequestMapping("/ordersAnalysis")
    public String getOrdersAnalysis(){
        return "ordersAnalysis";
    }

    @RequestMapping("/ordersManage")
    public String getOrdersManage(){
        return "orderManage";
    }

    /*@RequestMapping("/main1")
    public String main1(){
        return "main1";
    }*/
    
}
