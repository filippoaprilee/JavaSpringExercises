package org.setterDI.Service.Impl;

import org.setterDI.Service.BibliotecaService;

import java.util.ArrayList;
import java.util.List;

public class BibliotecaServiceImpl implements BibliotecaService {

    @Override
    public List<String> getBiblioteca() {
        List<String> biblioteca = new ArrayList<>();
        biblioteca.add("Libro 1");
        biblioteca.add("Libro 2");
        biblioteca.add("Libro 3");

        return biblioteca;

    }
}
