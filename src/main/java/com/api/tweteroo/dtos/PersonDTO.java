package com.api.tweteroo.dtos;

import jakarta.validation.constraints.NotBlank;

public record PersonDTO(
        @NotBlank String username,
        @NotBlank String avatar) {
}
