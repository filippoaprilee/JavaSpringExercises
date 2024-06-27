package it.apuliadigital.noleggioauto.model;

import java.time.LocalDate;

public class Recensione {
    private Long id;
    private Long utenteId;
    private Long veicoloId;
    private Integer punteggio;
    private String commento;
    private LocalDate data;

    public Recensione(Long id, Long utenteId, Long veicoloId, Integer punteggio, String commento, LocalDate data) {
        this.id = id;
        this.utenteId = utenteId;
        this.veicoloId = veicoloId;
        this.punteggio = punteggio;
        this.commento = commento;
        this.data = data;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUtenteId() {
        return utenteId;
    }

    public void setUtenteId(Long utenteId) {
        this.utenteId = utenteId;
    }

    public Long getVeicoloId() {
        return veicoloId;
    }

    public void setVeicoloId(Long veicoloId) {
        this.veicoloId = veicoloId;
    }

    public Integer getPunteggio() {
        return punteggio;
    }

    public void setPunteggio(Integer punteggio) {
        this.punteggio = punteggio;
    }

    public String getCommento() {
        return commento;
    }

    public void setCommento(String commento) {
        this.commento = commento;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "ID: " + id + ".\nID Utente: " + utenteId + ".\nID Veicolo: " + veicoloId + ".\nPunteggio: " + punteggio + ".\nCommento: " + commento + ".\nData: " + data + ".\n";
    }
}
