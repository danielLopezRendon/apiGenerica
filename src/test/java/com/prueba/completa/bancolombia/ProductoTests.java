package com.prueba.completa.bancolombia;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.prueba.completa.bancolombia.component.ProductoComponent;
import com.prueba.completa.bancolombia.controller.ProductoController;
import com.prueba.completa.bancolombia.dto.ProductoDto;
import com.prueba.completa.bancolombia.entity.Producto;
import com.prueba.completa.bancolombia.repository.ProductoRepository;
import com.prueba.completa.bancolombia.service.ProductoService;
import com.prueba.completa.bancolombia.utils.BancolombiaExeption;
import com.prueba.completa.bancolombia.utils.ControlResponseAdvice;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


import com.prueba.completa.bancolombia.utils.ConvertDtos;

import org.springframework.data.domain.Page;

import org.springframework.data.domain.Pageable;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class ProductoTests {
    @Mock
    private ProductoRepository productoRepository;

    @InjectMocks
    private ProductoComponent productoComponent;
    
    @InjectMocks
    private ProductoService productoService;

    @InjectMocks
    private ProductoController productoController;

    private Producto producto;
    private ProductoDto productoDto;
    
    @BeforeEach
    void setUp() {
        producto = new Producto();
        producto.setBarcode("12345");
        producto.setItem("Laptop");
        producto.setCategory("Electronics");
        producto.setPrice(1500);
        producto.setDiscount(10);
        producto.setAvailable(5);
        
        productoDto = new ProductoDto();
        productoDto.setBarcode("12345");
        productoDto.setItem("Laptop");
        productoDto.setCategory("Electronics");
        productoDto.setPrice(1500);
        productoDto.setDiscount(10);
        productoDto.setAvailable(5);
    }

    @Test
    void testGetByFilterRange() {
        when(productoRepository.getByfilter(1000, 2000)).thenReturn(Collections.singletonList(producto));
        List<ProductoDto> result = productoComponent.getByFilterRange(1000, 2000);
        assertNotNull(result);
        assertEquals(1, result.size());
    }

    @Test
    void testGetByFilterRangePage() {
        Pageable pageable = PageRequest.of(0, 10);
        Page<Producto> page = new PageImpl<>(Collections.singletonList(producto));
        when(productoRepository.findAll(pageable)).thenReturn(page);
        Page<Producto> result = productoComponent.getByFilterRangePage(1000, 2000, 0);
        assertNotNull(result);
        assertEquals(1, result.getTotalElements());
    }

    @Test
    void testHandleBancolombiaException() {
        ControlResponseAdvice advice = new ControlResponseAdvice();
        BancolombiaExeption exception = new BancolombiaExeption("Error", Arrays.asList("Detalle error"), Arrays.asList("Solucion"));
        ResponseEntity<Object> response = advice.handleBancolombiaExceptionException(exception, null);
        assertEquals(HttpStatus.CONFLICT, response.getStatusCode());
    }
}
