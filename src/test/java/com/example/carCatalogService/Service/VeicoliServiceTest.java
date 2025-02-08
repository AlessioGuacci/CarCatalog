package com.example.carCatalogService.Service;

import com.example.carCatalogService.DTO.VeicoloDTO;
import com.example.carCatalogService.DTO.VeicoloRequestDTO;
import com.example.carCatalogService.Model.Enum.StatoMacchina;
import com.example.carCatalogService.Model.Veicolo;
import com.example.carCatalogService.Repository.VeicoliRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class VeicoliServiceTest {
    @Mock
    private VeicoliRepository veicoliRepository;

    @InjectMocks
    private VeicoliService veicoliService;
    private Veicolo veicolo;
    private VeicoloRequestDTO veicoloRequestDTO;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);

        veicolo = new Veicolo(1L, "ford", "puma",
                2022, 20000, StatoMacchina.DISPONIBILE);

        veicoloRequestDTO = new VeicoloRequestDTO("ford", "puma",
                2022, 20000, StatoMacchina.DISPONIBILE);
    }

//    @Test
//    void testPrendiTuttiVeicoli() {
//        List<Veicolo> veicoli = Arrays.asList(veicolo);
//        when(veicoliRepository.findAll()).thenReturn(veicoli);
//
//        List<VeicoloDTO> result = veicoliService.prentiTuttiVeicoli();
//        assertEquals(1, result.size());
//        assertEquals("ford", result.get(0).getMarca());
//        verify(veicoliRepository, times(1)).findAll();
//    }

    @Test
    void testGetVeicoloDaID_VeicoloEsiste() {
        when(veicoliRepository.findById(1L)).thenReturn(Optional.of(veicolo));
        VeicoloDTO result = veicoliService.getVeicoloDaID(1L);
        assertNotNull(result);
        assertEquals("ford", result.getMarca());
        assertEquals("puma", result.getModello());
        verify(veicoliRepository, times(1)).findById(1L);
    }

    @Test
    void testGetVeicoliDaID_VeicoloNonEsiste() {
        when(veicoliRepository.findById(2L)).thenReturn(Optional.empty());
        Exception exception = assertThrows(RuntimeException.class,
                () -> veicoliService.getVeicoloDaID(2L));

        assertEquals("Veicolo non trovato", exception.getMessage());
        verify(veicoliRepository, times(1)).findById(2L);
    }

    @Test
    void testAggiungiVeicolo(){
        when(veicoliRepository.save(any(Veicolo.class))).thenReturn(veicolo);
        VeicoloDTO result= veicoliService.aggiungiVeicolo(veicoloRequestDTO);

        assertNotNull(result);
        assertEquals("ford",result.getMarca());
        verify(veicoliRepository,times(1)).save(any(Veicolo.class));

    }

    @Test
    void testCancellaVeicoloDaID_VeicoloEsiste(){
        when(veicoliRepository.findById(1L)).thenReturn(Optional.of(veicolo));
        veicoliService.cancellaVeicoloDaID(1L);
        verify(veicoliRepository,times(1)).delete(veicolo);
    }

    @Test
    void testCancellaVeicoloDaID_VeicoloNonEsiste(){
        when(veicoliRepository.findById(2L)).thenReturn(Optional.empty());
        Exception exception=assertThrows(RuntimeException.class, () ->veicoliService.cancellaVeicoloDaID(2L));
        assertEquals("Veicolo non trovato",exception.getMessage());
        verify(veicoliRepository,times(1)).findById(2L);
    }

    @Test
    void testCancellaTuttiVeicoli(){
        veicoliService.cancellaTuttiVeicoli();
        verify(veicoliRepository,times(1)).deleteAll();
    }




}
