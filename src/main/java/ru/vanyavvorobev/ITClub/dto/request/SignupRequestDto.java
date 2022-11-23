package ru.vanyavvorobev.ITClub.dto.request;

public class SignupRequestDto {

    private String Username;
    private String login;
    private String password;

    public SignupRequestDto(String username, String login, String password) {
        Username = username;
        this.login = login;
        this.password = password;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
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
