package com.example.facebookclone.web;


import com.example.facebookclone.dtos.UserDTO;
import com.example.facebookclone.service.ResourceNotFoundException;
import com.example.facebookclone.service.UserService;
import jakarta.annotation.security.PermitAll;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.facebookclone.dtos.UserDto;
@RestController
@RequestMapping("/users")

@CrossOrigin(origins = "*")
@Slf4j
public class LoginController
{

    @Autowired
    private UserService userService;

    @PostMapping("/userCreate")

    public  ResponseEntity<UserDTO>  createUser(@Valid @RequestBody UserDTO userDto) throws ResourceNotFoundException {
      System.out.println(" this is user create Login Controller in Users microservice ");
        return  ResponseEntity.ok((userService.createUser(userDto) ));   /// ;
    }

    @GetMapping("/getUserByUsername/{email}")
    ResponseEntity<UserDto> getUserByUserEmail(@PathVariable("email") String email) throws ResourceNotFoundException {

        System.out.println(" getUserByUserEmail in Users microservice "+email);
        return ResponseEntity.ok((userService.getUserByEmail(email)));
    }

}
