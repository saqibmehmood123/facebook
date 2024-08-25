package com.example.facebookclone.services;

import com.example.facebookclone.dtos.CommentDto;
import com.example.facebookclone.mapstruct.CommentMapper;

import com.example.facebookclone.repos.CommentJPARepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.facebookclone.model.Comment;
import java.util.List;

@Service
public class CommentService
{

   @Autowired
   CommentMapper commentMapper;

    @Autowired
    CommentJPARepo commentJPARepo;

    public Comment createComment(CommentDto comment)
    {
         return commentJPARepo.save(commentMapper.commentDtoToComment(comment));
    }
    public List<CommentDto> findByUserIdAndPostId(Long userId ,Long commentId)
    {
    return  commentMapper.commentToCommentDto(commentJPARepo.findByUserIdAndPostId (userId ,commentId));
    }
    public List<CommentDto> findByPostIds(List<Long> postIds) {
        // Logic to fetch comments based on postIds
        // Example: commentRepository.findAllByPostIdIn(postIds);
        return  commentMapper.commentToCommentDto(commentJPARepo.findAllByPostIdIn(postIds));
    }
}
