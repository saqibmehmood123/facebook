package com.example.facebookclone.dtos;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class PostDtoRequest
{
 List<Long> listOfIds = new ArrayList<>();

    public PostDtoRequest() {

    }
    public PostDtoRequest(List<Long> usersId) {
        this.listOfIds = usersId;
    }

    public List<Long> getUsersId() {
        return listOfIds;
    }

    public void setUsersId(List<Long> usersId) {
        this.listOfIds = usersId;
    }
}
