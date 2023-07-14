package com.example.postcoreapi.models;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class PostModel {
    private String postId;
    @NotNull(message = "Client id cannot be empty!")
    private String clientId;
    @NotNull(message = "Recipient id cannot be empty!")
    private String postRecipientId;
    private String postItem;
    private String status;
}
