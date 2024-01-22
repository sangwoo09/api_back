package com.example.translatorapi.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class HistoryDto {
    private String searchWord;
    private String lang;
}
