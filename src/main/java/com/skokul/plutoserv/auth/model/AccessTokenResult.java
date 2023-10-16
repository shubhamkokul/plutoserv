package com.skokul.plutoserv.auth.model;

import java.util.UUID;

public class AccessTokenResult extends AccessTokenProcess {
    private String accessToken;

    public AccessTokenResult(String email, UUID userId, String accessToken) {
        super(email, userId);
        this.accessToken = accessToken;
    }

    public String getAccessToken() {
        return accessToken;
    }

    @Override
    public String toString() {
        return "AccessTokenResult [AccessToken=" + accessToken + ", Email=" + getEmail() + ", UserId="
                + getUserId() + "]";
    }
}
