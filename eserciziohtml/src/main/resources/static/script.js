// Quando il documento è completamente caricato, esegui la funzione
document.addEventListener('DOMContentLoaded', function() {
    // Seleziona il form e il div che conterrà la lista delle persone
    const form = document.getElementById('personaForm');
    const personasList = document.getElementById('personasList');

    // Funzione per gestire l'aggiunta o l'aggiornamento di una persona nella lista visuale
    function handlePersonaUpdate(persona) {
        // Rimuovi la persona dalla lista se è già presente (per evitare duplicati)
        document.querySelectorAll(`.persona[data-id="${persona.id}"]`).forEach(element => element.remove());
        // Aggiungi la persona aggiornata alla lista
        addPersonaToList(persona);
    }

    // Funzione per gestire l'eliminazione di una persona dalla lista visuale
    function handlePersonaDelete(id) {
        // Rimuovi la persona dalla lista visuale
        document.querySelector(`.persona[data-id="${id}"]`).remove();
    }


    // Aggiungi un event listener al form per gestire il submit
    form.addEventListener('submit', function(event) {
        event.preventDefault(); // Previene il comportamento predefinito del submit

        const id = document.getElementById('personaId').value;
        const nome = document.getElementById('nome').value;
        const cognome = document.getElementById('cognome').value;

        const method = id ? 'PUT' : 'POST';
        const url = id ? `/api/persona/update/${id}` : '/api/persona/create';

        fetch(url, {
            method: method,
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({ nome: nome, cognome: cognome })
        })
            .then(response => response.json()) // Parsa la risposta JSON
            .then(persona => {
                if (id) {
                    // Se l'ID esiste, gestisci l'aggiornamento della persona
                    handlePersonaUpdate(persona);
                } else {
                    // Se è una nuova persona, aggiungila alla lista
                    addPersonaToList(persona);
                }
                form.reset(); // Resetta il form
                document.getElementById('personaId').value = ''; // Resetta l'input nascosto per l'ID
                loadPersonas(); // Ricarica la lista delle persone dopo l'aggiunta/aggiornamento
            })
            .catch(error => {
                console.error('Error during persona creation or update:', error);
            });
    });

    // Funzione per caricare tutte le persone esistenti ordinandole per ID
    function loadPersonas() {
        // Effettua una chiamata fetch per ottenere tutte le persone
        fetch('/api/persona/all')
            .then(response => response.json()) // Parsa la risposta JSON
            .then(personas => {
                // Ordina le persone per ID (assicurandosi che siano numeri interi)
                personas.sort((a, b) => parseInt(a.id) - parseInt(b.id));

                // Svuota la lista delle persone
                personasList.innerHTML = '';

                // Aggiungi ogni persona alla lista visuale
                personas.forEach(persona => {
                    addPersonaToList(persona);
                });
            });
    }

    // Funzione per aggiungere una persona alla lista visuale
    function addPersonaToList(persona) {
        // Crea un nuovo div per rappresentare la persona
        const personaDiv = document.createElement('div');
        personaDiv.className = 'persona';
        personaDiv.dataset.id = persona.id;
        // Imposta l'HTML del div con il nome, cognome e pulsanti
        personaDiv.innerHTML = `
            ${persona.nome} ${persona.cognome}
            <div class="buttons">
                <button class="update-button" onclick="updatePersona(${persona.id})">Aggiorna</button>
                <button class="delete-button" onclick="deletePersona(${persona.id})">Rimuovi</button>
            </div>
        `;
        // Aggiungi il div al contenitore della lista
        personasList.appendChild(personaDiv);
    }

    // Funzione per aggiornare una persona
    window.updatePersona = function(id) {
        fetch(`/api/persona/${id}`)
            .then(response => response.json()) // Parla la risposta JSON
            .then(persona => {
                document.getElementById('personaId').value = persona.id;
                document.getElementById('nome').value = persona.nome;
                document.getElementById('cognome').value = persona.cognome;
            })
            .catch(error => {
                console.error('Error fetching persona details:', error);
            });
    }

    // Funzione per cancellare una persona
    window.deletePersona = function(id) {
        fetch(`/api/persona/delete/${id}`, {
            method: 'DELETE'
        })
            .then(() => {
                handlePersonaDelete(id); // Gestisci l'eliminazione dalla lista visuale
            })
            .catch(error => {
                console.error('Error deleting persona:', error);
            });
    }

    // Carica tutte le persone all'inizio
    loadPersonas();
});