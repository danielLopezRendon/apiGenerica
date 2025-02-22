package com.prueba.completa.bancolombia.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prueba.completa.bancolombia.dto.ProductoDto;
import com.prueba.completa.bancolombia.entity.Producto;
import com.prueba.completa.bancolombia.service.ProductoService;
import com.prueba.completa.bancolombia.utils.BancolombiaExeption;
import com.prueba.completa.bancolombia.utils.ControlResponseAdvice;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("api/v1")
public class ProductoController extends ControlResponseAdvice {

    @Autowired
    private ProductoService productoService;


    @Operation(summary = "servicio para consulta de productos en un rango de precios",description = "consulta productos en un ranfo de precios.")
    @ApiResponse(responseCode = "200",description = "servicio disponible",content ={@Content(schema=@Schema(implementation = ProductoDto.class))} )
    @ApiResponse(responseCode = "400",description = "Sin data",content ={@Content(schema=@Schema(implementation = ProductoDto.class))} )
    @ApiResponse(responseCode = "500",description = "Sin data",content ={@Content(schema=@Schema(implementation = BancolombiaExeption.class))} )
    @GetMapping("/get-filter")
    public ResponseEntity<List<ProductoDto>> getFilter(
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
    

    
    @GetMapping("/get-filter-paginado")
    public ResponseEntity<Page<Producto>> getFilterPaginado(
        @RequestParam(required = true,name="rangoInicial") Integer rangoInicial,
        @RequestParam(required = true,name="rangoFinal") Integer rangoFinal,
        @RequestParam(required = true,name="page") Integer page) throws BancolombiaExeption{
            var productos= productoService.getProductosFilterPage(rangoInicial, rangoFinal,page);
            HttpStatus httpStatus=HttpStatus.OK;
            if(productos.isEmpty()){
                httpStatus= HttpStatus.BAD_REQUEST;
                throw new BancolombiaExeption("Error al realizar la consulta solicitada", null, null);
                
            }
        return new ResponseEntity<>(productos,httpStatus);
    }
    
}
