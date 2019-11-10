package com.lan.running.service.impl;

import com.lan.running.bean.Log;
import com.lan.running.bean.User;
import com.lan.running.mapper.LogMapper;
import com.lan.running.mapper.UserMapper;
import com.lan.running.service.UserService;
import com.lan.running.util.DateUtil;
import com.lan.running.util.LogUtil;
import com.lan.running.util.RandomUtil;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

/**
 * Author: Vlan
 * Date: 2019/8/7 20:01
 */
@Service("userService")
public class UserServiceImpl implements UserService {


    @Resource
    private UserMapper userMapper;
    @Resource
    private LogMapper logMapper;

    @Override
    public List<User> getAllUser() {
        return userMapper.getAllUser();
    }

    @Override
    public User UserLogin(User user) {
        for (int i = 0; i < getAllUser().size(); i++) {
            if (getAllUser().get(i).getTel().equals(user.getTel()) && getAllUser().get(i).getPassword().equals(user.getPassword())) {
                logMapper.addLog(LogUtil.loginLog(getAllUser().get(i).getId(),getAllUser().get(i).getUsername()));
                return userMapper.getUserByTel(user.getTel());
            }
        }
        user.setId(-1);
        return user;
    }

    @Override
    public String addUser(User user) {
        user.setRegisterTime(DateUtil.getStringDate());
        for (int i = 0; i < getAllUser().size(); i++) {
            if (user.getTel().equals(getAllUser().get(i).getTel())
                    || user.getEmail().equals(getAllUser().get(i).getEmail())) {
                return "100";
            }
        }
        return userMapper.addUser(user) + "";
    }

    @Override
    public int updatePass(User user) {
        User user1 = userMapper.getUserByEmail(user.getEmail());
        logMapper.addLog(LogUtil.updatePassLog(user1.getId(),user1.getUsername()));
        return userMapper.updatePass(user);
    }

    @Override
    public int upUserById(User user) {
        logMapper.addLog(LogUtil.updateLog(user.getId(),user.getUsername()));
        return userMapper.upUserById(user);
    }

    @Override
    public User upUserImg(MultipartFile file,int id) {
        int res = 0;
        String local = "src/main/resources/static/img/";
        //String local = "F:/img/test/";
        String fileName = file.getOriginalFilename();
        String fileType = "." + fileName.substring(fileName.lastIndexOf(".") + 1);
        // 存储图片
        //String filename = DateUtil.getStringToday().trim() + fileType;
        String filename = RandomUtil.getTenRandom() + fileType;
        
        try (InputStream inputStream = file.getInputStream()) {
            Files.copy(inputStream, Paths.get(local + filename), // 这里指定了下载的位置
                    StandardCopyOption.REPLACE_EXISTING);
            res = 1;
        } catch (IOException e) {
            System.out.println("上传失败");
        }
        filename ="http://localhost:8080/img/"+ filename;
        //filename ="http://10.152.27.110:8080/img/"+ filename;
        userMapper.upUserImg(filename,id);
        return userMapper.getUserById(id);
    }

    @Override
    public User getUserById(int id) {
        
        return userMapper.getUserById(id);
    }

    @Override
    public int delUserById(int id) {
        return userMapper.delUserById(id);
    }


}
