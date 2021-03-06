package com.cursor.hibernate.dao;

import com.cursor.hibernate.dmo.Product;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Objects;

@Repository
public class ProductDao {
    @PersistenceContext
    private EntityManager entityManager;

    public void saveProduct(Product product) {
        if (!Objects.isNull(product)) {
            entityManager.persist(product);
        }
    }

    public void deleteProduct(Product product) {
        if (!Objects.isNull(product)) {
            entityManager.persist(product);
        }
    }

    public Product findById(int id) {
        if (id > 0) {
            return entityManager.find(Product.class, id);
        } else {
            return null;
        }
    }

    @SuppressWarnings("unchecked")
    public List<Product> showAllProducts() {
        return entityManager.createQuery("FROM Product p").getResultList();
    }
}
