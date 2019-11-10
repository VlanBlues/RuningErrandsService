package com.lan.running.util;

import com.lan.running.bean.Log;

/**
 * Author: Vlan
 * Date: 2019/11/6 11:08
 */
public class LogUtil {
    
    private static Log log = new Log();
    public static void  init(int uid,String username){
        log.setUid(uid);
        log.setUsername(username);
        log.setTime(DateUtil.getStringDate());
    }
    public static Log loginLog(int uid,String username){
        init(uid,username);
        log.setBehavior("登录");
        return log;
    }

    public static Log updateLog(int uid,String username){
        init(uid,username);
        log.setBehavior("修改个人信息");
        return log;
    }

    public static Log updatePassLog(int uid,String username){
        init(uid,username);
        log.setBehavior("修改密码");
        return log;
    }

    public static Log originatorLog(int uid,String username){
        init(uid,username);
        log.setBehavior("发布订单");
        return log;
    }

    public static Log recipientLog(int uid,String username){
        init(uid,username);
        log.setBehavior("接受订单");
        return log;
    }

    public static Log commentLog(int uid,String username){
        init(uid,username);
        log.setBehavior("评论");
        return log;
    }

    public static Log likeLog(int uid,String username){
        init(uid,username);
        log.setBehavior("点赞");
        return log;
    }
}
