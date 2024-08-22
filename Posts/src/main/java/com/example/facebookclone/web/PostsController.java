package com.example.facebookclone.web;

//import com.example.postservice.model.Post;
//import com.example.postservice.service.PostService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/posts")
public class PostsController {

//    @Autowired
//    private PostService postService;

    @GetMapping
    public String getAllPosts() {
        return "String from posts and this evening  ";
    }
//    @GetMapping
//    public List<Post> getAllPosts() {
//        return postService.getAllPosts();
//    }
//    @PostMapping
//    public Post createPost(@RequestBody Post post) {
//        return postService.createPost(post);
//    }

    // Additional endpoints for updating and deleting posts
}
