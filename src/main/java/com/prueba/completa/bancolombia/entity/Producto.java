package com.prueba.completa.bancolombia.entity;
 
import jakarta.persistence.*;
import lombok.Data;
@Entity
@Data
@Table(name="PRODUCTO")
 public class Producto {

    @Id
    @Column(name="BARCODE")
    private String barcode;
    @Column(name="ITEM")
    private String item;
    @Column(name="CATEGORY")
    private String category;
    @Column(name="PRICE")
    private Integer price;
    @Column(name="DISCOUNT")
    private Integer discount;
    @Column(name="AVAILABLE")
    private Integer available;

 }