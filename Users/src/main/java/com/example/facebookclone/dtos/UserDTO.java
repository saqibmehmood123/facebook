package com.example.facebookclone.dtos;

import java.util.ArrayList;
import java.util.List;

public class UserDTO
{
    private Long id;
    private String name;
    private String email;
    // getters and setters
    public UserDTO() {

    }
    public UserDTO(Long id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }
    public UserDTO( String name, String email) {

        this.name = name;
        this.email = email;
    }

    public List<PostDto> postDtoList = new ArrayList<>();

    public List<PostDto> getPostDtoList() {
        return postDtoList;
    }

    public void setPostDtoList(List<PostDto> postDtoList) {
        this.postDtoList = postDtoList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
