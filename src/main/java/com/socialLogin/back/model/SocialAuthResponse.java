package com.socialLogin.back.model;

import lombok.*;

/**
 * 토큰, 토큰 만료 기간 등 기타 내용을 매핑할 클래스
 */
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
public class SocialAuthResponse {
    private String access_token;
    private String token_type;
    private String refresh_token;
    private String expires_in;
    private String scope;
    private String refresh_token_expires_in;
}
