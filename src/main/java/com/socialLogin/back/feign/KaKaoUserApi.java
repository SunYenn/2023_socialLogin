package com.socialLogin.back.feign;

import com.socialLogin.back.config.FeignConfig;
import com.socialLogin.back.model.KaKaoLoginResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

import java.util.Map;

/**
 * https://kapi.kakao.com 에 API요청 보내는 인터페이스
 */
@FeignClient(value = "kakaoUser", url = "https://kapi.kakao.com", configuration = {FeignConfig.class})
public interface KaKaoUserApi {

    /**
     * @param header key("authorization") value(토큰)
     * @return 유저 정보
     */
    @GetMapping("/v2/user/me")
    KaKaoLoginResponse getUserInfo(@RequestHeader Map<String, String> header);
}
