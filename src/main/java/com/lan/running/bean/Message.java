package com.lan.running.bean;

import java.io.Serializable;

/**
 * Author: Vlan
 * Date: 2019/10/25 21:35
 */
public class Message implements Serializable {
    private int id;
    private int orderId;
    private int msgUserId;
    private String msgTime;
    private String msg;
    private User user;

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", orderId=" + orderId +
                ", msgUserId=" + msgUserId +
                ", msgTime='" + msgTime + '\'' +
                ", msg='" + msg + '\'' +
                ", user=" + user +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getMsgUserId() {
        return msgUserId;
    }

    public void setMsgUserId(int msgUserId) {
        this.msgUserId = msgUserId;
    }

    public String getMsgTime() {
        return msgTime;
    }

    public void setMsgTime(String msgTime) {
        this.msgTime = msgTime;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
