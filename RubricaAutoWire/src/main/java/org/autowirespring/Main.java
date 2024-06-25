package org.autowirespring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        RubricaService rubricaService = (RubricaService) context.getBean("rubricaService");
        rubricaService.inviaMessaggio("Mario", "Ciao Mario");
        rubricaService.inviaMessaggio("Luigi", "Ciao Luigi");
        rubricaService.visualizzaMessaggi();
        rubricaService.mostraInfo();
    }
}