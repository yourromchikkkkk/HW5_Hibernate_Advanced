package com.cursor.hibernate.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cursor.hibernate.dao.CartDao;
import com.cursor.hibernate.dmo.Cart;

import java.util.List;

@Service
public class CartService {
    @Autowired
    CartDao cartDao;

    @Transactional
    public void add(Cart cart) {
        cartDao.saveCart(cart);
    }

    @Transactional
    public void remove(Cart cart) {
        cartDao.delete(cart);
    }

    @Transactional(readOnly = true)
    public Cart findById(int id) {
        return cartDao.findById(id);
    }

    @Transactional(readOnly = true)
    public List<Cart> listCarts() {
        return cartDao.showAllCarts();
    }
}
