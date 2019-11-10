package com.lan.running.service.impl;

import com.lan.running.bean.Likes;
import com.lan.running.mapper.LikesMapper;
import com.lan.running.mapper.LogMapper;
import com.lan.running.mapper.UserMapper;
import com.lan.running.service.LikesService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Author: Vlan
 * Date: 2019/10/28 14:15
 */
@Service("likesService")
public class LikesServiceImpl implements LikesService {
    @Resource
    private LikesMapper likesMapper;
    
    @Override
    public int  getLikes(Likes likes) {
        Likes likes1 = likesMapper.getLikes(likes);
        if(likes1 == null || likes1.getLikeState().equals("false")){
            return 0;
        }else {
            return 1;
        }
    }

    @Override
    public int setLikes(Likes likes) {
        Likes likes1 = likesMapper.getLikes(likes);
        if(likes1 == null){
            likes.setLikeState("true");
            return likesMapper.addLike(likes);
        }else {
            return likesMapper.setLikes(likes);
        }
    }

    @Override
    public int getLikeSize(int orderId) {
        return likesMapper.getLikeSize(orderId).size();
    }
}
