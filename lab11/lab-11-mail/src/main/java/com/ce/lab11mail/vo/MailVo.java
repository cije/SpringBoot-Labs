package com.ce.lab11mail.vo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.web.multipart.MultipartFile;

import java.util.Arrays;
import java.util.Date;

/**
 * @author c__e
 * @date Created in 2020/10/10 16:21
 */
public class MailVo {
    /**
     * 邮件id
     */
    private String id;
    /**
     * 邮件发送人
     */
    private String from;
    /**
     * 邮件接收人
     */
    private String to;
    /**
     * 邮件主题
     */
    private String subject;
    /**
     * 邮件内容
     */
    private String text;
    /**
     * 发送时间
     */
    private Date sentDate;
    /**
     * 抄送
     */
    private String cc;
    /**
     * 密送
     */
    private String bcc;
    /**
     * 状态
     */
    private String status;
    /**
     * 报错信息
     */
    private String error;
    /**
     * 邮件附件
     */
    @JsonIgnore
    private MultipartFile[] multipartFiles;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getSentDate() {
        return sentDate;
    }

    public void setSentDate(Date sentDate) {
        this.sentDate = sentDate;
    }

    public String getCc() {
        return cc;
    }

    public void setCc(String cc) {
        this.cc = cc;
    }

    public String getBcc() {
        return bcc;
    }

    public void setBcc(String bcc) {
        this.bcc = bcc;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public MultipartFile[] getMultipartFiles() {
        return multipartFiles;
    }

    public void setMultipartFiles(MultipartFile[] multipartFiles) {
        this.multipartFiles = multipartFiles;
    }

    @Override
    public String toString() {
        return "MailVo{" +
                "id='" + id + '\'' +
                ", from='" + from + '\'' +
                ", to='" + to + '\'' +
                ", subject='" + subject + '\'' +
                ", text='" + text + '\'' +
                ", sentDate=" + sentDate +
                ", cc='" + cc + '\'' +
                ", bcc='" + bcc + '\'' +
                ", status='" + status + '\'' +
                ", error='" + error + '\'' +
                ", multipartFiles=" + Arrays.toString(multipartFiles) +
                '}';
    }
}
