package com.example.facebookclone.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class UserDTO implements Serializable
{
    private Long id;
    private String name;
    private String email;
    // getters and setters

    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // getters and setters
    public UserDTO() {

    }
    public UserDTO(Long id, String name, String email,String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
    }
    public UserDTO(String name, String email) {

        this.name = name;
        this.email = email;
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
