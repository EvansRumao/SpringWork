package com.Ecomerce.Website.Controller;

import com.Ecomerce.Website.Service.ProductService;
import com.Ecomerce.Website.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import tools.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class ProductController {

   @Autowired
    private ProductService service;
    @GetMapping("/products")
    public ResponseEntity<List<Product>> ShowProducts(){
      return new ResponseEntity<>(service.getProducts(), HttpStatus.ACCEPTED);
    }

    @GetMapping("/product/{ID}")
    public ResponseEntity<Product> getProductById(@PathVariable int ID){
        Product pro=service.getProductByID(ID);
        if(pro!=null){
            return  new ResponseEntity<>(pro,HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @PostMapping("/product")
    public ResponseEntity<?> addProducts(
            @RequestPart("product") String productJson,
            @RequestPart("imageFile") MultipartFile imageFile) {

        try {
            ObjectMapper mapper = new ObjectMapper();
            Product product = mapper.readValue(productJson, Product.class);

            Product savedProduct = service.addProduct(product, imageFile);

            return new ResponseEntity<>(savedProduct, HttpStatus.CREATED);

        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
