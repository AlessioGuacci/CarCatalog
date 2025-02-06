package com.example.carCatalogService.Repository;

import com.example.carCatalogService.Model.Veicoli;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VeicoliRepository extends JpaRepository<Veicoli,Long> {
}
