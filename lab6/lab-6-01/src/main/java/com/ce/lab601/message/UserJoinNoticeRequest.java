package com.ce.lab601.message;

/**
 * @author c__e
 * @date Created in 2020/9/26 9:40
 */
public class UserJoinNoticeRequest implements Message {

    public static final String TYPE = "USER_JOIN_NOTICE_REQUEST";

    /**
     * 昵称
     */
    private String nickname;

    public static String getTYPE() {
        return TYPE;
    }

    public String getNickname() {
        return nickname;
    }

    public UserJoinNoticeRequest setNickname(String nickname) {
        this.nickname = nickname;
        return this;
    }
}