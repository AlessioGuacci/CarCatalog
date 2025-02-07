package com.example.carCatalogService.DTO;

import com.example.carCatalogService.Model.Enum.StatoMacchina;
import com.example.carCatalogService.Model.Veicolo;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class VeicoloRequestDTO {

    @NotBlank(message = "Campo non riempito correttamente: Marca")
    private String marca;

    @NotBlank(message = "Campo non riempito correttamente: Modello")
    private String modello;

    @Range(min = 1930, max = 2025, message = "Campo non riempito correttamente nel range: Anno Di Produzione")
    @NotNull(message ="Campo non riempito correttamente: Anno Di Produzione" )
    private int annoDiProduzione;

    @Positive(message = "Valore deve essere positivo: Prezzo")
    @NotNull(message = "Campo non riempito correttamente: Prezzo")
    private double prezzo;

    //In toeria qui non serve che Sprinboot da un errore automatico dichiarando la
    // mancanza di un valore che appartiene al Enum stabilito
    @NotNull(message = "Campo non riempito correttamente: Stato")
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
