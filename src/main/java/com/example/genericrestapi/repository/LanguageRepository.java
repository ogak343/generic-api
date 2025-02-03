package com.example.genericrestapi.repository;

import com.example.genericrestapi.entity.Language;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LanguageRepository extends JpaRepository<Language, Long> {
}
