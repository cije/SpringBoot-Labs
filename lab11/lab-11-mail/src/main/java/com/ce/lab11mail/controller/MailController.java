package com.ce.lab11mail.controller;

import com.ce.lab11mail.TestMailService;
import com.ce.lab11mail.service.MailService;
import com.ce.lab11mail.vo.MailVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.mail.MessagingException;

/**
 * @author c__e
 * @date Created in 2020/10/10 15:21
 */
@RestController
@RequestMapping("/testmail")
public class MailController {
    @Autowired
    private TestMailService service;

    @GetMapping("/testsend")
    public String sendTest() throws MessagingException {
        service.sendEmail();
        return "Success";
    }

    @Autowired
    private MailService mailService;

    @GetMapping("/testsend2")
    public MailVo sendTest2() throws MessagingException {
        MailVo mailVo = new MailVo();
        mailVo.setFrom("an37500@163.com");
        mailVo.setTo("cije1998@gmail.com");
        mailVo.setSubject("测试邮件");
        mailVo.setText("啦啦啦啦啦");
        return mailService.send(mailVo);
    }
}
