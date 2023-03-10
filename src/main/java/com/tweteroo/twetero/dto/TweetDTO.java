package com.tweteroo.twetero.dto;

import jakarta.validation.constraints.NotBlank;

public record TweetDTO(
    @NotBlank String username,
    @NotBlank String avatar,
    @NotBlank String text
) {
}
