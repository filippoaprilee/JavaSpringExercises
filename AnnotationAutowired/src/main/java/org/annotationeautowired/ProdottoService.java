package org.annotationeautowired;

import org.springframework.stereotype.Component;

@Component(value="prodotto")
public class ProdottoService {
    public String getProdotto(int id) {
        if (id == 1) {
            return "Prodotto 1";
        } else if (id == 2) {
            return "Prodotto 2";
        } else if (id == 3) {
            return "Prodotto 3";
        } else {
            return "Prodotto non trovato";
        }
    }

    public String sayHello() {
        return "ciao sono un prodotto";
    }

}
