package com.example.facebookclone.fiegnclient;

import com.example.facebookclone.dtos.PostDto;
import com.example.facebookclone.requestpayload.PostIdListRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import  com.example.facebookclone.dtos.PostDtoRequest;
@FeignClient(name = "posts")
public interface PostClient {

    @GetMapping("/posts/user/{userId}")
    List<PostDto> getPostsByUserId(@PathVariable("userId") Long userId);

    @PostMapping("/posts/getPostsByUsersId" )
    public List<PostDto> getPostsByUsersId(@RequestBody PostIdListRequest postDtoRequest);


}
