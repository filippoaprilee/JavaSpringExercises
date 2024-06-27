package it.apuliadigital.noleggioauto.model;

import java.time.LocalDate;

public class Prenotazione {
    private Long id;
    private Long utenteId;
    private Long veicoloId;
    private LocalDate dataInizio;
    private LocalDate dataFine;
    private StatoPrenotazione stato;

    public Prenotazione(Long id, Long utenteId, Long veicoloId, LocalDate dataInizio, LocalDate dataFine, StatoPrenotazione stato) {
        this.id = id;
        this.utenteId = utenteId;
        this.veicoloId = veicoloId;
        this.dataInizio = dataInizio;
        this.dataFine = dataFine;
        this.stato = stato;
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

    public LocalDate getDataInizio() {
        return dataInizio;
    }

    public void setDataInizio(LocalDate dataInizio) {
        this.dataInizio = dataInizio;
    }

    public LocalDate getDataFine() {
        return dataFine;
    }

    public void setDataFine(LocalDate dataFine) {
        this.dataFine = dataFine;
    }

    public StatoPrenotazione getStato() {
        return stato;
    }

    public void setStato(StatoPrenotazione stato) {
        this.stato = stato;
    }

    @Override
    public String toString() {
        return "ID: "+ id + ".\n ID Utente : " + utenteId + ".\n ID Veicolo : " + veicoloId + ".\n Data inizio e data fine: " + dataInizio + " - " + dataFine + ".\n Stato: " + stato + ".";
    }
}
