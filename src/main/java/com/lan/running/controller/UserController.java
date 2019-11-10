package com.lan.running.controller;

import com.lan.running.bean.User;
import com.lan.running.service.EmailService;
import com.lan.running.service.UserService;
import com.lan.running.util.RandomUtil;
import com.lan.running.util.RedisUtil;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.validation.constraints.Email;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Author: Vlan
 * Date: 2019/10/21 10:58
 */
@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "*",maxAge = 3600)
public class UserController {
    @Resource
    private UserService userService;
    @Resource
    private RedisUtil redisUtil;
    @Resource
    private EmailService emailService;
    
    @RequestMapping("/all")
    public List<User> getAllUser(){
        //redisUtil.set("test","lans",200);
        return userService.getAllUser();
    }

    @RequestMapping("/del")
    public int delUserById(int id){
        return userService.delUserById(id);
    }
    
    @RequestMapping("/allMap")
    public Map<String,Object> getUsers(Integer page,Integer limit){
        //return userMapper.selectUser();
        List<User> users = userService.getAllUser();
        List<User> users1 = null;
        int page1 = users.size()/limit;
        if(users.size() % limit !=0 && page1+1==page){
            users1 = users.subList(page * limit - limit, users.size());
        }else {
            users1 = users.subList(page * limit - limit, page * limit-1);
        }
        Map<String,Object> map = new HashMap<>();
        map.put("code",0);
        map.put("msg","");
        map.put("count",users.size());
        map.put("data",users1);

        return map;
    }
    
    //登录
    @RequestMapping("/login")
    public User getUserByTel(@RequestBody User user){
        //System.out.println(user.toString());
        
        return userService.UserLogin(user);
    }
    //注册
    @RequestMapping("/register")
    public String addUser( User user){
        //System.out.println(user.toString());
        
        return userService.addUser(user);
    }
    //发送邮箱验证码
    @RequestMapping("/email_code")
    public int emailCode(@RequestBody User user){
        String code = RandomUtil.getRandom();
        redisUtil.set(user.getEmail(),code,200);
        emailService.sendSimpleMail(user.getEmail(),"验证码","验证码为："+code);
        return 1;
    }
    //修改密码
    @RequestMapping("/update_pass")
    public int forgetPass(@RequestBody User user){
        if(user.getCode().equals(redisUtil.get(user.getEmail()))){
            return userService.updatePass(user);
        }
        return 100;
    }
    @RequestMapping("/get_by_id")
    //根据id获取user
    public User getUserById(int id){
        return userService.getUserById(id);
    }
    //修改个人资料
    @RequestMapping("/update_user")
    public int upUserById( User user){
       return userService.upUserById(user);
       //return 0;
    }
    
    //修改图片
    @PostMapping("/up_img")
        public User handleFileUpload(@RequestParam("file") MultipartFile file,int id) throws Exception {
        //System.out.println(file);
        //System.out.println(id);
        return userService.upUserImg(file,id);
    }
}
