package com.socialLogin.back.model;

import lombok.*;

/**
 * 사용할 유저 정보를 담는 클래스
 */
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
public class SocialUserResponse {
    private String id;
    private String name;
}
