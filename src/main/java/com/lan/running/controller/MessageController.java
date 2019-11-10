package com.lan.running.controller;

import com.lan.running.bean.Message;
import com.lan.running.service.MessageService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * Author: Vlan
 * Date: 2019/10/26 8:48
 */
@RestController
@CrossOrigin(origins = "*",maxAge = 3600)
@RequestMapping("/msg")
public class MessageController {
    @Resource
    private MessageService messageService;
    
    
    @RequestMapping("/add")
    public int addMsg(Message message){
        return messageService.addMsg(message);
    }

    @RequestMapping("/get_by_oid")
    public List getMsgAndUserByOrderId(int orderId){
        return messageService.getMsgAndUserByOrderId(orderId);
    }
    
}
