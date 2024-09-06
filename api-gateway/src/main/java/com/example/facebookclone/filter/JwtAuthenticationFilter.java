package com.example.facebookclone.filter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;
import java.util.function.Predicate;
import com.example.facebookclone.jwtUtil.JwtUtil;
///@Component
public class JwtAuthenticationFilter implements GatewayFilter {
    private static final Logger LOG = LoggerFactory.getLogger(JwtAuthenticationFilter.class);

    @Autowired
    private  JwtUtil jwtUtil;
//
//    public JwtAuthenticationFilter(JwtUtil jwtUtil) {
//        this.jwtUtil = jwtUtil;
//    }

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {

        System.out.println("  this is api gateway -----------------------------  filter ");
        System.out.println("  this is api gateway -----------------------------  filter ");
        System.out.println("  this is api gateway -----------------------------  filter ");


        LOG.info("JwtAuthenticationFilter::::::::  ------------------- " +
                " Checking the request...");
        ServerHttpRequest request = exchange.getRequest();

        final List<String> apiEndpoints = List.of("/auth-service/authcontroller/login",
                "/auth-service/authcontroller/register", "/eureka");

        Predicate<ServerHttpRequest> isApiSecured = r -> apiEndpoints.stream()
                .noneMatch(uri -> r.getURI().getPath().contains(uri));

        if (isApiSecured.test(request)) {
            System.out.println("  this is api gateway -----------------------------  filter  if if 1 ");
            if (authMissing(request)) return onError(exchange);

            String token = request.getHeaders().getOrEmpty("Authorization").get(0);

            if (token != null && token.startsWith("Bearer "))
                token = token.substring(7);

            try {
                System.out.println( token+ "  this is api gateway ----------  just before validation token  ");
                 new JwtUtil().validateToken(token);
             ////   jwtUtil.validateToken(token);
                System.out.println( token+ "  this is api gateway ----------  just after validation token  ");

            } catch (Exception e) {
           System.out.println("  this is exception ");
                return onError(exchange);
            }
        }
        System.out.println("  this is api gateway -----------------------------  filter  if if 2 ");
        return chain.filter(exchange);
    }

    private Mono<Void> onError(ServerWebExchange exchange) {
        System.out.println(" this is on Error -------------------------------  ");
        ServerHttpResponse response = exchange.getResponse();
        response.setStatusCode(HttpStatus.UNAUTHORIZED);
        return response.setComplete();
    }

    private boolean authMissing(ServerHttpRequest request) {

               return !request.getHeaders().containsKey("Authorization");
    }
}