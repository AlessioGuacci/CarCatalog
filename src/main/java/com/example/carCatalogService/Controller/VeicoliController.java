package com.example.carCatalogService.Controller;

import com.example.carCatalogService.DTO.ResponeMessageDTO;
import com.example.carCatalogService.DTO.VeicoloDTO;
import com.example.carCatalogService.DTO.VeicoloRequestDTO;;
import com.example.carCatalogService.Model.Enum.StatoMacchina;
import com.example.carCatalogService.Service.VeicoliService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Veicoli API", description = "Gestioni dei Veicoli")
@RestController
@RequestMapping("/api/veicoli")
public class VeicoliController {

    private final VeicoliService veicoliService;

    public VeicoliController(VeicoliService veicoliService) {
        this.veicoliService = veicoliService;
    }

    @Operation(summary = "Ottieni tutti i veicoli",
            description = "Restituisce un elenco paginato di tutti i veicoli disponibili.")
    @GetMapping("/tutti")
    public Page<VeicoloDTO> tuttiVeicoli(@Parameter(description = "Numero della pagina (default: 0)", example = "0") @RequestParam(defaultValue = "0") int page,
                                         @Parameter(description = "Dimensione della pagina (default: 5)", example = "5") @RequestParam(defaultValue = "5") int size){
       return veicoliService.prentiTuttiVeicoli(page,size);
    }

    @Operation(summary = "Ottieni un veicolo per ID", description =
            "Restituisce i dettagli di un veicolo specifico in base all'ID.")
    @GetMapping("/seleziona/{id}")
    public VeicoloDTO sceglieVeicolo(@Parameter(description = "ID del veicolo", example = "1") @PathVariable long id){
       return veicoliService.getVeicoloDaID(id);
    }

    @Operation(summary = "Cerca veicoli con filtri", description =
            "Restituisce un elenco paginato di veicoli filtrati per marca, stato, prezzo minimo e massimo.")
    @GetMapping("/cerca")
    public Page<VeicoloDTO>cercaVeicoli( @Parameter(description = "Marca del veicolo", example = "Fiat") @RequestParam(required = false) String marca,
                                         @Parameter(description = "Stato del veicolo (DISPONIBILE/VENDUTA)") @RequestParam(required = false) StatoMacchina stato,
                                         @Parameter(description = "Prezzo minimo", example = "10000") @RequestParam(required = false) Double minPrezzo,
                                         @Parameter(description = "Prezzo massimo", example = "50000") @RequestParam(required = false) Double maxPrezzo,
                                         @Parameter(description = "Numero della pagina", example = "0") @RequestParam(defaultValue = "0") int page,
                                         @Parameter(description = "Dimensione della pagina", example = "5") @RequestParam(defaultValue = "5") int size){

        return veicoliService.cercaVeicoli(marca, stato, minPrezzo, maxPrezzo, page, size);

    }


    @Operation(summary = "Aggiungi un nuovo veicolo",
            description = "Permette di inserire un nuovo veicolo nel database.")
    @PostMapping("/aggiungi")
    public VeicoloDTO aggiungiVeicolo(@Valid @RequestBody VeicoloRequestDTO veicoloRequestDTO){
        return veicoliService.aggiungiVeicolo(veicoloRequestDTO);
    }

    @Operation(summary = "Elimina un veicolo per ID",
            description = "Rimuove un veicolo dal database in base all'ID.")
    @DeleteMapping("/elimina/{id}")
    public ResponseEntity<ResponeMessageDTO> eliminaVeicolo(@Parameter(description = "ID del veicolo", example = "1")
                                                                @PathVariable long id){
        veicoliService.cancellaVeicoloDaID(id);
        return ResponeMessageDTO.success("Il veicolo è stato eliminato");
    }

    @Operation(summary = "Elimina tutti i veicoli", description = "Rimuove tutti i veicoli presenti nel database.")
    @DeleteMapping("/eliminaTutti")
    public ResponseEntity<ResponeMessageDTO>eliminaTuttiVeicoli(){
        veicoliService.cancellaTuttiVeicoli();
        return ResponeMessageDTO.success("Tutti I veicoli sono stati eliminati");
    }


}
