package org.setterdi_esempio;

import org.setterdi_esempio.service.FatturaService;
import org.setterdi_esempio.service.OrdineService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

        FatturaService fatturaService = (FatturaService) context.getBean("fatturaService");
        fatturaService.stampaFattura();
    }
}