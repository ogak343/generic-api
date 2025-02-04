package com.example.genericrestapi.repository;

import com.example.genericrestapi.entity.Service;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ServiceRepository extends JpaRepository<Service, Long> {

    List<Service> findAllByCompanyId(Long companyId);
}
