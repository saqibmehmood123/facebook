package com.example.facebookclone.client;

import com.example.facebookclone.dto.RegisterDto;
import com.example.facebookclone.dto.UserDTO;
import com.example.facebookclone.dto.UserDto;
import com.example.facebookclone.request.RegisterRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;


///@FeignClient(name = "comments")     @PostMapping("/comments/findByPostId")
//@FeignClient(name = "user")
@FeignClient(name = "user")

public interface UserServiceClient {

    @PostMapping("/users/userCreate")
    ResponseEntity<UserDTO> save(  UserDTO userDto);
//

    @GetMapping("/users/getUserByUsername/{email}")
    ResponseEntity<UserDto> getUserByUserEmail(@PathVariable("email") String email);
}

