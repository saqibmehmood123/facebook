package com.example.facebookclone.fiegnclient;

import com.example.facebookclone.dtos.PostDto;
import com.example.facebookclone.fiegnconfiguration.FeignConfig;
import com.example.facebookclone.requestpayload.PostIdListRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import  com.example.facebookclone.dtos.PostDtoRequest;
@FeignClient(name = "posts", configuration = FeignConfig.class)
public interface PostClient {

    @GetMapping("/posts/user/{userId}")
    List<PostDto> getPostsByUserId(@PathVariable("userId") Long userId); ///, @RequestHeader("Authorization") String token

    @PostMapping("/posts/getPostsByUsersId" )
    public List<PostDto> getPostsByUsersId(@RequestBody PostIdListRequest postDtoRequest);


}
