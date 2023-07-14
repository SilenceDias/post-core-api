package com.example.postcoreapi.services;

import com.example.postcoreapi.models.PostModel;

import java.util.List;

public interface PostService {
    void createPost(PostModel postModel);
    List<PostModel> getAllPosts();
    PostModel getPostById(String id);
    void updatePostById(String id, PostModel postModel);
    void deletePostById(String id);
}
