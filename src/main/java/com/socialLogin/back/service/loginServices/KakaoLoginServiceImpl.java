package com.socialLogin.back.service.loginServices;

import com.google.gson.Gson;
import com.socialLogin.back.feign.KaKaoUserApi;
import com.socialLogin.back.feign.KakaoAuthApi;
import com.socialLogin.back.model.KaKaoLoginResponse;
import com.socialLogin.back.model.SocialAuthResponse;
import com.socialLogin.back.model.SocialUserResponse;
import com.socialLogin.back.model.UserType;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * UserType이 KAKAO일 때 사용하는 구현부
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class KakaoLoginServiceImpl implements SocialLoginService {

    private final KakaoAuthApi kakaoAuthApi;
    private final KaKaoUserApi kakaoUserApi;

    @Value("${social.client.kakao.rest-api-key}")
    private String kakaoAppKey;

    @Value("${social.client.kakao.redirect-uri}")
    private String kakaoRedirectUri;

    @Value("${social.client.kakao.grant-type}")
    private String kakaoGrantType;

    @Override
    public UserType getServiceName() {
        return UserType.KAKAO;
    }

    @Override
    public SocialAuthResponse getAccessToken(String authorizationCode) {
        ResponseEntity<?> response = kakaoAuthApi.getAccessToken(
                kakaoAppKey,
                kakaoGrantType,
                kakaoRedirectUri,
                authorizationCode
        );

        return new Gson()
                .fromJson(
                        String.valueOf(response.getBody())
                        , SocialAuthResponse.class
                );
    }

    @Override
    public SocialUserResponse getUserInfo(String accessToken) {
        Map<String ,String> headerMap = new HashMap<>();
        headerMap.put("authorization", "Bearer " + accessToken);

        KaKaoLoginResponse kaKaoLoginResponse = kakaoUserApi.getUserInfo(headerMap);

        KaKaoLoginResponse.KakaoLoginData kakaoLoginData = Optional.ofNullable(kaKaoLoginResponse.getKakao_account())
                .orElse(KaKaoLoginResponse.KakaoLoginData.builder().build());

        log.info("kaKaoLoginResponse : {}", kaKaoLoginResponse);

        String name = Optional.ofNullable(kakaoLoginData.getProfile())
                .orElse(KaKaoLoginResponse.KakaoLoginData.KakaoProfile.builder().build())
                .getNickname();

        return SocialUserResponse.builder()
                .id(kaKaoLoginResponse.getId())
                .name(name)
                .build();
    }
}
