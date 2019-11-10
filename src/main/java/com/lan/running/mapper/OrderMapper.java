package com.lan.running.mapper;

import com.lan.running.bean.Orders;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Author: Vlan
 * Date: 2019/10/23 20:56
 */
public interface OrderMapper {
    int addOrderByOriginator(Orders orders);
    
    List getUnfinishedOrders(@Param("unfinished") String unfinished,@Param("type") String type,@Param("text") String text);
    
    List getFBOrdersByUid(@Param("id") int id);
    
    List getJSOrdersByUid(@Param("id") int id);
    
    int acceptOrder(Orders orders);
    
    int originatorComplete(Orders orders);
    
    int recipientComplete(Orders orders);
}
