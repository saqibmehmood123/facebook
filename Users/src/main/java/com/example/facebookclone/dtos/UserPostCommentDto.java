package com.example.facebookclone.dtos;

import java.util.ArrayList;
import java.util.List;

public class UserPostCommentDto
{
    public List<UserDTO> userDtoList = new ArrayList<>();


    public List<UserDTO> getUserDtoList() {
        return userDtoList;
    }

    public void setUserDtoList(List<UserDTO> userDtoList) {
        this.userDtoList = userDtoList;
    }
}
