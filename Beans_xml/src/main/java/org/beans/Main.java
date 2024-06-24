package org.beans;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

        Ordine ordine = (Ordine) context.getBean("ordine");

        System.out.println(ordine.HelloWorld());
    }
}
