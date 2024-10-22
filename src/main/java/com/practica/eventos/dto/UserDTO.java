package com.practica.eventos.dto;

import java.time.LocalDateTime;

public class UserDTO {
    private String username;
    private String email;
    private String password;
    private LocalDateTime createTime;
    private String perito;

    // Getters and Setters
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public String getPerito() {
        return perito;
    }

    public void setPerito(String perito) {
        this.perito = perito;
    }
}
