package com.example.facebookclone.config;

//import com.example.facebookclone.filter.JwtAuthenticationFilter;
//import lombok.RequiredArgsConstructor;
//import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpMethod;
//import org.springframework.lang.NonNull;

//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.config.Customizer;
//import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
//import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
//import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//import org.springframework.security.web.servlet.util.matcher.MvcRequestMatcher;
//import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

//import org.springframework.web.servlet.config.annotation.CorsRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//import org.springframework.web.servlet.handler.HandlerMappingIntrospector;

//@Configuration
//@EnableWebSecurity
//@EnableGlobalMethodSecurity(prePostEnabled = true)
//@RequiredArgsConstructor

public class SecurityConfig {
   /// private final JwtAuthenticationFilter jwtAuthenticationFilter;

//////////////////////////////////////////////

/*
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        // Initialize HandlerMappingIntrospector for MvcRequestMatcher
        HandlerMappingIntrospector introspector = new HandlerMappingIntrospector();

        // Define MvcRequestMatcher for Spring MVC endpoints
        MvcRequestMatcher registerMatcher = new MvcRequestMatcher(introspector, "/users/register");

        // Define AntPathRequestMatcher for non-MVC endpoints (like H2 console)
        AntPathRequestMatcher h2ConsoleMatcher = new AntPathRequestMatcher("/h2-console/**");

        http
                .csrf(csrf -> csrf
                        .ignoringRequestMatchers(h2ConsoleMatcher) // Disable CSRF protection for H2 console
                )
                .authorizeHttpRequests(authz -> authz
                        // Permit all access to the H2 console using AntPathRequestMatcher
                        .requestMatchers(h2ConsoleMatcher).permitAll()
                        // Permit all access to the register endpoint using MvcRequestMatcher
                        .requestMatchers(registerMatcher).permitAll()
                        .requestMatchers("/users/userCreate" ). permitAll()
                        .requestMatchers("/users/getUserByUsername").permitAll()
                        // Secure all other endpoints
                        .anyRequest().authenticated()
                )
                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)

                .headers(headers -> headers
                        .frameOptions(frameOptions -> frameOptions.sameOrigin()) // Allows H2 console in a frame
                );

        return http.build();
    }
*/
//@Bean
//public WebSecurityCustomizer webSecurityCustomizer() {
//    return (web) -> web.ignoring().
//            requestMatchers(new AntPathRequestMatcher("/h2-console/**"))
//            .requestMatchers(new AntPathRequestMatcher( "/favicon.ico"))
//            .requestMatchers(new AntPathRequestMatcher( "/css/**"))
//            .requestMatchers(new AntPathRequestMatcher( "/js/**"))
//            .requestMatchers(new AntPathRequestMatcher( "/img/**"))
//            .requestMatchers(new AntPathRequestMatcher( "/lib/**"));
//}

/*
    @Bean
    protected SecurityFilterChain filterChain(HttpSecurity http, HandlerMappingIntrospector introspector) throws Exception {

        // Create MvcRequestMatcher with HTTP method specification
        MvcRequestMatcher.Builder mvcMatcherBuilder = new MvcRequestMatcher.Builder(introspector);

//
//        MvcRequestMatcher createMatcher = mvcMatcherBuilder
//                .servletPath("")
//                .pattern("/users/userCreate")
//                .method("POST")
//                .build();
//
//        MvcRequestMatcher getUserMatcher = mvcMatcherBuilder
//                .servletPath("")
//                .pattern("/users/getUserByUsername/**")
//                .method("GET")
//                .build();



        /*
        MvcRequestMatcher s =   new MvcRequestMatcher(introspector, "/users/userCreate");
        s.setMethod(HttpMethod.POST);
        http.   authorizeHttpRequests(authorize ->
                        authorize.  ////"/")

                                requestMatchers(s )
                                .permitAll().
        requestMatchers(new MvcRequestMatcher(introspector, "/users/getUserByUsername/**")        )
                                .permitAll()
                                .anyRequest().authenticated())
                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
                .httpBasic(Customizer.withDefaults());
        return http.build();


        MvcRequestMatcher postMatcher = new MvcRequestMatcher(introspector
                , "/users/userCreate");
        postMatcher.setMethod(HttpMethod.POST);

        http
                .authorizeHttpRequests(authorize ->
                        authorize
//                                .requestMatchers(postMatcher).permitAll()  // Allow POST requests to /users/userCreate
//                                .anyRequest().authenticated()  // All other requests must be authenticated
                                .anyRequest().permitAll()

                )
                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)

        ;  // Disable CSRF protection if using for APIs

        return http.build();
}

    /*

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        // HandlerMappingIntrospector is required for MvcRequestMatcher to work properly
        HandlerMappingIntrospector introspector = new HandlerMappingIntrospector();

        // Set up MvcRequestMatcher for the main Spring MVC servlet
        MvcRequestMatcher h2ConsoleMatcher = new MvcRequestMatcher(introspector, "/h2-console/**");
        h2ConsoleMatcher.setServletPath("/h2-console");
        http.authorizeHttpRequests(
                (authz) -> authz
                        .requestMatchers(h2ConsoleMatcher).permitAll()
                        //userCreate
                        .requestMatchers("/users/userCreate" )

                        . permitAll()
                        .requestMatchers("/users/getUserByUsername")
                        // Require authentication for all other requests
                        .permitAll()
                        .anyRequest().authenticated()
        )
                .headers(headers -> headers
                        .frameOptions(frameOptions -> frameOptions.sameOrigin()) // Allows H2 console to be displayed in a frame
                )
                  .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
       ;  //  .build();
        //      .requestMatchers(HttpMethod.GET)
        //    .permitAll()
        //  .requestMatchers(HttpMethod.PUT)
        //  .hasAuthority(USER)
        //   .requestMatchers(HttpMethod.POST)
        //   .permitAll()
        //      .anyRequest()
        ///    .authenticated());

        http.csrf(c -> c.disable());
        return http.build();



    }
 */
//    @Bean
//    public AuthenticationManager authenticationManager(final AuthenticationConfiguration authenticationConfiguration) throws Exception {
//        return authenticationConfiguration.getAuthenticationManager();
//    }

//    @Bean
//    public PasswordEncoder passwordEncoder() {
//
//
//        return new BCryptPasswordEncoder();
//    }

//    @Bean
//    public WebSecurityCustomizer webSecurityCustomizer() {
//        return (web) -> web.ignoring().requestMatchers(
//                "/authcontroller/**",
//                "/swagger-resources/**",
//                "/swagger-ui.html/**",
//                "/swagger-resources/**",
//                "/swagger-ui/**",
//                "/v3/api-docs/**");
//    }
//
//    @Bean
//    public WebMvcConfigurer corsConfigurer() {
//        return new WebMvcConfigurer() {
//            @Override
//            public void addCorsMappings(@NonNull CorsRegistry registry) {
//                registry.addMapping("/**")
//                        .allowedMethods("*");
//            }
//        };
//    }
//

}