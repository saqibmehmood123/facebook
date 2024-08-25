package com.example.facebookclone.repos;

import com.example.facebookclone.model.Posts;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostJPARepo extends JpaRepository<Posts, Long>
{
    List<Posts> findByUserId(Long userId);

    List<Posts> findAllByUserIdIn(List<Long> postIds);

}
