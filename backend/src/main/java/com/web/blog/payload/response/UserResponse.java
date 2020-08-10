package com.web.blog.payload.response;

import com.web.blog.model.user.User;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserResponse {

    private String email;
    private String nickname;
    private String introduce;
    private String imageUrl;

    public UserResponse(User user) {
        this.email = user.getEmail();
        this.nickname = user.getNickname();
        this.introduce = user.getIntroduce();
        this.imageUrl = user.getImageUrl();
    }

    @Builder
    public UserResponse(String email, String nickname, String introduce, String imageUrl) {
        this.email = email;
        this.nickname = nickname;
        this.introduce = introduce;
        this.imageUrl = imageUrl;
    }
}
