package capstone.ecommerce.services;

import capstone.ecommerce.models.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAllProducts();
    Product getSingleProduct(long id);
    Product createProduct(String title,
                          String description,
                          String image,
                          String category,
                          double price);
}
