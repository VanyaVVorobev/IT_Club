package ru.vanyavvorobev.ITClub.dto;

import java.util.Set;

public class SignupRequest {
    private String password;
    private String username;
    private String login;
    private Set<String> role;

    public SignupRequest() {}
    public SignupRequest(String password, String username, String login, Set<String> role) {
        this.password = password;
        this.username = username;
        this.login = login;
        this.role = role;
    }

    public Set<String> getRole() {
        return role;
    }

    public void setRole(Set<String> role) {
        this.role = role;
    }

    public String getPassword() {
        return password;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
