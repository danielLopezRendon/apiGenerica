package com.prueba.completa.bancolombia.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prueba.completa.bancolombia.dto.ProductoDto;
import com.prueba.completa.bancolombia.service.ProductoService;
import com.prueba.completa.bancolombia.utils.BancolombiaExeption;
import com.prueba.completa.bancolombia.utils.ControlResponseAdvice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("api/v1")
public class ProductoController extends ControlResponseAdvice {

    @Autowired
    private ProductoService productoService;

    @GetMapping("/get-filter")
    public ResponseEntity<List<ProductoDto>> getMethodName(
        @RequestParam(required = true,name="rangoInicial") Integer rangoInicial,
        @RequestParam(required = true,name="rangoFinal") Integer rangoFinal) throws BancolombiaExeption{
            List<ProductoDto> productos= productoService.getProductosFilter(rangoInicial, rangoFinal);
            HttpStatus httpStatus=HttpStatus.OK;
            if(productos.isEmpty()){
                httpStatus= HttpStatus.BAD_REQUEST;
                throw new BancolombiaExeption("Error al realizar la consulta solicitada", null, null);
                
            }
        return new ResponseEntity<>(productos,httpStatus);
    }
    
    
}
