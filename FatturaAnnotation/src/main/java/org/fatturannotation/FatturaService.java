package org.fatturannotation;

import org.springframework.stereotype.Component;

@Component(value="fattura")
public class FatturaService {
    public String generaFattura(int numeroOrdine) {
        return "numero #" + numeroOrdine + ".";
    }

    public String sayHello() {
        return "ciao sono una fattura";
    }
}
