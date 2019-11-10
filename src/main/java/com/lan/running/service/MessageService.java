package com.lan.running.service;

import com.lan.running.bean.Message;

import java.util.List;

/**
 * Author: Vlan
 * Date: 2019/10/25 21:45
 */
public interface MessageService {
    int addMsg(Message message);

    List getMsgAndUserByOrderId(int orderId);
}
