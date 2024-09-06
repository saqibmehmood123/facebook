package com.example.facebookclone.web;

//import com.example.postservice.model.Post;
//import com.example.postservice.service.PostService;

import com.example.facebookclone.dtos.UserDTO;
import com.example.facebookclone.dtos.UserPostCommentDto;
import com.example.facebookclone.service.ResourceNotFoundException;
import com.example.facebookclone.service.UserService;
//import io.opentelemetry.api.trace.Tracer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
//import io.opentelemetry.api.trace.Span;
//import io.opentelemetry.api.trace.Tracer;
//import io.opentelemetry.api.trace.SpanKind;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
@RestController
@RequestMapping("/users")

@CrossOrigin(origins = "*")
@Slf4j
public class UserController {
     /// Logger LOG = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private UserService userService;


//    @Autowired
//    Tracer tracer;
    @GetMapping
    public String getAllUsers() {
//        Tracer tracer = GlobalOpenTelemetry.getTracer("my-tracer");
//        Span span = tracer.spanBuilder("createBookingForUser")
//                .setSpanKind(SpanKind.SERVER) // This is optional, set the kind of span
//                .startSpan();
      ///  LOG.info("  this is Users get All Users logging this is by saqib ");


        log.info("SAQIB SEND SOMETHING  {}");
       /// span.end();
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
        log.info("  getPostsAndCommentsByUserId  {}");
        return  userService.getUsersPostsComments();
    }




    // Additional endpoints for updating and deleting posts
}
