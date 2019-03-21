package com.jsq.token;

public class Token {

    private String accessToken;

    private int expires_in;

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public int getExpires_in() {
        return expires_in;
    }

    public void setExpires_in(int expiresin) {
        this.expires_in = expiresin;
    }
}
