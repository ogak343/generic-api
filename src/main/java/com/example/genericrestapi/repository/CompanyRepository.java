package com.example.genericrestapi.repository;

import com.example.genericrestapi.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CompanyRepository extends JpaRepository<Company, Long> {

    List<Company> findAllByCategoryId(Long id);

    boolean existsByName(String name);
}
