package com.example.carCatalogService.Repository;

import com.example.carCatalogService.Model.Enum.StatoMacchina;
import com.example.carCatalogService.Model.Veicolo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface VeicoliRepository extends JpaRepository<Veicolo,Long> {

    Page<Veicolo>findByMarcaIgnoreCase(String marca, Pageable pageable);

    Page<Veicolo>findByPrezzoBetween(Double min, Double max, Pageable pageable);

    Page<Veicolo>findByStato(StatoMacchina stato, Pageable pageable);


    @Query("SELECT v FROM Veicolo v WHERE" +
            "(:marca IS NULL OR LOWER(v.marca) LIKE LOWER(CONCAT('%',:marca,'%'))) AND " +
            "(:stato IS NULL OR v.stato = :stato) AND " +
            "(:minPrezzo IS NULL OR v.prezzo >= :minPrezzo) AND " +
            "(:maxPrezzo IS NULL OR v.prezzo <= :maxPrezzo)")
    Page<Veicolo>searchVeicoli(
            @Param("marca") String marca,
            @Param("stato") StatoMacchina stato,
            @Param("minPrezzo") Double minPrezzo,
            @Param("maxPrezzo") Double maxPrezzo,
            Pageable pageable);
}
