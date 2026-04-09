package com.bridgelabz.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "greeting")
public class GreetingEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String message;
}