package com.prueba.completa.bancolombia.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class ProductoDto implements Serializable {
       
    private String barcode;
  
    private String item;
 
    private String category;
   
    private Integer price;
 
    private Integer discount;
   
    private Integer available;
}
