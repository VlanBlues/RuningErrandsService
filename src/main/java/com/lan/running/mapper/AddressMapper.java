package com.lan.running.mapper;

import com.lan.running.bean.Address;
import com.lan.running.bean.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Author: Vlan
 * Date: 2019/10/22 16:18
 */
public interface AddressMapper {
    List<Address> getAllAddr();
    
    List<Address> getAddrByUId(User user);
    
    Address getAddrById(int id);
    
    int addAddress(Address address);
    
    int upAddrDefault(@Param("id") int id,@Param("value") String value);
    
    int delAddrById(int id);
}
