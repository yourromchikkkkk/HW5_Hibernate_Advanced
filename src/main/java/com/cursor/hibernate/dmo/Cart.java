package com.cursor.hibernate.dmo;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "cart")
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @OneToOne
    User user;

    @ManyToMany
    @JoinColumn(name = "products_ids", referencedColumnName = "id")
    List<Product> products;

    public Cart() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void addProduct(Product p) {
        products.add(p);
    }
}
