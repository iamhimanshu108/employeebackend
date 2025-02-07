package com.hky.employe.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import lombok.Data;
import org.springframework.cache.annotation.Cacheable;

@Entity
@Data

public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    
    private String name;

    private String email;

    private String phone;


    private String department;
}
