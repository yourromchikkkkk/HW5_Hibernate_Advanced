package com.cursor.hibernate;

import com.cursor.hibernate.config.AppConfig;
import com.cursor.hibernate.dao.*;
import com.cursor.hibernate.dmo.*;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        CategoryDao categoryDao = new CategoryDao();
        Category category = new Category();
        category.setName("Phones");
        categoryDao.saveCategory(category);
    }
}
