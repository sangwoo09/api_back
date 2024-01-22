package com.example.translatorapi.controller;

import com.example.translatorapi.dto.LoginDto;
import com.example.translatorapi.entity.User;
import com.example.translatorapi.repository.UserRepository;
import com.example.translatorapi.service.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class LoginController {

    private final UserRepository userRepository;
    private final LoginService loginService;

    @GetMapping("/login")
    public ResponseEntity<?> login(LoginDto dto){

        boolean result = loginService.loginProc(dto);

        if (result){
            return ResponseEntity.status(HttpStatus.OK).build();
        }else {
            return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).build();
        }
    }

    @GetMapping("/signup")
    public ResponseEntity<?> signup(LoginDto loginDto){
        // builder로 바꾸기
        User user = User.builder()
                        .id(loginDto.getId())
                        .password(loginDto.getPassword())
                        .build();

        boolean result = loginService.signupProc(loginDto);

        if (result){
            userRepository.save(user);
            return ResponseEntity.status(HttpStatus.OK).build();
        }else {
            return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).build();
        }

    }
}