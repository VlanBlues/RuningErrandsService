package com.lan.running.mapper;

import com.lan.running.bean.Message;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Author: Vlan
 * Date: 2019/10/25 21:44
 */
public interface MessageMapper {
    List getMsgAndUserByOrderId(int orderId);
    
    int addMsg(Message message);
}
