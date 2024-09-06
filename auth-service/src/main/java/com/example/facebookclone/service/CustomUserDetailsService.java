package com.example.facebookclone.service;

import com.example.facebookclone.client.UserServiceClient;
import com.example.facebookclone.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private  UserServiceClient userServiceClient;

//    public CustomUserDetailsService(UserServiceClient userServiceClient) {
//        this.userServiceClient = userServiceClient;
//    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
       System.out.println(" loadUserByUsername class to check either works or not  " +email );
        var user = userServiceClient.getUserByUserEmail(email).getBody();
        System.out.println(" loadUserByUsername class to check either works or not 2  " +user.getEmail() );

        assert user != null;
        return new CustomUserDetails(user);

    }
}