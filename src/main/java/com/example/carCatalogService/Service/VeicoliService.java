package com.example.carCatalogService.Service;

import com.example.carCatalogService.Repository.VeicoliRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VeicoliService {
    @Autowired
    private VeicoliRepository veicoliRepository;
}
