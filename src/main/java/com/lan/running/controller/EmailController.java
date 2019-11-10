package com.lan.running.controller;

import com.lan.running.mapper.UserMapper;
import com.lan.running.service.EmailService;
import com.lan.running.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import sun.misc.BASE64Decoder;

import javax.annotation.Resource;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;

/**
 * 作者: Vlan
 * 时间: 2019/6/8 0:05
 */

@Controller
@CrossOrigin(origins = "*",maxAge = 3600)
public class EmailController {
    
    
    @Resource
    private EmailService emailService;
    

    @RequestMapping("/simple")
    @ResponseBody
    public String sendSimplEmail(){
        emailService.sendSimpleMail("794758167@qq.com","再来一次","again");
        return "success";
    }
}
