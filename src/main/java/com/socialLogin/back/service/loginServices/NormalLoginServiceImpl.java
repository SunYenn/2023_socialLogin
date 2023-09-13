package com.socialLogin.back.service.loginServices;

import com.socialLogin.back.model.SocialAuthResponse;
import com.socialLogin.back.model.SocialUserResponse;
import com.socialLogin.back.model.UserType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * UserType이 NORMAL인 일반 계정 로그인 구현부
 */
@Slf4j
@Service
@Component
public class NormalLoginServiceImpl implements SocialLoginService {
    @Override
    public UserType getServiceName() { return UserType.NORMAL; }

    @Override
    public SocialAuthResponse getAccessToken(String authorizationCode) { return null; }

    @Override
    public SocialUserResponse getUserInfo(String accessToken) {
        return null;
    }
}
