package capstone.ecommerce.services;

import capstone.ecommerce.dtos.FakeStoreProductDto;
import capstone.ecommerce.exceptions.ProductNotFoundException;
import capstone.ecommerce.models.Product;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service("fakeStoreProductService")
public class FakeStoreProductService implements ProductService{

    private RestTemplate restTemplate;

    public FakeStoreProductService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
    @Override
    public List<Product> getAllProducts() {
        FakeStoreProductDto[] fakeStoreProductDtos = restTemplate.getForObject("https://fakestoreapi.com/products",
                FakeStoreProductDto[].class);
        List<Product> products = new ArrayList<>();
        for (FakeStoreProductDto fakeStoreProductDto : fakeStoreProductDtos) {
            Product product = fakeStoreProductDto.toProduct();
            products.add(product);
        }
        return products;
    }

    @Override
    public Product getSingleProduct(long id) throws ProductNotFoundException {
        ResponseEntity<FakeStoreProductDto> fakeStoreProductDtoResponseEntity = restTemplate.getForEntity("https://fakestoreapi.com/products/"+id,
                FakeStoreProductDto.class);
        if(fakeStoreProductDtoResponseEntity.getStatusCode() != HttpStatusCode.valueOf(200)){
            //handle this exception
        }
        FakeStoreProductDto fakeStoreProductDto = fakeStoreProductDtoResponseEntity.getBody();
        if(fakeStoreProductDto == null){
            throw new ProductNotFoundException("Product with id "+id+" is not present with the service. It's an invalid id");
        }
        return fakeStoreProductDto.toProduct();
    }

    @Override
    public Product createProduct(String title,
                                 String description,
                                 String image,
                                 String category,
                                 double price) {
        FakeStoreProductDto fakeStoreProductDto = new FakeStoreProductDto();
        fakeStoreProductDto.setTitle(title);
        fakeStoreProductDto.setDescription(description);
        fakeStoreProductDto.setImage(image);
        fakeStoreProductDto.setCategory(category);
        fakeStoreProductDto.setPrice(price);

         FakeStoreProductDto fakeStoreProductDto1 = restTemplate.postForObject("https://fakestoreapi.com/products",
                fakeStoreProductDto,
                FakeStoreProductDto.class);
        return fakeStoreProductDto1.toProduct();
    }

    /*@Override
    public Product updateProduct(long id, CreateProductRequestDto createProductRequestDto) {
        FakeStoreProductDto fakeStoreProductDto = new FakeStoreProductDto();
        fakeStoreProductDto.setTitle(createProductRequestDto.getTitle());
        fakeStoreProductDto.setDescription(createProductRequestDto.getDescription());
        fakeStoreProductDto.setImage(createProductRequestDto.getImage());
        fakeStoreProductDto.setCategory(createProductRequestDto.getCategory());
        fakeStoreProductDto.setPrice(createProductRequestDto.getPrice());

        restTemplate.put("https://fakestoreapi.com/products/"+id,
                fakeStoreProductDto);
        return getSingleProduct(id);
    }

    @Override
    public boolean deleteProduct(long id) {
        restTemplate.delete("https://fakestoreapi.com/products/"+id);
        return true;
    }*/


}
