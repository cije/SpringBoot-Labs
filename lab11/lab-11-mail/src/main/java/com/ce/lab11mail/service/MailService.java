package com.ce.lab11mail.service;

import com.ce.lab11mail.vo.MailVo;

/**
 * @author c__e
 * @date Created in 2020/10/10 16:19
 */
public interface MailService {
    /**
     * 发送邮件
     */
    MailVo send(MailVo mailVo);
}
