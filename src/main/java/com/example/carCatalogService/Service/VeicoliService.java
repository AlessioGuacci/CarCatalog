package com.example.carCatalogService.Service;
import com.example.carCatalogService.DTO.VeicoloDTO;
import com.example.carCatalogService.DTO.VeicoloRequestDTO;
import com.example.carCatalogService.Model.Enum.StatoMacchina;
import com.example.carCatalogService.Model.Veicolo;
import com.example.carCatalogService.Repository.VeicoliRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;

@Service
public class VeicoliService {

    private final VeicoliRepository veicoliRepository;

    public VeicoliService(VeicoliRepository veicoliRepository) {

        this.veicoliRepository = veicoliRepository;
    }

    public Page<VeicoloDTO> prentiTuttiVeicoli(int page, int size){
        Pageable pageable =PageRequest.of(page,size);
        return veicoliRepository.findAll(pageable).map(VeicoloDTO::daEntita);
    }

    public Page<VeicoloDTO> cercaVeicoli(String marca, StatoMacchina stato, Double minPrezzo,
                                         Double maxPrezzo, int page, int size){
        Pageable pageable = PageRequest.of(page,size);
        return veicoliRepository.searchVeicoli(marca, stato, minPrezzo, maxPrezzo, pageable)
                .map(VeicoloDTO::daEntita);
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
