package com.example.facebookclone.fiegnconfiguration;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
@Configuration
public class FeignConfig implements RequestInterceptor {

    private static final String AUTHORIZATION_HEADER = "Authorization";



    @Override
    public void apply(RequestTemplate requestTemplate) {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        System.out.println(" this is FiegnConfig intercepter 1");
        if (attributes != null) {
            HttpServletRequest request = attributes.getRequest();
            System.out.println(" this is FiegnConfig intercepter 2");
            if (request != null) {
                String authorization = request.getHeader(AUTHORIZATION_HEADER);
                System.out.println(" this is FiegnConfig intercepter 3 " +authorization);
                if (authorization != null) {
                    System.out.println(" this is FiegnConfig intercepter 4 " +authorization);
                    requestTemplate.header(AUTHORIZATION_HEADER, authorization);
                }
            }
        }
    }


//    @Bean
//    public RequestInterceptor requestInterceptor() {
//        return requestTemplate -> {
//            System.out.println(" this is FiegnConfig intercepter ");
//
//            // Fetch the token from the security context
//            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//            if (authentication != null && authentication.getCredentials() instanceof String) {
//                String token = (String) authentication.getCredentials();
//                System.out.println(" requestInterceptor " + token);
//                requestTemplate.header("Authorization", "Bearer " + token);
//            }
//        };
//    }
}