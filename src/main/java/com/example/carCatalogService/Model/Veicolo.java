package com.example.carCatalogService.Model;

import com.example.carCatalogService.Model.Enum.StatoMacchina;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Veicoli")
public class Veicolo {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(nullable = false)
        private String marca;

        @Column(nullable = false)
        private String modello;

        @Column(nullable = false)
        private int annoDiProduzione;

        @Column(nullable = false)
        private double prezzo;

        @Column(nullable = false)
        private StatoMacchina stato;
}

