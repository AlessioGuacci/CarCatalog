package com.example.carCatalogService.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Veicoli")
public class Veicoli {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(nullable = false)
        private String brand;

        @Column(nullable = false)
        private String model;

        @Column(nullable = false)
        private int year;

        @Column(nullable = false)
        private double basePrice;

        @Column(nullable = false)
        private double baseRent;

        @Column(nullable = false)
        private boolean isAvailable;

        @Column(nullable = false)
        private boolean newField;
}

