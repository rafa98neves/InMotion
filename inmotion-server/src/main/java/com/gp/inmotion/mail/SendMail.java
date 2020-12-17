package com.gp.inmotion.mail;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;

public class SendMail extends Thread{

    private JavaMailSenderImpl mailSender;
    private SimpleMailMessage mailMessage;
    private EmailConfig emailConfig;

    public SendMail(EmailConfig emailConfig, SimpleMailMessage mailMessage){
        this.emailConfig = emailConfig;
        this.mailMessage = mailMessage;

        mailSender = new JavaMailSenderImpl();
        mailSender.setHost(emailConfig.getHost());
        mailSender.setPort(emailConfig.getPort());
        mailSender.setUsername(emailConfig.getUsername());
        mailSender.setPassword(emailConfig.getPassword());
    }

    @Override
    public void run() {
        mailSender.send(mailMessage);
    }
}
