package com.lan.running.service;

import com.lan.running.bean.Address;
import com.lan.running.bean.User;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Author: Vlan
 * Date: 2019/10/22 16:19
 */

public interface AddressService {
    
    List<Address> getAllAddr();
    
    List<Address> getAddrByUId(User user);

    int addAddress(Address address);
    
    Address upAddrDefault(int id,int uid);

    int delAddrById(int id);

    Address getAddrById(int id);
}
