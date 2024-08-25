package com.example.facebookclone.fiegnclient;

import com.example.facebookclone.dtos.CommentDto;
import com.example.facebookclone.dtos.PostDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.example.facebookclone.requestpayload.PostIdListRequest;
import java.util.List;

@FeignClient(name = "comments")
public interface CommmentsClient {
////////////////comments")
//    @GetMapping("/comments/findByPostId")
//    List<PostDto> getPostsByUserId(@PathVariable("userId") Long userId);
////comments/comments/findByPostId



    @PostMapping("/comments/findByPostId")
    public List<CommentDto> findByPostsIds(@RequestBody PostIdListRequest postIdListRequest) ;

    }
