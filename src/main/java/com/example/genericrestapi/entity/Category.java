package com.example.genericrestapi.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.Map;

@Entity
@Table
public class Category {
    @Id
    private Long id;
    @Column(nullable = false)
    private String name;
    @JdbcTypeCode(SqlTypes.JSON)
    private Map<String, String> title;
}
