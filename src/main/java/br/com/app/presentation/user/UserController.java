package br.com.app.presentation.user;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.app.application.user.dto.PostUserDto;
import br.com.app.application.user.dto.ResponseUserDto;
import br.com.app.application.user.services.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@RequestMapping("/user")
@RestController
public class UserController {

    private final UserService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseUserDto postCreateUser(@RequestBody @Valid PostUserDto dto) {
        return service.createUser(dto);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ResponseUserDto> getUsers() {
        return this.service.getUsers();
    }

}
