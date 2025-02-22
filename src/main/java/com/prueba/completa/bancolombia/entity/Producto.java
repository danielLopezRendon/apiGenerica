package com.prueba.completa.bancolombia.entity;
 
import jakarta.persistence.*;

@Entity
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


    // Getters
    public String getBarcode() {
      return barcode;
  }

  public String getItem() {
      return item;
  }

  public String getCategory() {
      return category;
  }

  public Integer getPrice() {
      return price;
  }

  public Integer getDiscount() {
      return discount;
  }

  public Integer getAvailable() {
      return available;
  }

  // Setters
  public void setBarcode(String barcode) {
      this.barcode = barcode;
  }

  public void setItem(String item) {
      this.item = item;
  }

  public void setCategory(String category) {
      this.category = category;
  }

  public void setPrice(Integer price) {
      this.price = price;
  }

  public void setDiscount(Integer discount) {
      this.discount = discount;
  }

  public void setAvailable(Integer available) {
      this.available = available;
  }

 }