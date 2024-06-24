package org.noleggioauto;

public class Auto {
    private String targa;
    private String marca;
    private String modello;
    private int numPosti;
    private TipoAuto tipoAuto;
    private StatoPrenotazione statoPrenotazione;

    // Costruttore
    public Auto(String targa, String marca, String modello, int numPosti, TipoAuto tipoAuto, StatoPrenotazione statoPrenotazione) {
        this.targa = targa;
        this.marca = marca;
        this.modello = modello;
        this.numPosti = numPosti;
        this.tipoAuto = tipoAuto;
        this.statoPrenotazione = statoPrenotazione;
    }

    // Getter e Setter

    public String getTarga() {
        return targa;
    }

    public void setTarga(String targa) {
        this.targa = targa;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModello() {
        return modello;
    }

    public void setModello(String modello) {
        this.modello = modello;
    }

    public int getNumPosti() {
        return numPosti;
    }

    public void setNumPosti(int numPosti) {
        this.numPosti = numPosti;
    }

    public TipoAuto getTipoAuto() {
        return tipoAuto;
    }

    public void setTipoAuto(TipoAuto tipoAuto) {
        this.tipoAuto = tipoAuto;
    }

    public StatoPrenotazione getStatoPrenotazione() {
        return statoPrenotazione;
    }

    public void setStatoPrenotazione(StatoPrenotazione statoPrenotazione) {
        this.statoPrenotazione = statoPrenotazione;
    }

    // toString() per la rappresentazione testuale dell'oggetto
    @Override
    public String toString() {
        return "L'auto con targa " + targa + " della marca " + marca + " e modello " + modello + " ha " + numPosti + " ed è di tipo auto " + tipoAuto + ". Attualmente è " + statoPrenotazione;
    }
}