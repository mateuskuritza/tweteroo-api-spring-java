package com.api.tweteroo.dtos;

import jakarta.validation.constraints.NotBlank;

public record TweetDTO(
        @NotBlank String text) {
}
