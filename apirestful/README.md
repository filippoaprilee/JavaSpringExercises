@Service
public class PersonaServiceImpl implements PersonaService {

    private static final String JSON_FILE_PATH = "persone.json";
    private Map<Integer, Persona> personaMap = new HashMap<>();
    private int idCounter = 1;

    public PersonaServiceImpl() {
        caricaPersoneDaFile(); // Carica le persone dal file JSON all'avvio
    }

    public void caricaPersoneDaFile() {
        try {
            File file = new File(JSON_FILE_PATH);

            // Se il file non esiste, crea un nuovo file vuoto
            if (!file.exists()) {
                file.createNewFile();
            }

            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            StringBuilder stringBuilder = new StringBuilder();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line);
            }
            JSONArray jsonArray = new JSONArray(stringBuilder.toString());
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                try {
                    Persona persona = new Persona(jsonObject);
                    persona.setId(idCounter++);
                    personaMap.put(persona.getId(), persona);
                } catch (Exception e) {
                    System.err.println("Errore nella lettura del JSON per la persona #" + i + ": " + e.getMessage());
                }
            }
            bufferedReader.close(); // Chiudi il BufferedReader dopo l'uso
        } catch (IOException | JSONException e) {
            e.printStackTrace();
        }
    }

    // Resto del codice per implementare le interfacce PersonaService
}