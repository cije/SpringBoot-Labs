package com.ce.lab601.message;

/**
 * @author c__e
 * @date Created in 2020/9/26 9:43
 */
public class SendToUserRequest implements Message {

    public static final String TYPE = "SEND_TO_USER_REQUEST";

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

    public String getMsgId() {
        return msgId;
    }

    public SendToUserRequest setMsgId(String msgId) {
        this.msgId = msgId;
        return this;
    }

    public String getContent() {
        return content;
    }

    public SendToUserRequest setContent(String content) {
        this.content = content;
        return this;
    }
}
