package com.cursor.hibernate.services;

import com.cursor.hibernate.dmo.Cart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cursor.hibernate.dao.CategoryDao;
import com.cursor.hibernate.dmo.Category;

import java.util.List;

@Service
public class CategoryService {
    @Autowired
    CategoryDao categoryDao;

    @Transactional
    public void add(Category category) {
        categoryDao.saveCategory(category);
    }

    @Transactional
    public void remove(Category category) {
        categoryDao.deleteCategory(category);
    }

    @Transactional(readOnly = true)
    public Category findById(int id) {
        return categoryDao.findById(id);
    }

    @Transactional(readOnly = true)
    public List<Category> listCategories() {
        return categoryDao.showAllCategories();
    }
}
