package com.prueba.completa.bancolombia.component;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.prueba.completa.bancolombia.dto.ProductoDto;
import com.prueba.completa.bancolombia.entity.Producto;
import com.prueba.completa.bancolombia.repository.ProductoRepository;
import com.prueba.completa.bancolombia.utils.ConvertDtos;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;



@Component
public class ProductoComponent  extends ConvertDtos{
    
    @Autowired
    private ProductoRepository productoRepository;

    public List<ProductoDto> getByFilterRange(Integer rangoInicial,Integer rangoFinal){
        List<Producto> productos=productoRepository.getByfilter(rangoInicial,rangoFinal);
        return returnListDto(productos, ProductoDto.class);
    }

    public Page<Producto> getByFilterRangePage(Integer rangoInicial,Integer rangoFinal,int page){
        Pageable pageable = PageRequest.of(page, 10);
        return productoRepository.findAll(pageable);
    }

    
}
