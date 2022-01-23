package com.cursor.hibernate;

import com.cursor.hibernate.config.AppConfig;
import com.cursor.hibernate.services.*;
import com.cursor.hibernate.dmo.*;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        UserService userService  = context.getBean(UserService.class);
        CategoryService categoryService = context.getBean(CategoryService.class);

        CreditCard creditCard = new CreditCard();
        creditCard.setNumber(4756431234876598L);
        creditCard.setCvv("076");
        creditCard.setDate("09/25");
        Cart cart = new Cart();
        userService.add(new User("ghdtf","rdhbh",creditCard,cart));
    }
}
