package it.apuliadigital.noleggioauto.model;

public class Veicolo {
    private Long id;
    private String modello;
    private String marca;
    private String targa;
    private Integer anno;
    private TipoVeicolo tipo;
    private boolean disponibilita;
    private Double prezzoGiornaliero;

    public Veicolo(Long id, String modello, String marca, String targa, Integer anno, TipoVeicolo tipo, boolean disponibilita, Double prezzoGiornaliero) {
        this.id = id;
        this.modello = modello;
        this.marca = marca;
        this.targa = targa;
        this.anno = anno;
        this.tipo = tipo;
        this.disponibilita = disponibilita;
        this.prezzoGiornaliero = prezzoGiornaliero;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModello() {
        return modello;
    }

    public void setModello(String modello) {
        this.modello = modello;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getTarga() {
        return targa;
    }

    public void setTarga(String targa) {
        this.targa = targa;
    }

    public Integer getAnno() {
        return anno;
    }

    public void setAnno(Integer anno) {
        this.anno = anno;
    }

    public TipoVeicolo getTipo() {
        return tipo;
    }

    public void setTipo(TipoVeicolo tipo) {
        this.tipo = tipo;
    }

    public boolean isDisponibilita() {
        return disponibilita;
    }

    public void setDisponibilita(boolean disponibilita) {
        this.disponibilita = disponibilita;
    }

    public Double getPrezzoGiornaliero() {
        return prezzoGiornaliero;
    }

    public void setPrezzoGiornaliero(Double prezzoGiornaliero) {
        this.prezzoGiornaliero = prezzoGiornaliero;
    }

    @Override
    public String toString() {
        return "ID: " + id + ".\n Modello e marca: " + modello + " " + marca + ".\n Targa e anno: " + targa + " " + anno + ".\n Tipo: " + tipo + ".\n Disponibilita: " + disponibilita + ".\n Prezzo giornaliero: " + prezzoGiornaliero + ".\n";
    }
}
