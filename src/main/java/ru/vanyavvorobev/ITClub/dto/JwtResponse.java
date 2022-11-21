package ru.vanyavvorobev.ITClub.dto;

import java.util.List;

public class JwtResponse {
    private String token;
    private String type = "Bearer";
    private String uuid;
    private String username;
    private String login;
    private List<String> roles;

    public JwtResponse() {}

    public JwtResponse(String token, String uuid, String username, String login, List<String> roles) {
        this.token = token;
        this.uuid = uuid;
        this.username = username;
        this.login = login;
        this.roles = roles;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }
}
