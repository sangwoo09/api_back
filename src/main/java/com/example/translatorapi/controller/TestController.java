package com.example.translatorapi.controller;

import com.example.translatorapi.dto.TestDto;
import com.example.translatorapi.service.TestService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TestController {

    private final TestService testService;

    @GetMapping("/translator/test")
    public String Hello(TestDto dto){
        return testService.testM(dto);
    }
}
