package capstone.ecommerce.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity
public class Category extends BaseModel {
    private String title;
    @OneToMany(mappedBy = "category", cascade = CascadeType.REMOVE)
    @JsonIgnore
    List<Product> products;

    public Category(String title, List<Product> products) {
        this.title = title;
        this.products = products;
    }

    public Category() {
    }

    public String getTitle() {
        return this.title;
    }

    public List<Product> getProducts() {
        return this.products;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @JsonIgnore
    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
