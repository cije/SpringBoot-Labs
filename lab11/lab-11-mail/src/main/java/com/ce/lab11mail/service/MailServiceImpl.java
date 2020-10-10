package com.ce.lab11mail.service;

import com.ce.lab11mail.vo.MailVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.Objects;

/**
 * @author c__e
 * @date Created in 2020/10/10 16:17
 */
@Service
public class MailServiceImpl implements MailService {

    @Autowired
    private JavaMailSenderImpl mailSender;

    @Async
    @Override
    public MailVo send(MailVo mailVo) {
        try {
            // 1.检测邮件
            checkMail(mailVo);
            // 2. 发送邮件
            sendMineMail(mailVo);
            // 3. 保存邮件
            return save(mailVo);
        } catch (Exception e) {
            mailVo.setStatus("fail");
            mailVo.setError(e.getMessage());
            return mailVo;
        }
    }

    /**
     * 检测邮件信息
     */
    private void checkMail(MailVo mailVo) {
        if (StringUtils.isEmpty(mailVo.getTo())) {
            throw new RuntimeException("邮件收信人不能为空");
        }
        if (StringUtils.isEmpty(mailVo.getSubject())) {
            throw new RuntimeException("邮件主题不能为空");
        }
        if (StringUtils.isEmpty(mailVo.getText())) {
            throw new RuntimeException("邮件内容不能为空");
        }
    }

    /**
     * 构建复杂邮件信息
     */
    private void sendMineMail(MailVo mailVo) {
        try {
            MimeMessageHelper messageHelper = new MimeMessageHelper(mailSender.createMimeMessage(), true);
            // 邮件发信人从配置项读取
            // mailVo.setFrom(getMailSendFrom());
            //邮件发信人
            messageHelper.setFrom(mailVo.getFrom());
            // 邮件收信人
            messageHelper.setTo(mailVo.getTo().split(","));
            // 邮件主题
            messageHelper.setSubject(mailVo.getSubject());
            // 邮件内容
            messageHelper.setText(mailVo.getText());
            //抄送
            if (!StringUtils.isEmpty(mailVo.getCc())) {
                messageHelper.setCc(mailVo.getCc().split(","));
            }
            //密送
            if (!StringUtils.isEmpty(mailVo.getBcc())) {
                messageHelper.setBcc(mailVo.getBcc().split(","));
            }
            // 添加邮件附件
            if (mailVo.getMultipartFiles() != null) {
                for (MultipartFile multipartFile : mailVo.getMultipartFiles()) {
                    messageHelper.addAttachment(Objects.requireNonNull(multipartFile.getOriginalFilename()), multipartFile);
                }
            }
            // 发送时间
            if (StringUtils.isEmpty(mailVo.getSentDate())) {
                mailVo.setSentDate(new Date());
                messageHelper.setSentDate(mailVo.getSentDate());
            }
            // 正式发送邮件
            mailSender.send(messageHelper.getMimeMessage());
            mailVo.setStatus("ok");

        } catch (Exception e) {
            //发送失败
            throw new RuntimeException(e);
        }
    }

    /**
     * 保存邮件
     */
    private MailVo save(MailVo mailVo) {
        // 保存邮件到数据库
        return mailVo;
    }

    /**
     * 获取邮件发信人
     */
    public String getMailSendFrom() {
        return mailSender.getJavaMailProperties().getProperty("from");
    }

}
