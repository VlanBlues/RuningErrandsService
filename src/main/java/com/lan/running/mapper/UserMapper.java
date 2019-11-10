package com.lan.running.mapper;

import com.lan.running.bean.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Author: Vlan
 * Date: 2019/10/21 10:49
 */
public interface UserMapper {
    List<User> getAllUser();
    
    int addUser(User user);
    
    int updatePass(User user);
    
    User getUserByTel(String tel);
    
    User getUserByEmail(String email);
    
    User getUserById(int id);
    
    int upUserById(User user);
    
    int delUserById(int id);
    
    int upUserImg(@Param("img") String img,@Param("id") int id);
}
