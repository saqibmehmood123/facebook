package com.example.facebookclone.service;
import com.example.facebookclone.dtos.*;
import com.example.facebookclone.fiegnclient.CommmentsClient;
import com.example.facebookclone.mapstruct.UserMapper;
import com.example.facebookclone.requestpayload.PostIdListRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import com.example.facebookclone.repository.UserRepository;
import  com.example.facebookclone.fiegnclient.PostClient;
import com.example.facebookclone.model.Users;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class UserService
{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostClient postClient;

    @Autowired

    CommmentsClient commmentsClient;
    @Autowired
    UserMapper userMapper;

    public UserDto getUserByEmail(String  email) throws ResourceNotFoundException {
        System.out.println(" this is getUserBYemail in service not controller "+email);

        Users user = userRepository.findByEmail(email);//.orElseThrow(() -> new ResourceNotFoundException("User not found"));
     System.out.println(" this is getUserBYemail in service not controller "+user.getEmail());
        return         userMapper.userToUsersDto(user);
    }




    public UserDTO getUserWithPosts(Long userId) throws ResourceNotFoundException {
        Users user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User not found"));


        System.out.println(" this is user name  +++++++++++++++++++++ " + user.getName() );
        // Fetch posts from post-service using Feign client
        List<PostDto> posts = postClient.getPostsByUserId(userId);
//        List<PostDto> posts = postClient.getPostsByUserId(userId,fetchTokenSecurityContext());

        System.out.println(" this is posts  " + posts.get(0).getContent() );
        // Map User entity to UserDTO


        return         userMapper.userAndPostsToUserDto(user,posts);
    }


    public UserDTO createUser(UserDTO user) throws ResourceNotFoundException {


        Users user1 =  userRepository.save( userMapper.userDtoToUser(user) );

System.out.println(" this is createUser --- ");
        return        userMapper.userToUserDto(user1);
    }

    public UserPostCommentDto getUsersPostsComments() {
        // Fetch users by their IDs
        List<Long> userIds = Arrays.asList(1L, 2L);
        List<Users> listUser = userRepository.findByIdIn(userIds);
        System.out.println("Total Users: " + listUser.size());

        // Convert user entities to DTOs
        List<UserDTO> usersDtoList = userMapper.userListToUserDtoList(listUser);

        // Fetch posts for the users
        List<PostDto> posts = fetchPostsForUsers(userIds);
        System.out.println("Posts size: " + posts.size());

        // Fetch comments for the posts
        List<CommentDto> comments = fetchCommentsForPosts(Arrays.asList(1L, 2L, 3L, 4L));
        System.out.println("Comments size: " + comments.size());

        // Map comments to corresponding posts
        addPostComment(comments, posts);

        // Map posts to corresponding users and create UserPostCommentDto
        UserPostCommentDto userPostCommentDto = addUserPosts(usersDtoList, posts);

        return userPostCommentDto;
    }

    // Helper method to fetch posts
    private List<PostDto> fetchPostsForUsers(List<Long> userIds) {
        PostIdListRequest postRequest = new PostIdListRequest();
        postRequest.setPostIds(userIds);  // Assuming postIds and userIds are the same; adjust as needed
        return postClient.getPostsByUsersId(postRequest);
    }

    // Helper method to fetch comments
    private List<CommentDto> fetchCommentsForPosts(List<Long> postIds) {
        PostIdListRequest commentRequest = new PostIdListRequest();
        commentRequest.setPostIds(postIds);
        return commmentsClient.findByPostsIds(commentRequest);
    }
    private static void addPostComment(List<CommentDto> commentDtos,
                                       List<PostDto> postDtoList) {
        // Group comments by postId
        Map<Long, List<CommentDto>> commentsByPostId = commentDtos.stream()
                .collect(Collectors.groupingBy(CommentDto::getPostId));

        // Set comments for each post
        postDtoList.forEach(post -> post.
                setComment(commentsByPostId.getOrDefault(post.getId()
                        , new ArrayList<>())));
    }

    private static UserPostCommentDto addUserPosts(List<UserDTO> userDtoList, List<PostDto> postDtoList) {
        // Group posts by userId
        Map<Long, List<PostDto>> postsByUserId = postDtoList.stream()
                .collect(Collectors.groupingBy(PostDto::getUserId));

        // Set posts for each user
        userDtoList.forEach(user -> user.setPostDtoList
                (postsByUserId.getOrDefault(user.getId(), new ArrayList<>())));

        // Create UserPostCommentDto and set userDtoList
        UserPostCommentDto userPostCommentDto = new UserPostCommentDto();
        userPostCommentDto.setUserDtoList(userDtoList);
        return userPostCommentDto;
    }


    ///////////////////////////////////////
    public List<CommentDto> getCommentsForPostIds(List<Long> postIds) {
        // Create the request body
        PostIdListRequest request = new PostIdListRequest();
        request.setPostIds(postIds);

        // Call the Feign client method
        return commmentsClient.findByPostsIds(request);
    }
}