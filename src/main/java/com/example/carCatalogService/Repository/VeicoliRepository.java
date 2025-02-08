package com.example.carCatalogService.Repository;

import com.example.carCatalogService.Model.Enum.StatoMacchina;
import com.example.carCatalogService.Model.Veicolo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface VeicoliRepository extends JpaRepository<Veicolo,Long> {

    List<Veicolo>findByMarcaIgnoreCase(String marca);

    List<Veicolo>findByPrezzoBetween(Double min, Double max);

    List<Veicolo>findByStato(StatoMacchina stato);

    @Query("SELECT v FROM Veicolo v WHERE" +
            "(:marca IS NULL OR LOWER(v.marca) LIKE LOWER(CONCAT('%',:marca,'%'))) AND " +
            "(:stato IS NULL OR v.stato = :stato) AND " +
            "(:minPrezzo IS NULL OR v.prezzo >= :minPrezzo) AND " +
            "(:maxPrezzo IS NULL OR v.prezzo <= :maxPrezzo)")
    List<Veicolo>searchVeicoli(
            @Param("marca") String marca,
            @Param("stato") StatoMacchina stato,
            @Param("minPrezzo") Double minPrezzo,
            @Param("maxPrezzo") Double maxPrezzo);
}
