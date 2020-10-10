package com.ce.lab11mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

/**
 * @author c__e
 * @date Created in 2020/10/10 11:33
 */
@Component
public class TestMailService {
    @Autowired
    private JavaMailSenderImpl mailSender;

    public void sendEmail() throws MessagingException {
        //简单邮件
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom("an37500@163.com");
        simpleMailMessage.setTo("837911098@qq.com");
        simpleMailMessage.setSubject("啦啦啦啦");
        simpleMailMessage.setText("简单邮件");
        mailSender.send(simpleMailMessage);

        // 复杂邮件
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
        mimeMessageHelper.setFrom("an37500@163.com");
        mimeMessageHelper.setTo("837911098@qq.com");
        mimeMessageHelper.setSubject("啦啦啦啦");
        mimeMessageHelper.setText("复杂邮件");
        mimeMessageHelper.addAttachment("1.jpg", new ClassPathResource("/1.jpg"));
        mailSender.send(mimeMessage);
    }
}
