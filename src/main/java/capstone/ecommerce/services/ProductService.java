package capstone.ecommerce.services;

import capstone.ecommerce.dtos.CreateProductRequestDto;
import capstone.ecommerce.exceptions.ProductNotFoundException;
import capstone.ecommerce.models.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAllProducts();
    Product getSingleProduct(long id) throws ProductNotFoundException;
    Product createProduct(String title,
                          String description,
                          String image,
                          String category,
                          double price);
    /*Product updateProduct(long id, CreateProductRequestDto createProductRequestDto);
    boolean deleteProduct(long id);*/
}
