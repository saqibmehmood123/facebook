package com.example.facebookclone.dto;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TokenDto {
    private String token;
}