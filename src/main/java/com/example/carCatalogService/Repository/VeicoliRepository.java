package com.example.carCatalogService.Repository;

import com.example.carCatalogService.Model.Veicolo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VeicoliRepository extends JpaRepository<Veicolo,Long> {
}
