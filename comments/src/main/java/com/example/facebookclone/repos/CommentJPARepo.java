package com.example.facebookclone.repos;

import com.example.facebookclone.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentJPARepo extends JpaRepository<Comment, Long>
{
    List<Comment> findByUserIdAndPostId(Long userId,Long postId);

    List<Comment> findAllByPostIdIn(List<Long> postIds);
}
