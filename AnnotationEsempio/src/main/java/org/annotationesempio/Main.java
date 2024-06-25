package org.annotationesempio;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        BeanA a = context.getBean("beanA", BeanA.class);
        System.out.println(a.hello());
    }
}