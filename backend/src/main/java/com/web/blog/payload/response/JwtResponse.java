package com.web.blog.payload.response;

import java.util.List;

public class JwtResponse {
    private String accessToken;
    private String type = "Bearer";
    private Long id;
    private String nickname;
    private String email;
    private List<String> roles;

    public JwtResponse(String accessToken, Long id, String nickname, String email, List<String> roles) {
        this.accessToken = accessToken;
        this.id = id;
        this.nickname = nickname;
        this.email = email;
        this.roles = roles;
    }

    public String getAccessToken() { return accessToken; }
    public void setAccessToken(String accessToken) { this.accessToken = accessToken; }

    public String getTokenType() { return type; }
    public void setTokenType(String tokenType) { this.type = tokenType; }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getNickname() { return nickname; }
    public void setNickname(String nickname) { this.nickname = nickname; }

    public List<String> getRoles() { return roles; }
}
