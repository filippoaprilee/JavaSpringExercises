package org.fattura_esempio;

import java.util.ArrayList;
import java.util.List;

public class Prodotto {
    public List<String> prodotti() {
        List<String> listaProdotti = new ArrayList<>();
        listaProdotti.add("Prodotto 1");
        listaProdotti.add("Prodotto 2");
        listaProdotti.add("Prodotto 3");

        return listaProdotti;
    }

}
