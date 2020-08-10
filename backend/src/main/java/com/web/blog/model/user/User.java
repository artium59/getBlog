package com.web.blog.model.user;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@Table(	name = "users",
        uniqueConstraints = { 
            @UniqueConstraint(columnNames = "email") 
        })
//NON_NULL 사용시 parameter가 null인 경우에 제외
@JsonInclude(JsonInclude.Include.NON_NULL)
public class User {
    @Id
    // 기본 키 생성을 데이터베이스에 위임하는 방식
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long uid;

    @NotBlank
    @Size(max = 20)
    private String nickname;

    @NotBlank
    @Size(max = 50)
    @Email
    private String email;

    @Column(nullable = false)
    private Boolean emailVerified = false;

    private String imageUrl;

    String introduce;

    @JsonIgnore
    // @NotBlank
    @Size(max = 120)
    private String password;

    // @NotBlank
    @Enumerated(EnumType.STRING)
    private EAuthProvider provider;

    // https://dzone.com/articles/why-set-is-better-than-list-in-manytomany
    @ManyToMany(fetch = FetchType.EAGER, cascade = { CascadeType.ALL })
    @JoinTable(	name = "user_roles",
                joinColumns = @JoinColumn(name = "user_id"), 
                inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();

    public User() {}

    public User(String nickname, String email, String password) {
        this.nickname = nickname;
        this.email = email;
        this.password = password;
        this.provider = EAuthProvider.local;
    }

    @Builder
    public User(Long uid, String nickname, String password) {
        this.uid = uid;
        this.nickname = nickname;
        this.password = password;
        this.provider = EAuthProvider.local;
    }

    public void setUid(String uid) { this.uid = Long.parseLong(uid); }
}
