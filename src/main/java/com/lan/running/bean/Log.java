package com.lan.running.bean;

import java.io.Serializable;

/**
 * Author: Vlan
 * Date: 2019/11/6 11:04
 */
public class Log implements Serializable {
    private int id;
    private int uid;
    private String username;
    private String time;
    private String behavior;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getBehavior() {
        return behavior;
    }

    public void setBehavior(String behavior) {
        this.behavior = behavior;
    }
}
