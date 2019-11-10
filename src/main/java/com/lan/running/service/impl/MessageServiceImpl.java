package com.lan.running.service.impl;

import com.lan.running.bean.Message;
import com.lan.running.mapper.LogMapper;
import com.lan.running.mapper.MessageMapper;
import com.lan.running.mapper.UserMapper;
import com.lan.running.service.MessageService;
import com.lan.running.util.DateUtil;
import com.lan.running.util.LogUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Author: Vlan
 * Date: 2019/10/25 21:45
 */
@Service
public class MessageServiceImpl implements MessageService {
    @Resource
    private MessageMapper messageMapper;
    @Resource
    private LogMapper logMapper;
    @Resource
    private UserMapper userMapper;

    @Override
    public int addMsg(Message message) {
        logMapper.addLog(LogUtil.commentLog(message.getMsgUserId(),userMapper.getUserById(message.getMsgUserId()).getUsername()));
        message.setMsgTime(DateUtil.getStringDate());
        return messageMapper.addMsg(message);
    }

    @Override
    public List getMsgAndUserByOrderId(int orderId) {
        return messageMapper.getMsgAndUserByOrderId(orderId);
    }
}
