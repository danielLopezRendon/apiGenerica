package com.prueba.completa.bancolombia.utils;

import java.util.List;

import lombok.Data;

@Data
public class BancolombiaExeption extends RuntimeException {

    private final List<String> errores;

    private final List<String> soluciones;


    public BancolombiaExeption(String error,List<String> errores,List<String> soluciones) {
        super(error);
        this.soluciones=soluciones;
        this.errores=errores;
    }
    
}
