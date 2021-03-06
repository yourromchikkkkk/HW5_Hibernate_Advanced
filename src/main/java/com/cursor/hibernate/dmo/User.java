package com.cursor.hibernate.dmo;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "login", unique = true, nullable = false, length = 15)
    private String login;

    @Column(name = "password", nullable = false, length = 15)
    private String password;

    @OneToMany(mappedBy = "user")
    private List<CreditCard> creditCards = new ArrayList<>();

    @OneToOne(cascade = CascadeType.ALL)
    private Cart userCart;

    public User() {}

    public User(String login, String password, CreditCard creditCard, Cart cart) {
        this.login = login;
        this.password = password;
        addCreditCard(creditCard);
        this.userCart = cart;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<CreditCard> getCreditCards() {
        return creditCards;
    }

    public void setCreditCards(List<CreditCard> creditCards) {
        this.creditCards = creditCards;
    }

    public Cart getUserCart() {
        return userCart;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", creditCards=" + creditCards +
                ", userCart=" + userCart +
                '}';
    }

    public void setUserCart(Cart userCart) {
        this.userCart = userCart;
    }

    public void addCreditCard(CreditCard cc) {
        creditCards.add(cc);
    }
}
