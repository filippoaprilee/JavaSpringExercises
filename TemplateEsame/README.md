# DOCUMENTAZIONE PER CREARE UN PROGETTO FUNZIONANTE CON SPRING BOOT

### 1. Spring Initializr
Per creare un progetto funzionante con Spring Boot, 
è necessario utilizzare Spring Initializr. Questo strumento permette di creare un progetto Spring Boot 
con tutte le dipendenze necessarie. Per creare un progetto con Spring Initializr, 
è necessario seguire i seguenti passaggi:
1. Andare su [Spring Initializr](https://start.spring.io/).
2. Scegliere il tipo di progetto (Maven)
3. Scegliere il linguaggio di programmazione (Java)
4. Scegliere la versione di Spring Boot (3.3.1)
5. Inserire i metadata del progetto:
    - Group: it.apuliadigital
    - Artifact: nome-progetto
    - Name: nome-progetto
    - Description: Descrizione per il progetto
    - Package name: it.apuliadigital.nome-progetto
    - Packaging: Jar
    - Java: 17
6. Aggiungere le dipendenze necessarie: 
    - Spring Web
    - Spring Data JPA
    - Spring Data JDBC
7. Cliccare su "Generate" per scaricare il progetto.

### 2. Importare il progetto in Visual Studio Code (Esempio di IDE)
Per importare il progetto in Visual Studio Code, è necessario seguire i seguenti passaggi:
1. Aprire Visual Studio Code.
2. Cliccare su "File" -> "Apri cartella...".
3. Selezionare la cartella del progetto scaricato da Spring Initializr.
4. Cliccare su "Apri".
5. Visual Studio Code importerà il progetto e mostrerà la struttura del progetto.
6. Ora è possibile iniziare a lavorare sul progetto.

### 3. Controllare le dipendenze
Per controllare le dipendenze del progetto, è possibile aprire il file "pom.xml" nella radice del progetto. Oltre
alle dipendenze aggiunte in fase di creazione del progetto, dovrai aggiungere alcune dipendenze aggiuntive per il
funzionamento del progetto:
1. Dipendenze per il database MySQL:
    ```xml
    <dependency>
        <groupId>mysql</groupId>
        <artifactId>mysql-connector-j</artifactId>
        <scope>runtime</scope>
    </dependency>
    ```
2. Dipende per il database SQLite:
    ```xml
    <dependency>
        <groupId>org.xerial</groupId>
            <artifactId>sqlite-jdbc</artifactId>
    </dependency>
    ```
3. Dipendenze per Hibernate Community Dialects:
    ```xml
    <dependency>
        <groupId>org.hibernate.orm</groupId>
            <artifactId>hibernate-community-dialects</artifactId>
    </dependency>
    ```
   
### 4. Aggiungere i profili Maven per il database MySQL e SQLite
Per utilizzare il database MySQL e SQLite, è necessario aggiungere i profili 
Maven nel file "pom.xml". I profili Maven permettono di configurare il progetto
per l'utilizzo di un database specifico. Per aggiungere i profili Maven, è necessario
seguire i seguenti passaggi:
1. Aprire il file "pom.xml" nella radice del progetto.
2. Aggiungere i seguenti profili Maven per il database MySQL e SQLite:
    ```xml
    <profiles>
        <profile>
            <id>mysql</id>
            <properties>
                <activatedProperties>mysql</activatedProperties>
            </properties>
        </profile>
        <profile>
            <id>sqlite</id>
            <properties>
                <activatedProperties>sqlite</activatedProperties>
            </properties>
        </profile>
    </profiles>
    ```

### 5. Configurare i file .properties per il database MySQL e SQLite
Per configurare i file .properties per il database MySQL e SQLite, è necessario 
recarsi nella cartella java/resources dove dovranno essere presenti i seguenti file:
1. application.properties:
    ```properties
    spring.application.name=NomeProgetto (dovrebbe già essere presente)
    spring.profiles.active=@activatedProperties@
    ```
2. application-mysql.properties:
    ```properties
    spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
    spring.jpa.hibernate.ddl-auto=create (Dopo il primo avvio deve cambiare in validate)
    spring.jpa.show-sql=true
    spring.datasource.url=jdbc:mysql://127.0.0.1:3306/nomeschema (Cambia nomeschema con il nome dello schema)
    spring.datasource.username=root (Cambia root con il tuo username del database)
    spring.datasource.password=admin (Cambia admin con la password del database)
    ```
3. application-sqlite.properties:
    ```properties
   spring.jpa.database-platform=org.hibernate.community.dialect.SQLiteDialect
   spring.datasource.driver-class-name=org.sqlite.JDBC
   spring.jpa.hibernate.ddl-auto=create (Dopo il primo avvio deve cambiare in validate)
   spring.jpa.show-sql=true
   spring.jpa.open-in-view=false
   spring.datasource.url=jdbc:sqlite:nomefile.db (Cambia nomefile con il nome del file del database)
   spring.datasource.username=sa
   spring.datasource.password=sa
   ```
   
### 6. Creare i package per il progetto
Per creare i package per il progetto, è necessario seguire i seguenti passaggi. 
Sotto il main package del progetto:
1. Creare il package `controller` per i controller del progetto.
2. Creare il package `service` per i servizi del progetto.
3. Creare il package `impl` sotto il package `service` per le implementazioni dei servizi del progetto.
4. Creare il package `repository` per i repository del progetto.
5. Creare il package `model`/`entity` per le entità del progetto.
6. Creare il package `dto` per i DTO (Data Transfer Object) del progetto. (Facoltativo)
7. Creare il package `exception` per le eccezioni personalizzate del progetto. (Facoltativo)
8. Creare il package `httptest` per i test HTTP del progetto. (Facoltativo)

Sotto il test package del progetto:
1. Creare il package `controllertest` per i test dei controller del progetto.
2. Creare il package `servicetest` per i test dei servizi del progetto.
3. Creare il package `repositorytest` per i test dei repository del progetto.

Esempio di package:
```
src
├── main
│   ├── java
│   │   └── it
│   │       └── apuliadigital
│   │           └── nome-progetto
│   │               ├── controller
│   │               ├── service
│   │               │   └── impl
│   │               ├── repository
│   │               ├── model (o entity)
│   │               ├── dto (Facoltativo)
│   │               ├── exception (Facoltativo)
│   │               └── httptest (Facoltativo)
│   └── resources
│       ├── application.properties
│       ├── application-mysql.properties
│       └── application-sqlite.properties
└── test
    └── java
        └── it
            └── apuliadigital
                └── nome-progetto
                    ├── controllertest
                    ├── servicetest
                    └── repositorytest

```




### 7. Creare le entità del progetto
Per creare le entità del progetto, è necessario seguire i seguenti passaggi:
1. Creare una classe per ogni entità del progetto sotto il package `model`/`entity`.
2. Aggiungere le annotazioni `@Entity` e `@Table` (Facoltativo) alla classe per mappare l'entità al database.
3. Aggiungere i campi della classe con le relative annotazioni per mappare i campi al database.
4. Aggiungere i metodi getter e setter per i campi della classe.
5. Aggiungere i metodi `toString()`, `equals()` e `hashCode()` per la classe.

Esempio di entità:
```java
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String username;
    private String email;
    private String password;
    
    // Getter e Setter
    // toString()
    // equals()
    // hashCode()
}
```

### 8. Creare i repository del progetto
Per creare i repository del progetto, è necessario seguire i seguenti passaggi:
1. Creare un'interfaccia per ogni repository del progetto sotto il package `repository`.
2. Estendere l'interfaccia `CrudRepository` per il repository.
3. Aggiungere l'annotazione `@Repository` all'interfaccia per indicare che è un repository.
4. Aggiungere qualche metodo personalizzato per il repository. 
[Vedi esempio](https://docs.spring.io/spring-data/jpa/docs/1.5.1.RELEASE/reference/html/jpa.repositories.html#jpa.query-methods.query-creation)

Esempio di repository:
```java
@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    User findByUsername(String username);
}
```

### 9. Creare i servizi del progetto
Per creare i servizi del progetto, è necessario seguire i seguenti passaggi:
1. Creare un'interfaccia per ogni servizio del progetto sotto il package `service`.
2. Creare un'implementazione per ogni servizio del progetto sotto il package `impl`.
3. Aggiungere l'annotazione `@Service` all'implementazione per indicare che è un servizio.
4. Implementare i metodi dell'interfaccia nel servizio.
5. Iniettare i repository necessari nel servizio con l'annotazione `@Autowired`.

Esempio di servizio:
```java
public interface UserService {
    User findByUsername(String username);
}

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    
    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
```

### 10. Fare i test dei servizi del progetto
Per fare i test dei servizi del progetto, è necessario seguire i seguenti passaggi:
1. Creare una classe di test per ogni servizio del progetto sotto il package `test/servicetest`.
2. Iniettare il servizio da testare con l'annotazione `@Autowired`.
3. Mockare i repository necessari per il test con l'annotazione `@MockBean`.
4. Implementare i test per i metodi del servizio.
5. Utilizzare `@SpringBootTest` per caricare il contesto dell'applicazione.

Esempio di test del servizio:
```java
@SpringBootTest
public class UserServiceTest {
    @Autowired
    private UserService userService;
    
    @MockBean
    private UserRepository userRepository;
    
    @Test
    public void testFindByUsername() {
        User user = new User();
        user.setUsername("test");
        
        when(userRepository.findByUsername("test")).thenReturn(user);
        
        User result = userService.findByUsername("test");
        
        assertEquals(user, result);
    }
}
```

### 11. Creare i controller del progetto
Per creare i controller del progetto, è necessario seguire i seguenti passaggi:
1. Creare una classe per ogni controller del progetto sotto il package `controller`.
2. Aggiungere l'annotazione `@RestController` alla classe per indicare che è un controller REST.
3. Usare l'annotazione @RequestMapping per mappare la classe e i metodi del controller.
4. Iniettare i servizi necessari nel controller con l'annotazione `@Autowired`.
5. Implementare i metodi del controller per gestire le richieste HTTP.
6. Utilizzare le annotazioni `@GetMapping`, `@PostMapping`, `@PutMapping` e `@DeleteMapping` per mappare i metodi alle richieste HTTP.
7. Utilizzare `@RequestBody` per ricevere i dati dalla richiesta HTTP.
8. Utilizzare `@PathVariable` per ricevere i parametri dalla richiesta HTTP.
9. Utilizzare `@RequestParam` per ricevere i parametri dalla richiesta HTTP come query string.
10. Restituire i dati come oggetto o ResponseEntity dal controller in base alla risposta.

Esempio di controller:
```java
@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService userService;
    
    @GetMapping("/{username}")
    public ResponseEntity<User> getUserByUsername(@PathVariable String username) {
        User user = userService.findByUsername(username);
        
        if (user != null) {
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
```

### 12. Come eseguire il progetto
Per eseguire il progetto, è necessario seguire i seguenti passaggi:
1. Aprire il terminale nel vostro IDE.
2. Eseguire il comando sottostante in base al database che si vuole utilizzare:
    - Per MySQL:

           ```bash
            mvn clean install -Pmysql
            mvn spring-boot:run -Pmysql
           ```
    - Per SQLite:
   
           ```bash
            mvn clean install -Psqlite
            mvn spring-boot:run -Psqlite
           ```
    - Per eseguire il progetto senza profili:
   
           ```bash
            mvn clean install
            mvn spring-boot:run
           ```
- Il progetto verrà avviato e sarà possibile accedere ai servizi REST tramite il browser 
o Postman o tramite i file di test HTTP. Esempio di file di test HTTP:
```http
POST http://localhost:8080/api/users HTTP/1.1
Content-Type: application/json

{
    "username": "test",
    "email": "prova",
    "password": "test"
}

GET http://localhost:8080/api/users/1 HTTP/1.1

DELETE http://localhost:8080/api/users/1 HTTP/1.1

PUT http://localhost:8080/api/users/1 HTTP/1.1
Content-Type: application/json

{
    "username": "Aggiornato",
    "email": "Aggiornato",
    "password": "Aggiornato"
}
```

### 13. Come eseguire i test del progetto
Per eseguire i test del progetto, è necessario seguire i seguenti passaggi:
1. Aprire il terminale nel vostro IDE.
2. Cliccare sul pulsante "Run" vicino al nome del test per eseguire il test, i test verranno eseguiti e verrà 
visualizzato il risultato.
3. È possibile eseguire tutti i test del progetto cliccando sul pulsante "Run All Tests" nella finestra dei test.


### 14. Come lavorare con il progetto su IntelliJ IDEA
Per lavorare con il progetto su IntelliJ IDEA, è necessario seguire i seguenti passaggi:
1. Aprire IntelliJ IDEA.
2. Cliccare su "File" -> "Apri...".
3. Selezionare la cartella del progetto scaricato da Spring Initializr.
4. Cliccare su "Apri".
5. IntelliJ IDEA importerà il progetto e in alto a destra verrà visualizzata la finestra "Load Maven Changes".
6. Per eseguire il progetto, andare da terminale come scritto sopra e digitare i comandi per eseguire il progetto.
7. Per eseguire i test, cliccare sul pulsante "Run" vicino al nome del test per eseguire il test.
8. È possibile eseguire tutti i test del progetto cliccando sul pulsante "Run All Tests" nella finestra dei test.


### Contatti
Per qualsiasi domanda o suggerimento puoi contattarmi tramite [email](mailto:filippoaprilee@gmail.com).

Grazie per aver visitato la mia repository!

@2024 Filippo Aprile