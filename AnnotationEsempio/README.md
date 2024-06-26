# Esempio di utilizzo dei Beans con Annotations in Spring XML

Questo progetto dimostra un semplice esempio di utilizzo dei Beans 
con Annotations in Spring XML. In questo esempio, definiamo due Beans, BeanA e BeanB.

### Cosa sono le annotation e cos'è @Component?
Le annotations sono metadati che forniscono informazioni aggiuntive su un programma Java 
e possono essere inserite direttamente nel codice sorgente. Spring Framework fornisce 
diverse annotations che possono essere utilizzate per semplificare la configurazione
e la gestione dei Beans.

`@Component` è una delle annotations di base fornite da Spring Framework e viene utilizzata
per identificare una classe come un Bean. Quando Spring Framework trova una classe annotata
con `@Component`, crea un'istanza di quella classe e la registra come un Bean nel suo contesto.

### Struttura del progetto
Il progetto è composto dai seguenti file:
- `Main.java`: classe principale del programma.
- `BeanA.java`: classe che rappresenta un bean A.
- `BeanB.java`: classe che rappresenta un bean B.
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