package com.example.genericrestapi.repository;

import com.example.genericrestapi.entity.RequestField;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RequestFieldRepository extends JpaRepository<RequestField, Long> {
    List<RequestField> findAllByServiceId(Long serviceId);
    boolean existsByKeyAndServiceId(String key, Long serviceId);
}
