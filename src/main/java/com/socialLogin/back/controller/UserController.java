package com.socialLogin.back.controller;

import com.socialLogin.back.model.SocialLoginRequest;
import com.socialLogin.back.model.SocialUserResponse;
import com.socialLogin.back.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.net.URI;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user")
public class UserController {

    private final UserService userService;

    // Frontend에서 axios 요청받는 API (파라미터 : UserType, code)
    @RequestMapping ("/social-login")
    public ResponseEntity<SocialUserResponse> doSocialLogin(@RequestBody @Valid SocialLoginRequest request) {

        return ResponseEntity.created(URI.create("/social-login"))
                .body(userService.doSocialLogin(request));

    }

}
