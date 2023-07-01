package br.com.app.application.user.dto;

import jakarta.validation.constraints.NotBlank;

public record PostUserDto(
        @NotBlank String name,
        @NotBlank String email) {
}
