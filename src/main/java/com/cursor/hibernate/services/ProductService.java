package com.cursor.hibernate.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cursor.hibernate.dao.ProductDao;
import com.cursor.hibernate.dmo.Product;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    ProductDao productDao;

    @Transactional
    public void add(Product product) {
        productDao.saveProduct(product);
    }

    @Transactional
    public void remove(Product product) {
        productDao.deleteProduct(product);
    }

    @Transactional(readOnly = true)
    public Product findById(int id) {
        return productDao.findById(id);
    }

    @Transactional(readOnly = true)
    public List<Product> listProducts() {
        return productDao.showAllProducts();
    }
}
