package com.cursor.hibernate.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cursor.hibernate.dao.CreditCardDao;
import com.cursor.hibernate.dmo.CreditCard;

import java.util.List;

@Service
public class CreditCardService {
    @Autowired
    CreditCardDao creditCardDao;

    @Transactional
    public void add(CreditCard creditCard) {
        creditCardDao.saveCreditCard(creditCard);
    }

    @Transactional
    public void remove(CreditCard creditCard) {
        creditCardDao.deleteCreditCard(creditCard);
    }

    @Transactional(readOnly = true)
    public CreditCard findById(int id) {
        return creditCardDao.findById(id);
    }

    @Transactional(readOnly = true)
    public List<CreditCard> listCreditCards() {
        return creditCardDao.showAllCards();
    }
}
