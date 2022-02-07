package com.cursor.hibernate.dao;

import com.cursor.hibernate.dmo.CreditCard;
import org.springframework.stereotype.Component;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Objects;

@Component
public class CreditCartDao {
    @PersistenceContext
    private EntityManager entityManager;

    public void saveCreditCard(CreditCard creditCard) {
        if (!Objects.isNull(creditCard)) {
            entityManager.persist(creditCard);
        }
    }

    public void deleteCreditCard(CreditCard creditCard) {
        if (!Objects.isNull(creditCard)) {
            entityManager.remove(creditCard);
        }
    }

    public CreditCard findById(int id) {
        if (id != 0) {
            return entityManager.find(CreditCard.class, id);
        } else {
            return null;
        }
    }

    @SuppressWarnings("unchecked")
    public List<CreditCard> showAllCards() {
        return entityManager.createQuery("FROM CreditCard c").getResultList();
    }
}
