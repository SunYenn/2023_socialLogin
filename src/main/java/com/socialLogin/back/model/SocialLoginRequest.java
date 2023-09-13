package com.socialLogin.back.model;

import lombok.Getter;
import lombok.ToString;

import javax.validation.constraints.NotNull;

/**
 * Frontend에서 axios 요청 보내는 userType과 code를 매핑할 클래스
 */
@Getter
@ToString
public class SocialLoginRequest {
    @NotNull
    private UserType userType;
    @NotNull
    private String code;
}
