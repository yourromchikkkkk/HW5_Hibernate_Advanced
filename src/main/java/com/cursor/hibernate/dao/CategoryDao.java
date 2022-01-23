package com.cursor.hibernate.dao;


import com.cursor.hibernate.dmo.Category;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Objects;

@Repository
public class CategoryDao {
    @PersistenceContext
    EntityManager entityManager;

    public void saveCategory(Category category) {
        if (!Objects.isNull(category)) {
            entityManager.persist(category);
        }
    }

    public void deleteCategory(Category category) {
        if (!Objects.isNull(category)) {
            entityManager.remove(category);
        }
    }

    public Category findById(int id) {
        if (id != 0) {
            return entityManager.find(Category.class, id);
        } else {
            return null;
        }
    }

    @SuppressWarnings("unchecked")
    public List<Category> showAllCategories() {
        return entityManager.createQuery("FROM Category c").getResultList();
    }
}
