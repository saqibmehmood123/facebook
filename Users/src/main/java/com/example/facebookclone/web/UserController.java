package com.example.facebookclone.web;

//import com.example.postservice.model.Post;
//import com.example.postservice.service.PostService;

import com.example.facebookclone.dtos.UserDTO;
import com.example.facebookclone.dtos.UserPostCommentDto;
import com.example.facebookclone.service.ResourceNotFoundException;
import com.example.facebookclone.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public String getAllPosts() {
        return "String from users ";
    }
    @GetMapping("/user/{userId}")
    UserDTO getPostsByUserId(@PathVariable("userId") Long userId) throws ResourceNotFoundException {
        return  userService.getUserWithPosts(userId);
    }

//    @GetMapping("/getPostsAndCommentsByUser/{userId}")
//    UserDTO getPostsAndCommentsByUserId(@PathVariable("userId") Long userId) throws ResourceNotFoundException {
//        return  userService.getPostsAndCommentsByUserId(userId);
//    }

    @GetMapping("/getPostsAndCommentsByUser/{userId}")
    UserPostCommentDto getPostsAndCommentsByUserId(@PathVariable("userId") Long userId) throws ResourceNotFoundException {
        return  userService.getUsersPostsComments();
    }


    @PostMapping
    public UserDTO createPost(@RequestBody UserDTO userDto) throws ResourceNotFoundException {
        return userService.createUser(userDto);
    }

    // Additional endpoints for updating and deleting posts
}
