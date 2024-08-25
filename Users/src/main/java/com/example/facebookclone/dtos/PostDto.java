package com.example.facebookclone.dtos;

import java.util.ArrayList;
import java.util.List;

public class PostDto {
    private Long id;
    private String content;
    private Long userId;
    private String createdAt;
    // Getters and Setters

    java.util.List<CommentDto> comment = new ArrayList<>();

    public PostDto() {
      }
    public PostDto(Long id,  Long userId,String content) {
        this.id = id;
        this.content = content;
        this.userId = userId;
    }

    public List<CommentDto> getComment() {
        return comment;
    }

    public void setComment(List<CommentDto> comment) {
        this.comment = comment;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }
}
