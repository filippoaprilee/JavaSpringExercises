package org.beans;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

//        Ordine ordine = context.getBean("ordine", Ordine.class);
//
//        System.out.println(ordine.HelloWorld());

        System.out.println(context.getBean("ordine", Ordine.class).ordine());
        System.out.println(context.getBean("prodotto", Prodotto.class).prodotti());

    }
}
