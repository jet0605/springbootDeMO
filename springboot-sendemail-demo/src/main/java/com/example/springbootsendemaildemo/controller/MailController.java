package com.example.springbootsendemaildemo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.MessageRemovedException;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.text.SimpleDateFormat;

@RestController
public class MailController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Value("${mail.fromMail.sender}")
    private String sender;

    @Value("${mail.fromMail.receiver}")
    private String receiver;

    @Autowired
    private JavaMailSender javaMailSender;

    @RequestMapping("/sendMail")
    public String sendMail(){
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom(sender);
        mailMessage.setTo(receiver);
        mailMessage.setSubject("Jet");
        mailMessage.setText("Hello");
        try{
            javaMailSender.send(mailMessage);
            logger.info("邮件已发送");
        }catch (Exception e){
            logger.info("发送邮件时发生异常 ",e);
        }
        return "success";
    }

    @RequestMapping("/sendInlineResourceMail")
    public String sendInlineResourceMail(){
        String Id = "dalao";
        String content="<html><body>我是马云：<img src=\'cid:" + Id + "\' ></body></html>";
        String imgPath = "C:\\Users\\aiiage\\Pictures\\Camera Roll\\p1.png";
        MimeMessage message = javaMailSender.createMimeMessage();
        try{
            MimeMessageHelper helper = new MimeMessageHelper(message,true);
            helper.setFrom(sender);
            helper.setTo(receiver);
            helper.setSubject("阿里巴巴内部邮件");
            helper.setText(content,true);
            FileSystemResource res = new FileSystemResource(new File(imgPath));
            helper.addInline(Id,res);
            javaMailSender.send(message);
            logger.info("邮件已发送");
        }catch (MessagingException e){
            logger.error("发送异常");
        }
        return "success";
    }
}
