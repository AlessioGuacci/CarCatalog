package com.example.carCatalogService.DTO;

import com.example.carCatalogService.Model.Enum.StatoMacchina;
import com.example.carCatalogService.Model.Veicolo;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class VeicoloDTO {
    private String marca;
    private String modello;
    private int annoDiProduzione;
    private double prezzo;
    private StatoMacchina stato;

    private VeicoloDTO(String marca,String modello, int annoDiProduzione, double prezzo, StatoMacchina stato){
        this.marca=marca;
        this.modello=modello;
        this.annoDiProduzione=annoDiProduzione;
        this.prezzo=prezzo;
        this.stato=stato;
    }
    public static VeicoloDTO daEntita(Veicolo veicolo){
        return new VeicoloDTO(veicolo.getMarca(), veicolo.getModello(),
                veicolo.getAnnoDiProduzione(), veicolo.getPrezzo(),veicolo.getStato());
    }

}
