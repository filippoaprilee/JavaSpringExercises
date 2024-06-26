package org.autowirespring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        RubricaService rubricaService = (RubricaService) context.getBean("rubricaService");

        for (long userId = 1; userId <= rubricaService.getNumeroMessaggi(); userId++) {
            System.out.println("Messaggio per l'utente " + userId + ": " + rubricaService.getMessaggi(userId));
        }

        System.out.println();
        rubricaService.mostraInfo();
    }
}