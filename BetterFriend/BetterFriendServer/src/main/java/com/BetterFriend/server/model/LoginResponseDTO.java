package com.BetterFriend.server.model;

public class LoginResponseDTO {
    private String token;
    private User user;

    public LoginResponseDTO(String token, User user) {
        this.token = token;
        this.user = user;
    }

    public String getToken() {
        return token;
    }

    void setToken(String token) {
        this.token = token;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
