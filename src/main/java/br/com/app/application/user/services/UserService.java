package br.com.app.application.user.services;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import br.com.app.application.user.dto.PostUserDto;
import br.com.app.application.user.dto.ResponseUserDto;
import br.com.app.domain.user.User;
import br.com.app.domain.user.UserRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository repository;

    public ResponseUserDto createUser(PostUserDto dto) {
        var user = User.builder()
                .id(UUID.randomUUID().toString())
                .name(dto.name())
                .email(dto.email())
                .build();
        this.repository.save(user);

        return ResponseUserDto.builder()
                .id(user.getId())
                .name(user.getName())
                .email(user.getEmail())
                .build();
    }

    public List<ResponseUserDto> getUsers() {
        return repository.findAll().stream().map(
                u -> {
                    return ResponseUserDto.builder()
                            .id(u.getId())
                            .name(u.getName())
                            .email(u.getEmail())
                            .build();
                }).collect(Collectors.toList());
    }

}
