package com.web.blog.payload.request;

import javax.validation.constraints.NotBlank;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserRequest {

    @NotBlank
    private String accessToken;

    @NotBlank
    private String nickname;

    @NotBlank
    private String password;

    private String introduce;
    private String imageUrl;
}
