package com.example.postcoreapi.repository;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "post_list")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class PostEntity {
    @Id
    @GeneratedValue
    private Long id;
    @Column(nullable = false, length = 50)
    private String postId;
    @Column(nullable = false, length = 50)
    private String clientId;
    @Column(nullable = false, length = 50)
    private String postRecipientId;
    @Column(nullable = false, length = 50)
    private String postItem;
    @Column(nullable = false, length = 50)
    private String status;
}
