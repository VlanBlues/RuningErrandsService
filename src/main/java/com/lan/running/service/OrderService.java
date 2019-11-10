package com.lan.running.service;

import com.lan.running.bean.Orders;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Author: Vlan
 * Date: 2019/10/23 20:56
 */

public interface OrderService {
    int addOrderByOriginator(Orders orders);

    List getUnfinishedOrders();
    
    List getUnfinishedSearchOrders(String type,String text);

    List getFBOrdersByUid(int id);
    
    List getJSOrdersByUid(int id);

    int acceptOrder(Orders orders);

    int originatorComplete(Orders orders);

    int recipientComplete(Orders orders);
}
