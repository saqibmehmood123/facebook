package com.example.facebookclone.service;


import com.example.facebookclone.client.UserServiceClient;
import com.example.facebookclone.dto.RegisterDto;
import com.example.facebookclone.dto.TokenDto;
import com.example.facebookclone.dto.UserDTO;
import com.example.facebookclone.exc.WrongCredentialsException;
import com.example.facebookclone.request.LoginRequest;
import com.example.facebookclone.request.RegisterRequest;
import feign.FeignException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
///@RequiredArgsConstructor
public class AuthService {
    @Autowired
    private  AuthenticationManager authenticationManager;
    @Autowired
    private  UserServiceClient userServiceClient;
    @Autowired
    private  JwtService jwtService;

    public TokenDto login(LoginRequest request) {
        Authentication authenticate = authenticationManager.authenticate(new
                UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
        if (authenticate.isAuthenticated())
        {
         System.out.println("  authenticated  " + authenticate.getName());
            return TokenDto
                    .builder()
                    .token(jwtService.generateToken(request.getEmail() ))
                    .build();
        }
        else
        {
            throw new WrongCredentialsException("Wrong credentials");
        }

    }

    public UserDTO register(UserDTO userDto) {
        try {
            userDto.setPassword(new BCryptPasswordEncoder().encode(userDto.getPassword()));

            System.out.println(" this is AuthService register service "+userDto.getName());

            ResponseEntity<UserDTO> response = userServiceClient.save(userDto);
            return response.getBody();
        } catch (FeignException e) {
            // Handle the Feign exception as needed
            // For example, log it or throw a custom exception
            throw new RuntimeException("Failed to create user: " + e.getMessage(), e);
        }


        //String url = "http://user/users/userCreate";  // Adjust this URL based on your discovery client or service registry
//
//        String url = "http://172.19.0.4:8087/users/userCreate";
//        ///
//        HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(MediaType.APPLICATION_JSON);
//        HttpEntity<UserDTO> entity = new HttpEntity<>(userDto, headers);
//
//        ResponseEntity<UserDTO> response = restTemplate.exchange(url, HttpMethod.POST, entity, UserDTO.class);
//
//System.out.println("  this is  resttemplate  " + response.getBody().getEmail());
//

 // return null;
    }
}