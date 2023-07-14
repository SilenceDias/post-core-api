package com.example.postcoreapi.services;

import com.example.postcoreapi.models.PostModel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;
@Service
public class PostServiceImpl implements PostService {
    private static final HashMap<String, PostModel> postMap = new HashMap<>();

    static {
        PostModel postModel1 = new PostModel(UUID.randomUUID().toString(), "1", "2",
                "Clothes", "Ready to Ship");
        PostModel postModel2 = new PostModel(UUID.randomUUID().toString(), "2", "1",
                "Kitchenware", "Arrived");
        PostModel postModel3 = new PostModel(UUID.randomUUID().toString(), "1", "3",
                "Appliances", "Shipping");
        postMap.put(postModel1.getPostId() ,postModel1);
        postMap.put(postModel2.getPostId() ,postModel2);
        postMap.put(postModel3.getPostId() ,postModel3);
    }

    @Override
    public void createPost(PostModel postModel) {
        postModel.setPostId(UUID.randomUUID().toString());
        postMap.put(postModel.getPostId(), postModel);
    }

    @Override
    public List<PostModel> getAllPosts() {
        return new ArrayList<>(postMap.values());
    }

    @Override
    public PostModel getPostById(String id) {
        return postMap.get(id);
    }

    @Override
    public void updatePostById(String id, PostModel postModel) {
        postModel.setPostId(id);
        postMap.put(id, postModel);
    }

    @Override
    public void deletePostById(String id) {
        postMap.remove(id);
    }
}
