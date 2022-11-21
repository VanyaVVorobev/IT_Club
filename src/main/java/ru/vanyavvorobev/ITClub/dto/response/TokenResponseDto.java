package ru.vanyavvorobev.ITClub.dto.response;

public class TokenResponseDto {

    private final String tokenType = "Bearer";
    private String token;

    public TokenResponseDto() {}
    public TokenResponseDto(String token) {
        this.token = token;
    }

    public String getTokenType() {
        return tokenType;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
