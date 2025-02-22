package com.prueba.completa.bancolombia.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.prueba.completa.bancolombia.entity.Producto;

public interface ProductoRepository extends  JpaRepository<Producto,String> {

        @Query(value="""
                SELECT * FROM PRODUCTO  p WHERE p.PRICE  BETWEEN :rangoInicial AND :rangoFinal
                """,nativeQuery=true)
                public List<Producto> getByfilter(@Param(value = "rangoInicial")Integer rangoInicial,@Param(value = "rangoFinal")Integer rangoFinal);

}
