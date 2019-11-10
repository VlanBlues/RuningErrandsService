package com.lan.running.service;

import com.lan.running.bean.Likes;

import java.util.List;

/**
 * Author: Vlan
 * Date: 2019/10/28 14:14
 */
public interface LikesService {

    int getLikes(Likes likes);

    int setLikes(Likes likes);
    
    int getLikeSize(int orderId);
}
