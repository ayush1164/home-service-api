package com.homeservices.booking.dto.user.request;

public class ChangePasswordRequest {

    private String password;

    public ChangePasswordRequest() {
    }

    public ChangePasswordRequest(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
