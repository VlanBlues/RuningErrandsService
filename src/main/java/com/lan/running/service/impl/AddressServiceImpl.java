package com.lan.running.service.impl;

import com.lan.running.bean.Address;
import com.lan.running.bean.User;
import com.lan.running.mapper.AddressMapper;
import com.lan.running.service.AddressService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Author: Vlan
 * Date: 2019/10/22 16:20
 */
@Service()
public class AddressServiceImpl implements AddressService {

    @Resource
    private AddressMapper addressMapper;

    @Override
    public List<Address> getAllAddr() {
        return addressMapper.getAllAddr();
    }

    @Override
    public List<Address> getAddrByUId(User user) {
        return addressMapper.getAddrByUId(user);
    }

    @Override
    public int addAddress(Address address) {
        if (address.getIsDefault().equals("true")) {
            User user = new User();
            user.setId(address.getUid());
            List<Address> addrs = addressMapper.getAddrByUId(user);
            for (Address addr : addrs) {
                if (addr.getIsDefault().equals("true")) {
                    addressMapper.upAddrDefault(addr.getId(), "false");
                }
            }
        }
        return addressMapper.addAddress(address);
    }

    @Override
    public Address upAddrDefault(int id, int uid) {
        User user = new User();
        user.setId(uid);
        List<Address> addrs = addressMapper.getAddrByUId(user);
        for (Address addr : addrs) {
            if (addr.getIsDefault().equals("true")) {
                addressMapper.upAddrDefault(addr.getId(), "false");
            }
        }
        addressMapper.upAddrDefault(id, "true");
        return addressMapper.getAddrById(id);
    }

    @Override
    public int delAddrById(int id) {
        return addressMapper.delAddrById(id);
    }

    @Override
    public Address getAddrById(int id) {
        return addressMapper.getAddrById(id);
    }
}
