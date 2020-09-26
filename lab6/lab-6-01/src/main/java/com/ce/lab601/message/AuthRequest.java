package com.ce.lab601.message;

/**
 * @author c__e
 * @date Created in 2020/9/26 9:36
 */
public class AuthRequest implements Message {
    public static final String TYPE = "AUTH_REQUEST";

    /**
     * 认证 Token
     */
    private String accessToken;

    public static String getTYPE() {
        return TYPE;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public AuthRequest setAccessToken(String accessToken) {
        this.accessToken = accessToken;
        return this;
    }
}
