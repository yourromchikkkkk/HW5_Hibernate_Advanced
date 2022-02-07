package com.cursor.hibernate.dao;

import java.util.List;
import org.springframework.stereotype.Component;
import com.cursor.hibernate.dmo.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Objects;

@Repository
public class UserDao {
    @PersistenceContext
    private EntityManager entityManager;

    public void saveUser(User user) {
        if (!Objects.isNull(user)) {
            entityManager.persist(user);
        }
    }

    public void deleteUser(User user) {
        if (!Objects.isNull(user)) {
            entityManager.remove(user);
        }
    }

    public User findById(int id) {
        if (id != 0) {
            return entityManager.find(User.class, id);
        } else {
            return null;
        }
    }

    @SuppressWarnings("unchecked")
    public List<User> showAllUsers() {
        return entityManager.createQuery("FROM User u").getResultList();
    }
}
