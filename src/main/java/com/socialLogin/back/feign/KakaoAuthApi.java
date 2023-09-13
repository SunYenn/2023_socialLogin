package com.socialLogin.back.feign;

import com.socialLogin.back.config.FeignConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

// code를 보내 token을 반환받는 Kakao API
@FeignClient(value = "kakaoAuth", url = "https://kauth.kakao.com", configuration = {FeignConfig.class})
public interface KakaoAuthApi {
    @GetMapping("/oauth/token")
    ResponseEntity<String> getAccessToken(
            @RequestParam("client_id") String clientId,
            @RequestParam("grant_type") String grantType,
            @RequestParam("redirect_uri") String redirectUri,
            @RequestParam("code") String authorizationCode
    );
}
