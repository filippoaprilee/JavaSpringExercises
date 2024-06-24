package org.fattura_esempio;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {

        // PRIMO METODO: Creiamo un oggetto di tipo Fattura e gli passiamo un oggetto di tipo Prodotto e Ordine come parametri senza l'utilizzo di Spring
        /*Prodotto prodotto = new Prodotto();
        Ordine ordine = new Ordine();
        Fattura fattura = new Fattura(prodotto, ordine);
        System.out.println(fattura.stampaFattura());*/


        // SECONDO METODO: Creiamo un oggetto di tipo Fattura e gli passiamo un oggetto di tipo Prodotto e Ordine come parametri utilizzando Spring
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

        System.out.println(context.getBean("fattura", Fattura.class).stampaFattura());

    }
}