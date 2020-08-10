package com.web.blog.model.user;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonInclude;

@Entity
@Data
@Table(name = "roles")
//NON_NULL 사용시 parameter가 null인 경우에 제외
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Role {
    @Id
    // 기본 키 생성을 데이터베이스에 위임하는 방식
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private ERole name;

    public Role() {}

	public Role (ERole name) {
		this.name = name;
	}
}
