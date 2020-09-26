package com.ce.lab601.message;

/**
 * @author c__e
 * @date Created in 2020/9/26 9:40
 */
public class SendToOneRequest implements Message {

    public static final String TYPE = "SEND_TO_ONE_REQUEST";

    /**
     * 发送给的用户
     */
    private String toUser;
    /**
     * 消息编号
     */
    private String msgId;
    /**
     * 内容
     */
    private String content;

    public static String getTYPE() {
        return TYPE;
    }

    public String getToUser() {
        return toUser;
    }

    public SendToOneRequest setToUser(String toUser) {
        this.toUser = toUser;
        return this;
    }

    public String getMsgId() {
        return msgId;
    }

    public SendToOneRequest setMsgId(String msgId) {
        this.msgId = msgId;
        return this;
    }

    public String getContent() {
        return content;
    }

    public SendToOneRequest setContent(String content) {
        this.content = content;
        return this;
    }
}