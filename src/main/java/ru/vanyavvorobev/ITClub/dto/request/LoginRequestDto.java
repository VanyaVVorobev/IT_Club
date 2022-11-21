package ru.vanyavvorobev.ITClub.dto.request;

import com.fasterxml.jackson.annotation.JsonIgnore;
import ru.vanyavvorobev.ITClub.dto.old.LoginRequest;

public class LoginRequestDto {

    private String login;
    private String password;

    public LoginRequestDto() {}
    public LoginRequestDto(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
