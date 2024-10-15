package it.apuliadigital.Ristorante.service.serviceImpl;

import it.apuliadigital.Ristorante.service.PietanzaService;
import it.apuliadigital.Ristorante.repository.PietanzaRepository;
import it.apuliadigital.Ristorante.mapper.PietanzaMapper;
import it.apuliadigital.Ristorante.entity.PietanzaEntity;
import it.apuliadigital.Ristorante.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PietanzaServiceImpl implements PietanzaService {
    @Autowired
    private PietanzaRepository repository;

    @Autowired
    private PietanzaMapper mapper;

    // TODO: Aggiungi implementazioni dei metodi del service qui
}
