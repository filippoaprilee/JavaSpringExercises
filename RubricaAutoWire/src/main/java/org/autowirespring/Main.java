package org.autowirespring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        RubricaService rubricaService = (RubricaService) context.getBean("rubricaService");
        System.out.println(rubricaService.getMessaggi(1L));
        System.out.println(rubricaService.getMessaggi(2L));
        System.out.println(rubricaService.getMessaggi(3L));
        rubricaService.mostraInfo();
    }
}