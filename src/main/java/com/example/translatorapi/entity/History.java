package com.example.translatorapi.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class History {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int no;

    private String id;

    @Column(name = "search_word", length = 200)
    private String searchWord;

    @Column(name = "search_lang", length = 2)
    private String searchLang;

    @Column(name = "search_date")
    @CreationTimestamp
    private LocalDate searchDate;
}
