package org.setterdi_esempio;

import org.setterdi_esempio.service.OrdineService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

            OrdineService ordineService = (OrdineService) context.getBean("ordineService");
            System.out.println(ordineService.getCliente().clienti());
            System.out.println(ordineService.getStatoPredefinito());
    }
}