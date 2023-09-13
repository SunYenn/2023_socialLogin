package com.socialLogin.back.service.loginServices;

import com.socialLogin.back.model.SocialAuthResponse;
import com.socialLogin.back.model.SocialUserResponse;
import com.socialLogin.back.model.UserType;
import org.springframework.stereotype.Service;

/**
 * UserType별로 구현받아 사용할 수 있도록 추상 메소드들을 정의하는 인터페이스
 */
@Service
public interface
SocialLoginService {

    /**
     * 해당 구현부에서 정의하고 있는 UserType 반환하는 메소드
     * 이후 어떤 구현부를 사용할지 판단하기 위해 Frontend에서 보내는 userType과 대조
     */
    UserType getServiceName();

    /**
     * code로 social API에서 토큰 받아오는 메소드
     */
    SocialAuthResponse getAccessToken(String authorizationCode);

    /**
     * token을 social API로 보내 유저 정보 반환하는 메소드
     */
    SocialUserResponse getUserInfo(String accessToken);
}
