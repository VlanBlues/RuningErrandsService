package com.lan.running.bean;

import java.io.Serializable;

/**
 * Author: Vlan
 * Date: 2019/10/21 10:35
 */
public class Likes implements Serializable {
    private int id;
    private int orderId;
    private int likeUserId;
    private String likeState;
    private User user;

    @Override
    public String toString() {
        return "Likes{" +
                "id=" + id +
                ", orderId=" + orderId +
                ", likeUserId=" + likeUserId +
                ", likeState='" + likeState + '\'' +
                ", user=" + user +
                '}';
    }

    public String getLikeState() {
        return likeState;
    }

    public void setLikeState(String likeState) {
        this.likeState = likeState;
    }
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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

    public int getLikeUserId() {
        return likeUserId;
    }

    public void setLikeUserId(int likeUserId) {
        this.likeUserId = likeUserId;
    }
}
