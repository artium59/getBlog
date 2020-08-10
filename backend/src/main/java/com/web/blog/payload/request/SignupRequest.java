package com.web.blog.payload.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.ToString;

import java.util.Set;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Valid
@ToString
public class SignupRequest {
    @ApiModelProperty(required = true)
    @Email
    @NotNull
    String email;

    @ApiModelProperty(required = true)
    @NotNull
    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d$@$!%*#?&]{8,}$")
    String password;

    @ApiModelProperty(required = true)
    @NotNull
    String nickname;

    // private Set<String> role;

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getNickname() { return nickname; }
    public void setNickname(String nickname) { this.nickname = nickname; }

    // public Set<String> getRole() { return this.role; }
    // public void setRole(Set<String> role) { this.role = role; }
}
