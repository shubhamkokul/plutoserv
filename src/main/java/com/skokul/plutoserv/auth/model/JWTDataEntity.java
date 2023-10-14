package com.skokul.plutoserv.auth.model;

public class JWTDataEntity {
    private String email;
    private String userId;

    public JWTDataEntity(String email, String userId) {
        this.email = email;
        this.userId = userId;
    }

    public String getEmail() {
        return email;
    }

    public String getUserId() {
        return userId;
    }
}
