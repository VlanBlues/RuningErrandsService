package com.lan.running.controller;

import com.lan.running.bean.Orders;
import com.lan.running.service.OrderService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Author: Vlan
 * Date: 2019/10/23 20:56
 */
@RestController
@RequestMapping("/order")
@CrossOrigin(origins = "*",maxAge = 3600)
public class OrderController {
    @Resource
    private OrderService orderService;
    
    //通过用户id添加订单
    @RequestMapping("/add_order")
    public int addOrderByOriginator( Orders orders){
        System.out.println(orders.getType());
        return orderService.addOrderByOriginator(orders);
    }

    //获取所有未接受的订单
    @RequestMapping("/get_no_orders")
    public List getUnfinishedOrders(){
        return orderService.getUnfinishedOrders();
    }

    //获取所有未接受快递或跑腿的订单
    @RequestMapping("/get_no_search_orders")
    public List getSearchOrders(String type,String text){
        return orderService.getUnfinishedSearchOrders(type,text);
    }

    //根据用户id获取所有发布的订单
    @RequestMapping("/get_fb_orders")
    public List getfbOrders(int id){
        return orderService.getFBOrdersByUid(id);
    }

    //根据用户id获取所有接受的订单
    @RequestMapping("/get_js_orders")
    public List getjsOrders(int id){
        return orderService.getJSOrdersByUid(id);
    }

    //用户接单
    @RequestMapping("/user_accept")
    public int acceptOrder(Orders orders) {
        return orderService.acceptOrder(orders);
    }

    //发单人修改状态
    @RequestMapping("/originator_up")
    public int originatorComplete(Orders orders) {
        return orderService.originatorComplete(orders);
    }

    //接单人修改状态
    @RequestMapping("/recipient_up")
    public int recipientComplete(Orders orders) {
        return orderService.recipientComplete(orders);
    }
}
