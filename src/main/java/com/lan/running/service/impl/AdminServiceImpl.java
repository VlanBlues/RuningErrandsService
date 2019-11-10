package com.lan.running.service.impl;

import com.lan.running.bean.Admin;
import com.lan.running.mapper.AdminMapper;
import com.lan.running.service.AdminService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Author: Vlan
 * Date: 2019/10/31 13:38
 */
@Service
public class AdminServiceImpl implements AdminService {
    
    @Resource
    private AdminMapper adminMapper;
    
    @Override
    public int login(Admin admin) {
        List<Admin> allAdmin = adminMapper.getAllAdmin();
        for (Admin anAllAdmin : allAdmin) {
            if (admin.getName().equals(anAllAdmin.getName()) && admin.getPass().equals(anAllAdmin.getPass())) {
                return 1;
            }
        }
        return 0;
    }
}
