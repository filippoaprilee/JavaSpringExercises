package org.fatturannotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component(value="ordine")
public class OrdineService {
    @Autowired
    private ProdottoService prodotto;

    @Autowired
    private FatturaService fattura;

    public String sayHello() {
        return "Ciao, sono un ordine del prodotto '" + prodotto.getProdotto(2) + "' e della fattura " + fattura.generaFattura(1);
    }
}
