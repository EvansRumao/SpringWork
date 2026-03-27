package com.Ecomerce.Website.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "product")

public class Product {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private int id;

   public int getId() {
      return id;
   }

   public void setId(int id) {
      this.id = id;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public String getDescription() {
      return description;
   }

   public void setDescription(String description) {
      this.description = description;
   }

   @Column(name = "pro_name")
   private String name;

   @Column(name = "pro_desc")
   private String description;

   private String brand;
   private BigDecimal price;
   private String category;

//   @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "dd-MM-yyyy")
   @Column(name = "release_date")
   private Date releaseDate;

   public String getImageName() {
      return imageName;
   }

   public void setImageName(String imageName) {
      this.imageName = imageName;
   }

   public String getImageType() {
      return imageType;
   }

   public void setImageType(String imageType) {
      this.imageType = imageType;
   }

   public byte[] getImageData() {
      return imageData;
   }

   public void setImageData(byte[] imageData) {
      this.imageData = imageData;
   }

   @Column(name = "product_available")
   private Boolean productAvailable;

   private int quantity;

   private String imageName;
   private String imageType;
   @Lob
   private  byte[] imageData;

   // ===== GETTERS =====



   public String getBrand() {
      return brand;
   }

   public BigDecimal getPrice() {
      return price;
   }

   public String getCategory() {
      return category;
   }

   public Date getReleaseDate() {
      return releaseDate;
   }

   public Boolean getProductAvailable() {
      return productAvailable;
   }

   public int getQuantity() {
      return quantity;
   }

   // ===== SETTERS =====



   public void setBrand(String brand) {
      this.brand = brand;
   }

   public void setPrice(BigDecimal price) {
      this.price = price;
   }

   public void setCategory(String category) {
      this.category = category;
   }

   public void setReleaseDate(Date releaseDate) {
      this.releaseDate = releaseDate;
   }

   public void setProductAvailable(Boolean productAvailable) {
      this.productAvailable = productAvailable;
   }

   public void setQuantity(int quantity) {
      this.quantity = quantity;
   }
}