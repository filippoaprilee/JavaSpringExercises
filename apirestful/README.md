# Esempio di utilizzo di Spring Boot con API MVC e AutoWired

Questo progetto dimostra un semplice esempio di utilizzo di Spring Boot per creare un'applicazione
web con un'API MVC e l'utilizzo di `@Autowired` per l'iniezione delle dipendenze. L'applicazione
è costituita da un controller che gestisce le richieste HTTP e un servizio che fornisce la logica
di business.

### Cosa è Spring Boot? Cosa è un'API MVC? Cosa è @Autowired?
- **Spring Boot** è un framework Java open-source che semplifica lo sviluppo di applicazioni
  basate su Spring. Fornisce funzionalità per la configurazione automatica, la gestione delle
  dipendenze e la creazione di applicazioni web pronte all'uso.
- **API MVC** sta per Model-View-Controller ed è un design pattern comunemente utilizzato per
  sviluppare applicazioni web. In un'applicazione MVC, il Model rappresenta i dati, la View
  rappresenta l'interfaccia utente e il Controller gestisce le richieste HTTP e le risposte.
- **@Autowired** è un'annotation di Spring che viene utilizzata per l'iniezione delle dipendenze.
  Quando si utilizza `@Autowired`, Spring cerca un bean che corrisponda al tipo richiesto e lo
  inietta automaticamente nella classe.


### Struttura del progetto
Il progetto è composto dai seguenti file e package:
- `src/main/java/it/apuliadigital/prova_api`: package principale del progetto.
  - `ApirestfulApplication.java`: classe principale dell'applicazione.
  - `controller/`: package contenente i controller dell'applicazione.
    - `PersonaController.java`: controller che gestisce le richieste HTTP.
  - `service/`: package contenente i servizi dell'applicazione.
    - `PersonaService.java`: interfaccia del servizio.
    - `impl/PersonaServiceImpl.java`: implementazione del servizio.
  - `model/`: package contenente i modelli dell'applicazione.
    - `Persona.java`: classe che rappresenta un'entità Persona.
  - `utils/`: package contenente classi di utilità.
    - `Constants.java`: classe contenente costanti utilizzate nell'applicazione.
    - `FileHandler.java`: classe che gestisce la lettura e la scrittura di file.

### Come eseguire il programma
1. Clonare il repository o scaricare i file del progetto.
2. Aprire il progetto in un ambiente di sviuppo Java (ad esempio, IntelliJ IDEA o Eclipse).
3. Compilare ed eseguire la classe `Main.java`.

### Note
- Questo esempio utilizza Spring Boot e API MVC per creare un'applicazione usando le annotazioni
  di Spring. È possibile utilizzare XML per la configurazione di Spring, ma in questo caso non è
  necessario.
- Assicurati di avere installato JDK 8 o versioni successive per compilare
  ed eseguire il programma.
- Il progetto utilizza Maven come sistema di build. Assicurati di avere Maven
  installato sul tuo sistema per compilare il progetto.

### Contatti
Per qualsiasi domanda o suggerimento puoi contattarmi tramite [email](mailto:filippoaprilee@gmail.com).

Grazie per aver visitato la mia repository!

@2024 Filippo Aprile