package br.com.app.application.user.dto;

import lombok.Builder;

@Builder
public record ResponseUserDto(
        String id,
        String name,
        String email) {
}
