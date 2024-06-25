package org.fatturannotation;

import org.springframework.stereotype.Component;

@Component(value="prodotto")
public class ProdottoService {
    public String getProdotto(int id) {
        if (id == 1) {
            return "TV";
        } else if (id == 2) {
            return "Computer";
        } else if (id == 3) {
            return "Smartphone";
        } else {
            return "Prodotto non trovato";
        }
    }

    public String sayHello() {
        return "ciao sono un prodotto";
    }
}
