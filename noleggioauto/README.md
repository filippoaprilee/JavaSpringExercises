Piattaforma di Noleggio Auto

Una piattaforma di noleggio auto che permette agli utenti di cercare, prenotare e gestire noleggi di veicoli, mentre agli amministratori è consentito gestire veicoli, utenti e prenotazioni.

### Funzionalità Principali

**Utenti:**

- Profilo utente: visualizzazione e modifica informazioni personali.
- Ricerca veicoli disponibili per noleggio.
- Prenotazione veicoli.
- Visualizzazione cronologia delle prenotazioni.
- Recensione e valutazione dei veicoli.

**Amministratori:**

- Gestione utenti: creazione, modifica ed eliminazione.
- Gestione veicoli: aggiunta, modifica ed eliminazione.
- Gestione prenotazioni: visualizzazione, conferma e cancellazione.
- Visualizzazione statistiche: prenotazioni e recensioni.

### Modelli di Dati

**Utente:**
- id (Long)
- nome (String)
- cognome (String)
- email (String)
- password (String)
- ruolo (Enum: USER, ADMIN)

**Veicolo:**
- id (Long)
- modello (String)
- marca (String)
- targa (String)
- anno (Integer)
- tipo (Enum: BERLINA, SUV, COUPE, ecc.)
- disponibilità (Boolean)
- prezzoGiornaliero (Double)

**Prenotazione:**
- id (Long)
- utenteId (Long)
- veicoloId (Long)
- dataInizio (LocalDate)
- dataFine (LocalDate)
- stato (Enum: IN_CORSO, CONFERMATA, CANCELLATA)

**Recensione:**
- id (Long)
- utenteId (Long)
- veicoloId (Long)
- punteggio (Integer)
- commento (String)
- data (LocalDate)

### Struttura dei Pacchetti

- it.apuliadigital.noleggioauto
  - controller
  - service
  - service/impl
  - model
  - exception
  - utils

Questa struttura permette agli utenti di utilizzare la piattaforma per gestire i loro noleggi e recensire i veicoli, mentre gli amministratori hanno accesso completo per gestire tutte le entità del sistema.

