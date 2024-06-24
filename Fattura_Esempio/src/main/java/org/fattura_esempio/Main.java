package org.fattura_esempio;

public class Main {
    public static void main(String[] args) {
        Prodotto prodotto = new Prodotto();
        Ordine ordine = new Ordine();
        Fattura fattura = new Fattura(prodotto, ordine);

        System.out.println(fattura.stampaFattura());
    }
}