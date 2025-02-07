package com.example.carCatalogService.Service;
import com.example.carCatalogService.DTO.VeicoloDTO;
import com.example.carCatalogService.DTO.VeicoloRequestDTO;
import com.example.carCatalogService.Model.Veicolo;
import com.example.carCatalogService.Repository.VeicoliRepository;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class VeicoliService {

    private final VeicoliRepository veicoliRepository;

    public VeicoliService(VeicoliRepository veicoliRepository) {
        this.veicoliRepository = veicoliRepository;
    }

    public List<VeicoloDTO> prentiTuttiVeicoli(){
        List<Veicolo> veicoli = veicoliRepository.findAll();
        List<VeicoloDTO>veicoloDTOS = new ArrayList<>();
        for (Veicolo veicolo: veicoli){
            veicoloDTOS.add(VeicoloDTO.daEntita(veicolo));
        }
        return veicoloDTOS;
    }

    public VeicoloDTO getVeicoloDaID (long id){
        Veicolo veicolo= veicoliRepository.findById(id).orElseThrow(()
                ->new RuntimeException("Veicolo non trovato"));
        return VeicoloDTO.daEntita(veicolo);
    }

    public VeicoloDTO aggiungiVeicolo (VeicoloRequestDTO veicoloRequestDTO){
        Veicolo veicolo = veicoloRequestDTO.transformazioneInEntita();
        return VeicoloDTO.daEntita(veicoliRepository.save(veicolo));
    }

    public void cancellaVeicoloDaID (long id){
        Veicolo veicolo= veicoliRepository.findById(id).orElseThrow(()
                -> new RuntimeException("Veicolo non trovato"));
        veicoliRepository.delete(veicolo);
    }

    public void cancellaTuttiVeicoli(){
        veicoliRepository.deleteAll();
    }

}
