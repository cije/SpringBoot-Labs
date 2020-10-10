package com.ce.lab11mail.controller;

import com.ce.lab11mail.service.MailService;
import com.ce.lab11mail.vo.MailVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author c__e
 * @date Created in 2020/10/10 18:18
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private MailService service;

    @PostMapping("/action")
    public String action(String author, String email, String text, MultipartFile file) {
        MailVo mailVo = new MailVo();
        mailVo.setFrom("an37500@163.com");
        mailVo.setTo("cije1998@gmail.com");
        mailVo.setSubject("收到[" + author + "]发送的邮件，邮箱为：" + email);
        mailVo.setText(text);
        mailVo.setMultipartFiles(new MultipartFile[]{file});
        return service.send(mailVo).getStatus();
    }

}
