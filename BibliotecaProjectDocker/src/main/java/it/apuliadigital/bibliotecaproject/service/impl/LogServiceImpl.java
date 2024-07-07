package it.apuliadigital.bibliotecaproject.service.impl;

import it.apuliadigital.bibliotecaproject.entity.LogEntity;
import it.apuliadigital.bibliotecaproject.repository.LogRepository;
import it.apuliadigital.bibliotecaproject.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class LogServiceImpl implements LogService {

    @Autowired
    private LogRepository logRepository;

    @Override
    public void saveLog(String path, String message) {
        LogEntity log = new LogEntity();
        log.setPath(path);
        log.setMessage(message);
        log.setTimestamp(LocalDateTime.now());
        logRepository.save(log);
    }
}