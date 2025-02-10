package com.example.carCatalogService.Controller;

import com.example.carCatalogService.DTO.VeicoloRequestDTO;
import com.example.carCatalogService.Model.Enum.StatoMacchina;
import com.example.carCatalogService.Model.Veicolo;
import com.example.carCatalogService.Repository.VeicoliRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class VeicoloControllerIT {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private VeicoliRepository veicoliRepository;

    @BeforeEach
    void setUp(){
        veicoliRepository.deleteAll();
    }

    @Test
    void testTuttiVeicoli() throws Exception{
        Veicolo veicolo=new Veicolo(null, "Fiat", "500",
                2012, 10000.0, StatoMacchina.DISPONIBILE);
        veicoliRepository.save(veicolo);

        mockMvc.perform(get("/api/veicoli/tutti")
                        .param("page", "0")
                        .param("size", "5"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.content").isArray())
                .andExpect(jsonPath("$.content[0].marca").value("Fiat"));

    }

    @Test
    void testAggiungiVeicolo() throws Exception {
        VeicoloRequestDTO newVehicle = new VeicoloRequestDTO("Ford", "Focus",
                2020, 25000.0, StatoMacchina.DISPONIBILE);

        mockMvc.perform(post("/api/veicoli/aggiungi")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(newVehicle)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.marca").value("Ford"))
                .andExpect(jsonPath("$.modello").value("Focus"));
    }

    @Test
    void testEliminaVeicolo() throws Exception {
        Veicolo veicolo = new Veicolo(null, "Tesla", "Model 3",
                2021, 45000.0, StatoMacchina.DISPONIBILE);
        veicolo = veicoliRepository.save(veicolo);

        mockMvc.perform(delete("/api/veicoli/elimina/" + veicolo.getId()))
                .andExpect(status().isOk());

        assertFalse(veicoliRepository.findById(veicolo.getId()).isPresent());
    }
}

