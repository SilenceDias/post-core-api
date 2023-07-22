package com.example.postcoreapi.services;

import com.example.postcoreapi.models.PostModel;
import com.example.postcoreapi.repository.PostEntity;
import com.example.postcoreapi.repository.PostRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    PostRepository postRepository;

    private static ModelMapper modelMapper = new ModelMapper();

    static {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
    }

    @Override
    public void createPost(PostModel postModel) {
        postModel.setPostId(UUID.randomUUID().toString());
        PostEntity postEntity = modelMapper.map(postModel, PostEntity.class);
        postRepository.save(postEntity);
    }

    @Override
    public List<PostModel> getAllPosts() {
        return postRepository.getPostEntitiesBy().stream()
                .map(post -> modelMapper.map(post, PostModel.class))
                .collect(Collectors.toList());
    }

    @Override
    public PostModel getPostById(String id) {
        PostEntity postEntity = postRepository.getPostEntityByPostId(id);
        return modelMapper.map(postEntity, PostModel.class);
    }

    @Override
    public void updatePostById(String id, PostModel postModel) {
        PostEntity postEntity = modelMapper.map(postModel, PostEntity.class);
        postEntity.setPostId(id);
        PostEntity dbEntity = postRepository.getPostEntityByPostId(id);

        postEntity.setId(dbEntity.getId());

        postRepository.save(postEntity);

    }

    @Override
    public void deletePostById(String id) {
        postRepository.deletePostEntityByPostId(id);
    }
}
