package com.socialLogin.back.model;

import lombok.*;

/**
 * Kakao에서 보내는 유저 정보를 매핑하는 클래스
 */
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class KaKaoLoginResponse {

    private String id;

    @Builder.Default
    private KakaoLoginData kakao_account = KakaoLoginData.builder().build();

    @Builder
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @ToString
    public static class KakaoLoginData {

        @Builder.Default
        private KakaoProfile profile = KakaoProfile.builder().build();

        @Builder.Default
        private KakaoPropery properties = KakaoPropery.builder().build();

        @Builder
        @Data
        @NoArgsConstructor
        @AllArgsConstructor
        @ToString
        public static class KakaoProfile {
            private String nickname;
        }

        @Builder
        @Data
        @NoArgsConstructor
        @AllArgsConstructor
        @ToString
        public static class KakaoPropery {
            private String nickname;
        }
    }
}
