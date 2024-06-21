package org.setterDI;
import org.setterDI.Service.BibliotecaService;

import java.util.List;

public class Biblioteca {

    public Biblioteca() {

    }

    private BibliotecaService service;

    public void setService(BibliotecaService service) {
        this.service = service;
    }

    public List<String> getLibriDisponibili() {
        return service.getBiblioteca();
    }
}
