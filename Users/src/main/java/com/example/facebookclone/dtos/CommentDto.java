package com.example.facebookclone.dtos;

public class CommentDto {
    private Long id;
    private String content;
    private Long userId;

    private Long postId;
    private String createdAt;
    // Getters and Setters
    public CommentDto() {
     }

    public CommentDto(Long id,  Long userId, Long postId ,String content) {
        this.id = id;
        this.content = content;
        this.userId = userId;
        this.postId = postId;
    }

    public Long getPostId() {
        return postId;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
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
