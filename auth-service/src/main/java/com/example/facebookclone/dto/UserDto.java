package com.example.facebookclone.dto;


import com.example.facebookclone.enums.Role;
import lombok.Data;

@Data
public class UserDto {
    private String id;
    private String name;
    private String email;
    private String password;
    private Role role;
}