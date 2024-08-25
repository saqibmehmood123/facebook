package com.example.facebookclone.services;

import com.example.facebookclone.dtos.PostDto;
import com.example.facebookclone.mapstruct.PostMapper;
import com.example.facebookclone.repos.PostJPARepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import  com.example.facebookclone.model.Posts;

import java.util.List;

@Service
public class PostService
{

   @Autowired
   PostMapper postMapper;

    @Autowired
    PostJPARepo postJPARepo;

    public Posts createPost(PostDto post) {


        return postJPARepo.save(postMapper.postDtosToPost(post));
    }
    public List<PostDto> findByUserId(Long userId)
    {


        return         postMapper.postListToPostDtosList(postJPARepo.findByUserId(userId));
    }
    public List<PostDto> findAllByUserId(List<Long> usersId)
    {

        System.out.println(" this is paramter list " + usersId.get(0) + " " +usersId.get(1) );
        return         postMapper.postListToPostDtosList(postJPARepo.findAllByUserIdIn(usersId));
    }

}
