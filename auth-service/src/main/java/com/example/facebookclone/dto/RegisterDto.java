package com.example.facebookclone.dto;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RegisterDto {
    private String id;
    private String name;
    private String email;
}