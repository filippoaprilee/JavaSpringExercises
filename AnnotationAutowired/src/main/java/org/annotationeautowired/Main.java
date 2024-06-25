package org.annotationeautowired;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        OrdineService ordine = context.getBean("ordine", OrdineService.class);
        System.out.println(ordine.sayHello());

        ordine.stampaClienti();
    }
}