package com.socialLogin.back.config;

import org.springframework.cloud.openfeign.FeignFormatterRegistrar;
import org.springframework.context.annotation.Bean;
import org.springframework.format.datetime.standard.DateTimeFormatterRegistrar;

/**
 * openfeign :
 * 넷플릿스에 만들어진 Declarative(선언적인) HTTP Client 도구
 * restTemplate 보다 간편하게 외부 API 호출
 * BackApplication에 @EnableFeignClients 어노테이션 필요
 */
public class FeignConfig {
    @Bean
    public FeignFormatterRegistrar localDateFormatter () {
        return registry -> {
            DateTimeFormatterRegistrar registrar = new DateTimeFormatterRegistrar();
            registrar.setUseIsoFormat(true);
            registrar.registerFormatters(registry);
        };
    }
}
