package it.apuliadigital.rubricaprojectpro.controller;

import it.apuliadigital.rubricaprojectpro.entity.ContattoEntity;
import it.apuliadigital.rubricaprojectpro.exception.ContattoException;
import it.apuliadigital.rubricaprojectpro.exception.ErrorResponse;
import it.apuliadigital.rubricaprojectpro.exception.SuccessResponse;
import it.apuliadigital.rubricaprojectpro.service.ContattoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contatti")
public class ContattoController {

    @Autowired
    private ContattoService contattoService;

    @PostMapping
    public SuccessResponse<Integer> aggiungiContatto(@RequestBody ContattoEntity contatto) {
        int id = contattoService.aggiungiContatto(contatto);
        return new SuccessResponse<>(HttpStatus.CREATED.value(), "Contatto aggiunto con successo", id);
    }

    @DeleteMapping("/{id}")
    public SuccessResponse<String> rimuoviContatto(@PathVariable int id) {
        boolean success = contattoService.rimuoviContatto(id);
        if (success) {
            return new SuccessResponse<>(HttpStatus.OK.value(), "Contatto rimosso con successo");
        }
        return new SuccessResponse<>(HttpStatus.NOT_FOUND.value(), "Contatto non trovato");
    }

    @PutMapping("/{id}")
    public SuccessResponse<String> aggiornaContatto(@PathVariable int id, @RequestBody ContattoEntity contatto) {
        boolean success = contattoService.aggiornaContatto(id, contatto);
        if (success) {
            return new SuccessResponse<>(HttpStatus.OK.value(), "Contatto aggiornato con successo");
        }
        return new SuccessResponse<>(HttpStatus.NOT_FOUND.value(), "Contatto non trovato");
    }

    @GetMapping("/{id}")
    public SuccessResponse<ContattoEntity> trovaContatto(@PathVariable int id) {
        ContattoEntity contatto = contattoService.trovaContatto(id);
        if (contatto != null) {
            return new SuccessResponse<>(HttpStatus.OK.value(), "Contatto trovato con successo", contatto);
        }
        return new SuccessResponse<>(HttpStatus.NOT_FOUND.value(), "Contatto non trovato");
    }

    @GetMapping
    public SuccessResponse<List<ContattoEntity>> trovaContatti() {
        List<ContattoEntity> contatti = contattoService.trovaContatti();
        return new SuccessResponse<>(HttpStatus.OK.value(), "Contatti trovati con successo", contatti);
    }

    @GetMapping("/cerca")
    public SuccessResponse<List<ContattoEntity>> cercaContatti(@RequestParam(value = "nome", required = false) String nome,
                                                               @RequestParam(value = "cognome", required = false) String cognome) {
        List<ContattoEntity> contatti = contattoService.cercaContatti(nome, cognome);
        return new SuccessResponse<>(HttpStatus.OK.value(), "Contatti trovati con successo", contatti);
    }

    // metodo per gestire le eccezioni
    @ExceptionHandler(value = ContattoException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse handleContactsNotFound(ContattoException e) {
        return new ErrorResponse(HttpStatus.NOT_FOUND.value(), e.getMessage());
    }
}
