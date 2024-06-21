package org.setterDI;
import org.setterDI.Service.Impl.BibliotecaServiceImpl;


public class Main {
    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();
        biblioteca.setService(new BibliotecaServiceImpl());

        System.out.println(biblioteca.getLibriDisponibili());
    }
}