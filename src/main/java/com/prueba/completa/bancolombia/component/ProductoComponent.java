package com.prueba.completa.bancolombia.component;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.prueba.completa.bancolombia.dto.ProductoDto;
import com.prueba.completa.bancolombia.entity.Producto;
import com.prueba.completa.bancolombia.repository.ProductoRepository;
import com.prueba.completa.bancolombia.utils.ConvertDtos;


@Component
public class ProductoComponent  extends ConvertDtos{
    
    @Autowired
    private ProductoRepository productoRepository;

    public List<ProductoDto> getByFilterRange(Integer rangoInicial,Integer rangoFinal){
        List<Producto> productos=productoRepository.getByfilter(rangoInicial,rangoFinal);
        return returnListDto(productos, ProductoDto.class);
    }

    
}
