package com.example.carCatalogService.DTO;

import org.springframework.http.ResponseEntity;

public class ResponeMessageDTO {
    private String message;

    public ResponeMessageDTO(String message){
        this.message=message;
    }
    public String getMessage() {
        return message;
    }


    public static ResponseEntity<ResponeMessageDTO>success(String message){
        return ResponseEntity.ok(new ResponeMessageDTO(message));
    }
}
