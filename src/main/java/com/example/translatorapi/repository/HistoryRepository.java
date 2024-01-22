package com.example.translatorapi.repository;

import com.example.translatorapi.entity.History;
import com.example.translatorapi.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface HistoryRepository extends JpaRepository<History, Integer> {
    List<History> findById(String userId);
}
