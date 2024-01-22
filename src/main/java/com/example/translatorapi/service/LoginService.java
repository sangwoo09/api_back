package com.example.translatorapi.service;

import com.example.translatorapi.dto.LoginDto;
import com.example.translatorapi.entity.User;
import com.example.translatorapi.repository.UserRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginService {

    private final UserRepository userRepository;
    private final HttpServletRequest httpServletRequest;

    public boolean loginProc(LoginDto dto){
        User user = userRepository.findByIdAndPassword(dto.getId(), dto.getPassword());

        if (user != null){
            HttpSession session = httpServletRequest.getSession();
            session.setAttribute("loginUser", user.getId());
            return true;
        }else {
            return false;
        }
    }

    public boolean signupProc(LoginDto loginDto){
        User user = userRepository.findById(loginDto.getId()).orElse(null);

        if (user == null){
            return true;
        }else {
            return false;
        }
    }
}
