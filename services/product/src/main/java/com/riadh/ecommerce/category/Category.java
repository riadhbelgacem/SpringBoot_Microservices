package com.riadh.ecommerce.category;

import com.riadh.ecommerce.product.Product;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Builder


public class Category {

    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private String description;
    @OneToMany(mappedBy = "category",cascade = CascadeType.REMOVE)
    private List<Product> products;

}
