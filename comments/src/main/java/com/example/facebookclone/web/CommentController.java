package com.example.facebookclone.web;

//import com.example.postservice.model.Post;
//import com.example.postservice.service.PostService;

import com.example.facebookclone.dtos.CommentDto;
import com.example.facebookclone.model.Comment;
import com.example.facebookclone.requestdto.PostIdListRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import com.example.facebookclone.services.CommentService;
@RestController
@RequestMapping("/comments")
@Slf4j
public class CommentController {

    @Autowired
    private CommentService commentService;

    @GetMapping
    public String getAllPosts() {
        return "String from comments ";
    }
    @PostMapping
    public Comment createComment(@RequestBody CommentDto comment)
    {
        return commentService.createComment(comment);
    }

    @GetMapping("/findByUserIdAndPostId/{userId}/{commentId}" )
    public  List<CommentDto>  findByUserIdAndPostId(@PathVariable("userId") Long userId ,@PathVariable("commentId") Long commentId)
    {
        return  commentService.findByUserIdAndPostId(userId ,commentId);
    }

    @PostMapping("/findByPostId")
    public List<CommentDto> findByPostsIds(@RequestBody PostIdListRequest postIdListRequest) {


                log.info(" findByPostsIds {}");
                int a=5/0;
       System.out.println(" this is find by posts , all posts ");
        return commentService.findByPostIds(postIdListRequest.getPostIds());
    }

//    @GetMapping
//    public List<Post> getAllPosts() {
//        return postService.getAllPosts();
//    }
//    @PostMapping
//    public Post createPost( @RequestBody Post post) {
//        return postService.createPost(post);
//    }

    // Additional endpoints for updating and deleting posts
}
