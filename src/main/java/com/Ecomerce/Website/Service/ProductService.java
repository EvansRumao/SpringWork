package com.Ecomerce.Website.Service;

import com.Ecomerce.Website.model.Product;
import com.Ecomerce.Website.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class ProductService {

   @Autowired
   private ProductRepo repo;
    public List<Product> getProducts() {
        System.out.println(repo.findAll());
        return repo.findAll();
    }

    public Product getProductByID(int id) {
        return repo.findById(id).orElse(null);
    }

    public Product addProduct(Product pro, MultipartFile image) throws IOException {
        pro.setImageData(image.getBytes());
        pro.setImageType(image.getContentType());
        pro.setImageName(image.getOriginalFilename());

        return repo.save(pro);
    }
}
