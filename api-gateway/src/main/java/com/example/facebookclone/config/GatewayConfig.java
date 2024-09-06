package com.example.facebookclone.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.example.facebookclone.filter.JwtAuthenticationFilter;
@Configuration
public class GatewayConfig {

//    @Autowired
//    private  JwtAuthenticationFilter filter;

//    public GatewayConfig(JwtAuthenticationFilter filter) {
//        this.filter = filter;
//    }
//


    @Bean
    public RouteLocator routes(RouteLocatorBuilder builder) {
        return builder.routes()

                .route("auth-service",p -> p
                        .path("/auth-service/authcontroller/**")
                        .filters(f -> f
                                        .filter(new JwtAuthenticationFilter()) // You can add more filters here.
                                        .stripPrefix(1)
                        )
                        .uri("lb://auth-service"))

                .route("user",p -> p
                        .path("/user/users/**")
                        .filters(f -> f
                                .filter(new JwtAuthenticationFilter()) // You can add more filters here.
                                .stripPrefix(1)
                        )
                        .uri("lb://user"))

                .route("comments",p -> p
                        .path("/comments/comments/**")
                        .filters(f -> f
                                .filter(new JwtAuthenticationFilter()) // You can add more filters here.
                                .stripPrefix(1)
                        )
                        .uri("lb://comments"))



//
//         .route("user", r -> r.path("/users/**")
//                        .filters(f -> f.filter(new JwtAuthenticationFilter()))
//                        .uri("lb://user"))



//                .route("comments", r -> r.path("/comments/**")
//                        .filters(f -> f.filter(filter))
//                        .uri("lb://comments"))
//
//                .route("posts", r -> r.path("/posts/**")
//                        .filters(f -> f.filter(filter))
//                        .uri("lb://posts"))
//



//
//                .route("comments-service", r -> r.path("/comments/**")
//                        .filters(f -> f.stripPrefix(1) // Equivalent to StripPrefix=1
//
//                                .filter(new JwtAuthenticationFilter()) // Add your custom GatewayFilter
//                        )
//                        .uri("lb://comments")) // Load balancer URI pointing to the 'comments' service
//



//                .route("file-storage", r -> r.path("/v1/file-storage/**")
//                        .filters(f -> f.filter(filter))
//                        .uri("lb://file-storage"))
//
                .build();
    }
}