package com.socialLogin.back.service;

import com.socialLogin.back.model.SocialAuthResponse;
import com.socialLogin.back.model.SocialLoginRequest;
import com.socialLogin.back.model.SocialUserResponse;
import com.socialLogin.back.model.UserType;
import com.socialLogin.back.service.loginServices.NormalLoginServiceImpl;
import com.socialLogin.back.service.loginServices.SocialLoginService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {

    // SocialLoginService 인터페이스를 상송받아 메소드를 구현하는 클래스의 인스턴스 목록
    private final List<SocialLoginService> loginServices;

    /**
     * 유저 정보 얻어오는 로그인 과정
     */
    public SocialUserResponse doSocialLogin(SocialLoginRequest request) {

        SocialLoginService loginService = this.getLoginService(request.getUserType());

        SocialAuthResponse socialAuthResponse = loginService.getAccessToken(request.getCode());

        SocialUserResponse socialUserResponse = loginService.getUserInfo(socialAuthResponse.getAccess_token());

        return socialUserResponse;
    }

    // SocialLoginService 구현부 중 하나를 리턴받아 사용할 수 있도록 하는 메소드
    private SocialLoginService getLoginService(UserType userType){
        for (SocialLoginService loginService: loginServices) {
            if (userType.equals(loginService.getServiceName())) {
                log.info("login service name: {}", loginService.getServiceName());
                return loginService;
            }
        }
        return new NormalLoginServiceImpl();
    }
}
