package com.ce.lab601.message;

/**
 * @author c__e
 * @date Created in 2020/9/26 9:41
 */
public class SendToAllRequest implements Message {

    public static final String TYPE = "SEND_TO_ALL_REQUEST";

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

    public SendToAllRequest setMsgId(String msgId) {
        this.msgId = msgId;
        return this;
    }

    public String getContent() {
        return content;
    }

    public SendToAllRequest setContent(String content) {
        this.content = content;
        return this;
    }
}