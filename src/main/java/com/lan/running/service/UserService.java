package com.lan.running.service;

import com.lan.running.bean.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * Author: Vlan
 * Date: 2019/10/21 10:34
 */
public interface UserService {
    
    List<User> getAllUser();
    
    User UserLogin(User user);
    
    String addUser(User user);
    
    int updatePass(User user);
    
    int upUserById(User user);

    User upUserImg(MultipartFile file,int id);
    
    User getUserById(int id);

    int delUserById(int id);
    
}
