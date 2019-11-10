package com.lan.running.mapper;

import com.lan.running.bean.Likes;

import java.util.List;

/**
 * Author: Vlan
 * Date: 2019/10/26 14:07
 */
public interface LikesMapper {
    Likes getLikes(Likes likes);
    
    int setLikes(Likes likes);
    
    int addLike(Likes likes);
    
    List<Likes> getLikeSize(int orderId);
}
