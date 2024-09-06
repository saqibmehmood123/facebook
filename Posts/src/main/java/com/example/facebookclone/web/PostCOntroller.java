package com.example.facebookclone.web;

//import com.example.postservice.model.Post;
//import com.example.postservice.service.PostService;
import com.example.facebookclone.dtos.PostDto;
import com.example.facebookclone.mapstruct.PostMapper;
import com.example.facebookclone.services.PostService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;
import  com.example.facebookclone.dtos.PostIdListRequest;
import java.util.List;

@RestController
@RequestMapping("/posts")
@Slf4j

public class PostCOntroller {

    @Autowired
    private PostService postService;

    @Autowired
    PostMapper postMapper;
    @GetMapping
    public String getAllPosts() {
        return "String from posts and this evening  ";
    }
//    @GetMapping
//    public List<Post> getAllPosts() {
//        return postService.getAllPosts();
//    }


    @GetMapping("/user/{userId}" )
    List<PostDto> getPostsByUserId(@PathVariable("userId") Long userId)
    {
       return  postService.findByUserId(userId);
    }
    @PostMapping
    public PostDto createPost(@RequestBody PostDto post) {

        return  postMapper.postToPostDtos(postService.createPost(post));
    }
    @PostMapping("/getPostsByUsersId" )
    public List<PostDto> getPostsByUsersId(@RequestBody PostIdListRequest postDtoRequest)
    {
                log.info(" getPostsByUsersId {}");

        System.out.println(" this is paramter list " + postDtoRequest.getPostIds() );
        return postService.findAllByUserId(postDtoRequest.getPostIds());
    }

    // Additional endpoints for updating and deleting posts
}
