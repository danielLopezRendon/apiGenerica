package com.prueba.completa.bancolombia.utils;


import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.prueba.completa.bancolombia.dto.BancolombiaExeptiondto;

@ControllerAdvice
public class ControlResponseAdvice extends ResponseEntityExceptionHandler {
    

    @ExceptionHandler({BancolombiaExeption.class})
    public ResponseEntity<Object>handleBancolombiaExceptionException(final BancolombiaExeption ex,final WebRequest request){
        final BancolombiaExeptiondto bancolombiaExeptiondto = new BancolombiaExeptiondto(ex.getMessage(),ex.getErrores(), ex.getSoluciones());
        return new ResponseEntity<>(bancolombiaExeptiondto,new HttpHeaders(),HttpStatus.CONFLICT);
    }

}
