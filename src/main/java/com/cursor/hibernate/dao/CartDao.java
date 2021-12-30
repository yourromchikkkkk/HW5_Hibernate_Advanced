package com.cursor.hibernate.dao;

import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Objects;
import com.cursor.hibernate.dmo.Cart;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Component
public class CartDao {
    @PersistenceContext
    EntityManager entityManager;

    public void saveCart(Cart cart) {
        if (!Objects.isNull(cart)) {
            entityManager.persist(cart);
        }
    }

    public Cart findById(int id) {
        if (id != 0) {
            return entityManager.find(Cart.class, id);
        } else {
            return null;
        }
    }

    public void delete(Cart cart) {
        if (!Objects.isNull(cart)) {
            entityManager.remove(cart);
        }
    }

    @SuppressWarnings("unchecked")
    public List<Cart> showAllCarts() {
        return entityManager.createQuery("FROM Cart c").getResultList();
    }
}
