package com.skokul.plutoserv.auth.model;

import java.util.UUID;

public class AccessTokenProcess extends AccessTokenArgument {
    private UUID userId;

    public AccessTokenProcess(UUID userId) {
        this.userId = userId;
    }

    public AccessTokenProcess(String email, UUID userId) {
        super(email);
        this.userId = userId;
    }

    public UUID getUserId() {
        return userId;
    }

    @Override
    public String toString() {
        return "AccessTokenRoot [Email=" + getEmail() + ", UserId=" + userId + "]";
    }
}
