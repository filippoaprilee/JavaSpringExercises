package it.apuliadigital.templateesame.service.impl;

import it.apuliadigital.templateesame.repository.TemplateRepository;
import it.apuliadigital.templateesame.service.TemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TemplateServiceImpl implements TemplateService {

    @Autowired
    private TemplateRepository templateRepository;

    // TODO: Implementa i metodi del service TemplateService
}
