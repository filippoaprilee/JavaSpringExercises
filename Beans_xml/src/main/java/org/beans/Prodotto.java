package org.beans;

import java.util.ArrayList;
import java.util.List;

public class Prodotto {
    public List<String> listaProdotti() {
        List<String> listaProdotti = new ArrayList<>();
        listaProdotti.add("Prodotto 1");
        listaProdotti.add("Prodotto 2");
        listaProdotti.add("Prodotto 3");

        return listaProdotti;
    }

}
