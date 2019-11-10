package com.lan.running.service;

import java.io.File;

/**
 * 作者: Vlan
 * 时间: 2019/6/7 22:30
 */
public interface EmailService {
    //发送简单邮件
    void sendSimpleMail(String sendTo, String title, String content);
    
    //发送带附件的邮件
    void sendAttachmentMail(String sendTo, String title, String content, File file);
}
