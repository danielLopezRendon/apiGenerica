package com.prueba.completa.bancolombia.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.prueba.completa.bancolombia.component.ProductoComponent;
import com.prueba.completa.bancolombia.dto.ProductoDto;
import com.prueba.completa.bancolombia.entity.Producto;

@Service
public class ProductoService {

    @Autowired
    private ProductoComponent productoComponent ;

    public List<ProductoDto> getProductosFilter(int rangoInicial,int rangoFinal){
        List<ProductoDto> productosDto=productoComponent.getByFilterRange(rangoInicial, rangoFinal);
        return productosDto;
    }

    public Page<Producto> getProductosFilterPage(int rangoInicial,int rangoFinal,int page){
        Page<Producto> productosDto=productoComponent.getByFilterRangePage(rangoInicial, rangoFinal,page);
        return productosDto;
    }
    
}
