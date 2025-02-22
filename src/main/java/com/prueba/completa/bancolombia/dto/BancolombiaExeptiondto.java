package com.prueba.completa.bancolombia.dto;

import java.util.List;

import lombok.Data;

@Data
public class BancolombiaExeptiondto {
    private String error;
      private List<String> errores;

    private  List<String> soluciones;

    public BancolombiaExeptiondto (String error, List<String> errores,List<String> soluciones){
        super();
        this.error=error;
        this.errores=errores;
        this.soluciones=soluciones;

    }
    
}
