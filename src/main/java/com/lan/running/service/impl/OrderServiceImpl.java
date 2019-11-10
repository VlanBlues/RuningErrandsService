package com.lan.running.service.impl;

import com.lan.running.bean.Orders;
import com.lan.running.bean.User;
import com.lan.running.mapper.LogMapper;
import com.lan.running.mapper.OrderMapper;
import com.lan.running.mapper.UserMapper;
import com.lan.running.service.OrderService;
import com.lan.running.util.DateUtil;
import com.lan.running.util.LogUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Author: Vlan
 * Date: 2019/10/23 20:57
 */
@Service("orderService")
public class OrderServiceImpl implements OrderService {

    @Resource
    private OrderMapper orderMapper;
    @Resource
    private LogMapper logMapper;
    @Resource
    private UserMapper userMapper;
    
    @Override
    public int addOrderByOriginator(Orders orders) {
        logMapper.addLog(LogUtil.originatorLog(orders.getOriginatorId(),userMapper.getUserById(orders.getOriginatorId()).getUsername()));
        orders.setOriginatorTime(DateUtil.getStringDate());
        orders.setOriginatorState("已发出");
        return orderMapper.addOrderByOriginator(orders);
    }

    //获取未接受订单
    @Override
    public List getUnfinishedOrders() {
        //String unfinished="未接单";
        return orderMapper.getUnfinishedOrders("未接单", null, null);
    }

    //获取搜索的订单
    @Override
    public List getUnfinishedSearchOrders(String type, String text) {
        return orderMapper.getUnfinishedOrders("未接单",type,text);
    }
    

    //根据uid获取用户发布的订单
    @Override
    public List getFBOrdersByUid(int id) {
        return orderMapper.getFBOrdersByUid(id);
    }
    
    //根据uid获取用户接受的订单
    @Override
    public List getJSOrdersByUid(int id) {
        return orderMapper.getJSOrdersByUid(id);
    }

    //用户接单
    @Override
    public int acceptOrder(Orders orders) {
        logMapper.addLog(LogUtil.recipientLog(orders.getRecipientId(),userMapper.getUserById(orders.getRecipientId()).getUsername()));
        orders.setRecipientTime(DateUtil.getStringDate());
        orders.setRecipientState("已接受");
        return orderMapper.acceptOrder(orders);
    }
    
    //发单人修改状态
    @Override
    public int originatorComplete(Orders orders) {
        orders.setCompletionTime(DateUtil.getStringDate());
        orders.setOriginatorState("已完成");
        return orderMapper.originatorComplete(orders);
    }
    
    //接单人修改状态
    @Override
    public int recipientComplete(Orders orders) {
        orders.setRecipientState("已完成");
        return orderMapper.recipientComplete(orders);
    }
}
