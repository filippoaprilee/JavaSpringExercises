# Esempio di utilizzo dei Beans con Annotations in Spring XML

Questo progetto dimostra un semplice esempio di utilizzo dei Beans
con Annotations in Spring XML.

### Cosa sono le annotation e cos'è @Autowired?
Le annotations sono metadati che forniscono informazioni aggiuntive su un programma Java
e possono essere inserite direttamente nel codice sorgente. Spring Framework fornisce
diverse annotations che possono essere utilizzate per semplificare la configurazione
e la gestione dei Beans.

`@Autowired` è una delle annotations fornite da Spring Framework e viene utilizzata
per iniettare automaticamente le dipendenze tra i Beans. Quando Spring Framework trova
un campo o un costruttore annotato con `@Autowired`, cerca un Bean corrispondente
nel suo contesto e lo inietta nella classe. Questo elimina la necessità di creare
manualmente le dipendenze tra i Beans.

### Struttura del progetto
Il progetto è composto dai seguenti file:
- `Main.java`: classe principale del programma.
- `FatturaService.java`: classe che rappresenta la logica di business di una fattura.
- `OrdineService.java`: classe che rappresenta la logica di business di un ordine.
- `ProdottoService.java`: classe che rappresenta la logica di business di un prodotto.
- `bean.xml`: file di configurazione Spring XML che definisce i beans e le loro dipendenze
  utilizzando le annotations.

### Come eseguire il programma
1. Clonare il repository o scaricare i file del progetto.
2. Aprire il progetto in un ambiente di sviuppo Java (ad esempio, IntelliJ IDEA o Eclipse).
3. Compilare ed eseguire la classe `Main.java`.

### Note
- Questo esempio utilizza i Beans con Annotations in Spring XML. È possibile utilizzare
  le annotations per definire i Beans direttamente nel codice sorgente senza la necessità
  di un file di configurazione XML.
- Assicurati di avere installato JDK 8 o versioni successive per compilare
  ed eseguire il programma.
- Il progetto utilizza Maven come sistema di build. Assicurati di avere Maven
  installato sul tuo sistema per compilare il progetto.

### Contatti
Per qualsiasi domanda o suggerimento puoi contattarmi tramite [email](mailto:filippoaprilee@gmail.com).

Grazie per aver visitato la mia repository!

@2024 Filippo Aprile