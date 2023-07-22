package com.example.postcoreapi.contollers;

import com.example.postcoreapi.models.PostModel;
import com.example.postcoreapi.services.PostService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/post")
public class PostController {
    @Autowired
    PostService postService;

    @Autowired
    Environment environment;

    @GetMapping("/check")
    public String check(){
        return "post-core-api is working on port: " + environment.getProperty("local.server.port");
    }

    @PostMapping()
    public ResponseEntity<String> createPost(@RequestBody PostModel postModel){
        postService.createPost(postModel);
        return new ResponseEntity<String>("New post added", HttpStatus.OK);
    }

    @GetMapping("/all")
    public List<PostModel> getAllPosts(){
        return postService.getAllPosts();
    }

    @GetMapping("{postId}")
    public PostModel getPostById(@PathVariable String postId){
        return postService.getPostById(postId);
    }

    @PutMapping("{postId}")
    public ResponseEntity<String> updatePostById(@PathVariable String postId, @RequestBody PostModel postModel){
        postService.updatePostById(postId, postModel);
        return new ResponseEntity<String>("Post with id: "+postId+ " updated", HttpStatus.OK);
    }

    @DeleteMapping("{postId}")
    public ResponseEntity<String> deletePostById(@PathVariable String postId){
        postService.deletePostById(postId);
        return new ResponseEntity<String>("Post with id: "+postId+ " deleted", HttpStatus.OK);

    }
}

