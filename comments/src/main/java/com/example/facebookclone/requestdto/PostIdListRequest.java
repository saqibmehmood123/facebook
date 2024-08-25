package com.example.facebookclone.requestdto;

import java.util.List;

public class PostIdListRequest {
    private List<Long> postIds;

    public PostIdListRequest() {
    }

    public PostIdListRequest(List<Long> postIds) {
        this.postIds = postIds;
    }

    // Getters and setters
    public List<Long> getPostIds() {
        return postIds;
    }

    public void setPostIds(List<Long> postIds) {
        this.postIds = postIds;
    }
}