package com.example.carCatalogService.Controller;

import com.example.carCatalogService.DTO.ResponeMessageDTO;
import com.example.carCatalogService.DTO.VeicoloDTO;
import com.example.carCatalogService.DTO.VeicoloRequestDTO;;
import com.example.carCatalogService.Service.VeicoliService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/api/veicoli")
public class VeicoliController {

    private final VeicoliService veicoliService;

    public VeicoliController(VeicoliService veicoliService) {
        this.veicoliService = veicoliService;
    }

    @GetMapping("/tutti")
    public List<VeicoloDTO>tuttiVeicolci(){
       return veicoliService.prentiTuttiVeicoli();
    }

    @GetMapping("/seleziona/{id}")
    public VeicoloDTO sceglieVehicolo(@PathVariable long id){
       return veicoliService.getVeicoloDaID(id);
    }

    @PostMapping("/aggiungi")
    public VeicoloDTO aggiungiVeicolo(@Valid @RequestBody VeicoloRequestDTO veicoloRequestDTO){
        return veicoliService.aggiungiVeicolo(veicoloRequestDTO);
    }

    @DeleteMapping("/elimina/{id}")
    public ResponseEntity<ResponeMessageDTO> eliminaVeicolo(@PathVariable long id){
        veicoliService.cancellaVeicoloDaID(id);
        return ResponeMessageDTO.success("Il veicolo è stato eliminato");
    }

    @DeleteMapping("/eliminaTutti")
    public ResponseEntity<ResponeMessageDTO>eliminaTuttiVeicoli(){
        veicoliService.cancellaTuttiVeicoli();
        return ResponeMessageDTO.success("Tutti I veicoli sono stati eliminati");
    }


}
