package com.lan.running.service.impl;

import com.lan.running.config.EmailConfig;
import com.lan.running.service.EmailService;
import com.lan.running.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.internet.MimeMessage;
import java.io.File;

/**
 * 作者: Vlan
 * 时间: 2019/6/7 22:34
 */

@Service
public class EmailServiceImpl implements EmailService {

    @Autowired
    private EmailConfig mailconfig;
    @Autowired
    private JavaMailSender mailSender;
    @Override
    public void sendSimpleMail(String sendTo, String title, String content) {
        //简单邮件发送
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(mailconfig.getEmailFrom());
        message.setTo(sendTo);
        message.setSubject(title);
        message.setText(content);
        
        mailSender.send(message);
    }

    //发送带附件的邮件
    @Override
    public void sendAttachmentMail(String sendTo, String title, String content, File file) {
        MimeMessage msg = mailSender.createMimeMessage();
        try{
            MimeMessageHelper helper  = new MimeMessageHelper(msg,true);
            helper.setFrom(mailconfig.getEmailFrom());
            helper.setTo(sendTo);
            helper.setSubject(title);
            helper.setText(content);

            FileSystemResource r = new FileSystemResource(file);
            helper.addAttachment(DateUtil.getStringDateShort()+" 报表.png",r);
        }catch (Exception e){
            e.printStackTrace();
        }
        mailSender.send(msg);
    }
}
