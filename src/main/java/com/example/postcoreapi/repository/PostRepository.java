package com.example.postcoreapi.repository;

import jakarta.persistence.Id;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface PostRepository extends CrudRepository<PostEntity, Long> {
    List<PostEntity> getPostEntitiesBy();
    PostEntity getPostEntityByPostId(String id);

    @Transactional
    void deletePostEntityByPostId(String id);
}
