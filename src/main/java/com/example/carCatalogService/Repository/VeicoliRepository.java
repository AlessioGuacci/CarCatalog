package com.example.carCatalogService.Repository;

import com.example.carCatalogService.Model.Enum.StatoMacchina;
import com.example.carCatalogService.Model.Veicolo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VeicoliRepository extends JpaRepository<Veicolo,Long> {
    List<Veicolo> ricercaPerMarca(String marca);
    List<Veicolo> ricercaPerRangeDiPrezzo(double prezzoMin, double prezzoMax);
    List<Veicolo> ricercaPerStato(StatoMacchina stato);
}
