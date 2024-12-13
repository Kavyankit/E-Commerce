package capstone.ecommerce.repositories;

import capstone.ecommerce.models.Category;
import capstone.ecommerce.models.Product;
import capstone.ecommerce.projections.ProductProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    Product findByTitle(String title);
    Optional<Product> findById(long id);
    List<Product> findAll();
    Optional<Product> findById(Long id);
    List<Product> findByCategory(Category category);
    List<Product> findAllByCategory_Title(String categoryTitle);
    List<Product> findAllByCategory_Id(Long categoryId);
    List<Product> findByTitleStartingWithAndIdEqualsAndPriceLessThan(String startingWith, Long id, double priceLessThan);

    @Query("select p.title as title, p.id as id from Product p where p.category.title = :categoryName")
    List<ProductProjection> getTitlesAndIdOfAllProductsWithGivenCategoryName(@Param("categoryName") String categoryName);

    @Query(value = "select * from products p where p.id = 1 and p.title = :productTitle", nativeQuery = true)
    List<ProductProjection> getTitlesAndIdOfAllProductsWithCategoryNameEquals(@Param("productTitle") String productTitle);

}
