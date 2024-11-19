package capstone.ecommerce.controllers;

import capstone.ecommerce.dtos.CreateProductRequestDto;
import capstone.ecommerce.models.Product;
import capstone.ecommerce.services.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    public ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<Product> getSingleProduct(@PathVariable("id") long id) {
        Product p = productService.getSingleProduct(id);
        ResponseEntity<Product> responseEntity;
        if(p==null){
             responseEntity = new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        else {
            responseEntity = new ResponseEntity<>(p, HttpStatus.OK);
        }

        return responseEntity;
    }

    @PostMapping("/products")
    public Product createProduct(@RequestBody CreateProductRequestDto createProductRequestDto) {
        return productService.createProduct(createProductRequestDto.getTitle(),
                createProductRequestDto.getDescription(),
                createProductRequestDto.getImage(),
                createProductRequestDto.getCategory(),
                createProductRequestDto.getPrice());
    }

    @PostMapping("/products/{id}")
    public String updateProduct(@PathVariable("id") long id) {
        return null;
    }

    @DeleteMapping("/products/{id}")
    public String deleteProduct(@PathVariable("id") long id) {
        return null;
    }
}
