package com.example.carCatalogService.DTO;

import com.example.carCatalogService.Model.Enum.StatoMacchina;
import com.example.carCatalogService.Model.Veicolo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class VeicoloRequestDTO {
    private String marca;
    private String modello;
    private int annoDiProduzione;
    private double prezzo;
    private StatoMacchina stato;

    public Veicolo transformazioneInEntita (){
        Veicolo veicolo= new Veicolo();
        veicolo.setMarca(this.marca);
        veicolo.setModello(this.modello);
        veicolo.setAnnoDiProduzione(this.annoDiProduzione);
        veicolo.setPrezzo(this.prezzo);
        veicolo.setStato(this.stato);
        return veicolo;
    }
}
