package com.lan.running.controller;

import com.lan.running.bean.Address;
import com.lan.running.bean.User;
import com.lan.running.service.AddressService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * Author: Vlan
 * Date: 2019/10/22 16:18
 */
@RestController
@CrossOrigin(origins = "*",maxAge = 3600)
@RequestMapping("/address")
public class AddressConteroller {
    @Resource
    private AddressService addressService;
    
    @RequestMapping("/all")
    public List<Address> getAllAddr(){
        return addressService.getAllAddr();
    }
    //添加地址
    @RequestMapping("/add")
    public int addAddress(@RequestBody Address address){
        //System.out.println(address.toString());
        return addressService.addAddress(address);
    }

    //根据uid获取地址
    @RequestMapping("/get_addr_uid")
    public List<Address> getAddrByUId(@RequestBody User user){
        return addressService.getAddrByUId(user);
    }
    
    //修改默认地址
    @RequestMapping("/up_addr_default")
    public Address upAddrDefault(int id,int uid){
        return addressService.upAddrDefault(id,uid);
    }
    //根据id删除地址
    @RequestMapping("/del_by_id")
    public int upAddrDefault(int id){
        return addressService.delAddrById(id);
    }
    
    //根据id获取地址
    @RequestMapping("/get_by_id")
    public Address getAddrById(int id){
        return addressService.getAddrById(id);
    }
    
}
