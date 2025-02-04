package com.example.genericrestapi.repository;

import com.example.genericrestapi.entity.Language;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Set;

public interface LanguageRepository extends JpaRepository<Language, Long> {
    boolean existsByCode(String code);

    @Query(value = "SELECT COUNT(1) FROM language WHERE code IN :code", nativeQuery = true)
    long countAllById(Set<String> code);
}
