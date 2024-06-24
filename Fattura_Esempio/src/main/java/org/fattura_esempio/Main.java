package org.fattura_esempio;

public class Main {
    public static void main(String[] args) {
        Fattura fattura = new Fattura(new Prodotto(), new Ordine());

        System.out.println(fattura.stampaFattura());
    }
}