package com.lan.running.bean;

import java.io.Serializable;

/**
 * Author: Vlan
 * Date: 2019/10/23 20:48
 */
public class Orders implements Serializable {
    private int id;
    private String type;
    private String objective;
    private int addressId;
    private String money;
    private int originatorId;
    private int recipientId;
    private String originatorTime;
    private String recipientTime;
    private String originatorState;
    private String recipientState;
    private String completionTime;
    private String originatorName;
    private String recipientName;

    public String getOriginatorName() {
        return originatorName;
    }

    public void setOriginatorName(String originatorName) {
        this.originatorName = originatorName;
    }

    public String getRecipientName() {
        return recipientName;
    }

    public void setRecipientName(String recipientName) {
        this.recipientName = recipientName;
    }

    public String getCompletionTime() {
        return completionTime;
    }

    public void setCompletionTime(String completionTime) {
        this.completionTime = completionTime;
    }

    private User user;

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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getObjective() {
        return objective;
    }

    public void setObjective(String objective) {
        this.objective = objective;
    }

    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    public int getOriginatorId() {
        return originatorId;
    }

    public void setOriginatorId(int originatorId) {
        this.originatorId = originatorId;
    }

    public int getRecipientId() {
        return recipientId;
    }

    public void setRecipientId(int recipientId) {
        this.recipientId = recipientId;
    }

    public String getOriginatorTime() {
        return originatorTime;
    }

    public void setOriginatorTime(String originatorTime) {
        this.originatorTime = originatorTime;
    }

    public String getRecipientTime() {
        return recipientTime;
    }

    public void setRecipientTime(String recipientTime) {
        this.recipientTime = recipientTime;
    }

    public String getOriginatorState() {
        return originatorState;
    }

    public void setOriginatorState(String originatorState) {
        this.originatorState = originatorState;
    }

    public String getRecipientState() {
        return recipientState;
    }

    public void setRecipientState(String recipientState) {
        this.recipientState = recipientState;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", objective='" + objective + '\'' +
                ", addressId=" + addressId +
                ", money='" + money + '\'' +
                ", originatorId='" + originatorId + '\'' +
                ", recipientId='" + recipientId + '\'' +
                ", originatorTime='" + originatorTime + '\'' +
                ", recipientTime='" + recipientTime + '\'' +
                ", originatorState='" + originatorState + '\'' +
                ", recipientState='" + recipientState + '\'' +
                '}';
    }
}
