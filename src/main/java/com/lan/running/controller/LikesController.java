package com.lan.running.controller;

import com.lan.running.bean.Likes;
import com.lan.running.service.LikesService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * Author: Vlan
 * Date: 2019/10/27 13:39
 */
@RestController
@CrossOrigin(origins = "*",maxAge = 3600)
@RequestMapping("/likes")
public class LikesController {
    @Resource
    private LikesService likesService;
    
    @RequestMapping("/get_like")
    public int getLikes(Likes likes){
        return likesService.getLikes(likes);
    }
    
    @RequestMapping("/set_like")
    public int setLike(Likes likes){
        System.out.println(likes.getLikeState());
        return likesService.setLikes(likes);
    }

    @RequestMapping("/get_size")
    public int getLikeSize(int orderId){
        return likesService.getLikeSize(orderId);
    }
}
