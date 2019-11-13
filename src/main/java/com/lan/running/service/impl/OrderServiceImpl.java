package com.lan.running.service.impl;

import com.lan.running.bean.Orders;
import com.lan.running.bean.OrdersAnalysis;
import com.lan.running.bean.User;
import com.lan.running.mapper.LogMapper;
import com.lan.running.mapper.OrderMapper;
import com.lan.running.mapper.UserMapper;
import com.lan.running.service.OrderService;
import com.lan.running.util.DateUtil;
import com.lan.running.util.LogUtil;
import org.springframework.core.annotation.Order;
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

    //获取所有的订单
    @Override
    public Map<String,Object> getAllOrders(Integer page,Integer limit) {
        List<Orders> orders = orderMapper.getAllOrders();
        for(Orders orders1: orders){
            orders1.setOriginatorName(userMapper.getUserById(orders1.getOriginatorId()).getUsername());
            if(orders1.getRecipientId()!= 0){
                orders1.setRecipientName(userMapper.getUserById(orders1.getRecipientId()).getUsername());
            }
            
        }
        List<Orders> orders1 = null;
        int page1 = orders.size()/limit;
        if(orders.size() % limit !=0 && page1+1==page){
            orders1 = orders.subList(page * limit - limit, orders.size());
        }else {
            orders1 = orders.subList(page * limit - limit, page * limit-1);
        }
        Map<String,Object> map = new HashMap<>();
        map.put("code",0);
        map.put("msg","");
        map.put("count",orders.size());
        map.put("data",orders1);
        return map;
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
        orders.setOriginatorState("已完成");
        if(orderMapper.getOrderById(orders.getId()).getRecipientState().equals("已完成")){
            orders.setCompletionTime(DateUtil.getStringDate());
        }
        return orderMapper.originatorComplete(orders);
    }
    
    //接单人修改状态
    @Override
    public int recipientComplete(Orders orders) {
        orders.setRecipientState("已完成");
        if(orderMapper.getOrderById(orders.getId()).getOriginatorState().equals("已完成")){
            orders.setCompletionTime(DateUtil.getStringDate());
        }
        return orderMapper.recipientComplete(orders);
    }

    //通过id删除订单
    @Override
    public int delByOrdersId(int id) {
        return orderMapper.delByOrdersId(id);
    }

    @Override
    public List getOrdersAnalysis() {
        List total = new ArrayList();
        List finish = new ArrayList();
        List time = new ArrayList();
        List re = new ArrayList();
        for(int i=0;i<orderMapper.getOrdersAnalysis().size();i++){
            total.add(orderMapper.getOrdersAnalysis().get(i).getTotal());
            finish.add(orderMapper.getOrdersAnalysis().get(i).getFinish());
            time.add(orderMapper.getOrdersAnalysis().get(i).getTime());
        }
        re.add(total);
        re.add(finish);
        re.add(time);
        return re;
    }
}
