package it.apuliadigital.templateesame.controller;

import it.apuliadigital.templateesame.entity.TemplateEntity;
import it.apuliadigital.templateesame.exception.ErrorResponse;
import it.apuliadigital.templateesame.exception.SuccessResponse;
import it.apuliadigital.templateesame.exception.TemplateException;
import it.apuliadigital.templateesame.service.TemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/template")
public class TemplateController {

    @Autowired
    private TemplateService templateService;

    @PostMapping
    public SuccessResponse</*Output*/> aggiungiTemplate(/*@RequestBody Input*/) {
        // TODO: implementare il metodo aggiungiTemplate
        return new SuccessResponse<>(/*HttpStatus.CREATED.value()*/, "Template aggiunto con successo"/*, id*/);
    }

    @GetMapping
    public void trovaTemplate(@PathVariable int id) {
        // TODO: implementare il metodo trovaTemplate
    }

    @PutMapping
    public void aggiornaTemplate() {
        // TODO: implementare il metodo aggiornaTemplate
    }

    @DeleteMapping
    public void rimuoviTemplate() {
        // TODO: implementare il metodo rimuoviTemplate
    }

    @GetMapping("/cerca")
    public SuccessResponse<List<TemplateEntity>> cercaTemplate(@RequestParam(value = "nome", required = false) String nome,
                                                               @RequestParam(value = "cognome", required = false) String cognome) {
        List<TemplateEntity> contatti = templateService.cercaTemplate(nome, cognome);
        return new SuccessResponse<>(HttpStatus.OK.value(), "Contatti trovati con successo", contatti);
    }

    // metodo per gestire le eccezioni
    @ExceptionHandler(value = TemplateException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse handleTemplatesNotFound(TemplateException e) {
        return new ErrorResponse(HttpStatus.NOT_FOUND.value(), e.getMessage());
    }
}
