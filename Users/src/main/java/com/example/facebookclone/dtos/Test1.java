package com.example.facebookclone.dtos;

import java.util.ArrayList;
import java.util.List;
import java.util.*;
import java.util.stream.Collectors;
public class Test1
{
    public static void main(String[] args) {


        // Create User DTOs
        List<UserDTO> userDtoList = Arrays.asList(
                new UserDTO(1L, "Nasir" ,"mudzaf7","saqib"),
                new UserDTO(2L, "AAmir" ,"mudzaf9","saqib")
        );

        // Create Post DTOs
        List<PostDto> postDtoList = Arrays.asList(
                new PostDto(1L, 1L, "Nasir Post"),
                new PostDto(2L, 1L, "Nasir Post 2"),
                new PostDto(3L, 2L, "Aamir Post"),
                new PostDto(4L, 2L, "Aamir Post2")

        );

        // Create Comment DTOs
        List<CommentDto> commentDtoList = Arrays.asList(
                new CommentDto(1L, 1L, 1L, "Nasir Post1 comment 1"),
                new CommentDto(2L, 1L, 1L, "Nasir Post1 comment 2"),
                new CommentDto(3L, 1L, 2L, "Nasir Post2 comment 1"),
                new CommentDto(4L, 1L, 2L, "Nasir Post2 comment 2"),
                new CommentDto(5L, 2L, 3L, "AAmir Post1 comment 1"),
                new CommentDto(6L, 2L, 3L, "AAmir Post1 comment 2"),
                new CommentDto(7L, 2L, 4L, "AAmir Post2 comment 1"),
                new CommentDto(8L, 2L, 4L, "AAmir Post2 comment 2")
        );

        // Optimize the logic to associate comments with posts and posts with users
        addPostComment(commentDtoList, postDtoList);
        UserPostCommentDto userPostCommentDto = addUserPosts(userDtoList, postDtoList);

        // Display the result (optional)
        System.out.println(userPostCommentDto);
        print(    userPostCommentDto );
    }


    private static void addPostComment(List<CommentDto> commentDtos, List<PostDto> postDtoList) {
        // Group comments by postId
        Map<Long, List<CommentDto>> commentsByPostId = commentDtos.stream()
                .collect(Collectors.groupingBy(CommentDto::getPostId));

        // Set comments for each post
        postDtoList.forEach(post -> post.  setComment(
                commentsByPostId.getOrDefault(post.getId(), new ArrayList<>())));
    }

    private static UserPostCommentDto addUserPosts(List<UserDTO> userDtoList, List<PostDto> postDtoList) {
        // Group posts by userId
        Map<Long, List<PostDto>> postsByUserId = postDtoList.stream()
                .collect(Collectors.groupingBy(PostDto::getUserId));

        // Set posts for each user
        userDtoList.forEach(user -> user.setPostDtoList(postsByUserId.getOrDefault(user.getId(), new ArrayList<>())));

        // Create UserPostCommentDto and set userDtoList
        UserPostCommentDto userPostCommentDto = new UserPostCommentDto();
        userPostCommentDto.setUserDtoList(userDtoList);
        return userPostCommentDto;
    }

    private static void print(   UserPostCommentDto userPostCommentDto )
    {

        for(int a = 0;a<userPostCommentDto.getUserDtoList().size();a++)
        {
            System.out.println(userPostCommentDto.getUserDtoList().get(a).getName());
            for(int a1 = 0;a1<userPostCommentDto.getUserDtoList().get(a).getPostDtoList() .size();a1++)
            {
                System.out.println(userPostCommentDto.getUserDtoList().get(a).getPostDtoList().get(a1).getContent());


                for(int a2 = 0;a2<userPostCommentDto.getUserDtoList().get(a).getPostDtoList().get(a1).getComment().size();a2++)
                {
                    System.out.println(userPostCommentDto.getUserDtoList().get(a).getPostDtoList().get(a1).getComment().get(a2).getContent());

                }


            }
            System.out.println("/////////////////////////////////////////////////////////////////////");
        }



    }
}
