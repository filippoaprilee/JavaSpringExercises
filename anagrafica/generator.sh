#!/bin/bash

# Controlla se è stato fornito un argomento
if [ $# -ne 2 ]; then
  echo "Usage: $0 <EntityName> <ProjectName>"
  exit 1
fi

ENTITY_NAME=$1
PROJECT_NAME=$2
BASE_PACKAGE="it.apuliadigital.${PROJECT_NAME}" # Cambia questo con il tuo pacchetto base
ENTITY_LOWERCASE=$(echo $ENTITY_NAME | tr '[:upper:]' '[:lower:]')

# Definisci il percorso base
BASE_PATH="src/main/java/${BASE_PACKAGE//.//}"

# Definisci i percorsi per model e api
MODEL_PATH="$BASE_PACKAGE.model.*"
API_PATH="$BASE_PACKAGE.model.api"

# Crea i package
mkdir -p "$BASE_PATH/controller"
mkdir -p "$BASE_PATH/entity"
mkdir -p "$BASE_PATH/mapper"
mkdir -p "$BASE_PATH/repository"
mkdir -p "$BASE_PATH/service"
mkdir -p "$BASE_PATH/service/serviceImpl"

# Crea la classe dell'entità
cat <<EOL > "$BASE_PATH/entity/${ENTITY_NAME}Entity.java"
package $BASE_PACKAGE.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class ${ENTITY_NAME}Entity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // TODO: Aggiungi altri campi qui
    // TODO: Ricordati che puoi usare  @Enumerated(EnumType.STRING)

    // Getters e Setters
}
EOL

# Crea la classe del controller
cat <<EOL > "$BASE_PATH/controller/${ENTITY_NAME}Controller.java"
package $BASE_PACKAGE.controller;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class ${ENTITY_NAME}Controller {
    // TODO: Aggiungi i metodi del controller qui
    // TODO: Ricordati di implementare l'API dal generated-sources (tipo NomeDTOApi)
}
EOL

# Crea la classe del repository
cat <<EOL > "$BASE_PATH/repository/${ENTITY_NAME}Repository.java"
package $BASE_PACKAGE.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import $BASE_PACKAGE.entity.${ENTITY_NAME}Entity;

public interface ${ENTITY_NAME}Repository extends JpaRepository<${ENTITY_NAME}Entity, Long> {
    // Aggiungi query personalizzate qui se necessario
}
EOL

# Crea la classe del service
cat <<EOL > "$BASE_PATH/service/${ENTITY_NAME}Service.java"
package $BASE_PACKAGE.service;

import $MODEL_PATH;

import java.util.List;

public interface ${ENTITY_NAME}Service {
    // TODO: Aggiungi metodi del service qui
}
EOL

# Crea la classe del service implementation
cat <<EOL > "$BASE_PATH/service/serviceImpl/${ENTITY_NAME}ServiceImpl.java"
package $BASE_PACKAGE.service.serviceImpl;

import $BASE_PACKAGE.service.${ENTITY_NAME}Service;
import $BASE_PACKAGE.repository.${ENTITY_NAME}Repository;
import $BASE_PACKAGE.mapper.${ENTITY_NAME}Mapper;
import $BASE_PACKAGE.entity.${ENTITY_NAME}Entity;
import $MODEL_PATH;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ${ENTITY_NAME}ServiceImpl implements ${ENTITY_NAME}Service {
    @Autowired
    private ${ENTITY_NAME}Repository repository;

    @Autowired
    private ${ENTITY_NAME}Mapper mapper;

    // TODO: Aggiungi implementazioni dei metodi del service qui
}
EOL

# Crea la classe del mapper (opzionale)
cat <<EOL > "$BASE_PATH/mapper/${ENTITY_NAME}Mapper.java"
package $BASE_PACKAGE.mapper;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public class ${ENTITY_NAME}Mapper {
    // TODO: Aggiungi metodi di mapping qui se necessario
    // Mappa da Entity a DTO
    // Mappa da DTO a Entity
}
EOL

# Crea la classe LoggingController
cat <<EOL > "$BASE_PATH/controller/LoggingController.java"
package $BASE_PACKAGE.controller;

import io.swagger.v3.oas.annotations.Hidden;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Hidden
@RestController
public class LoggingController {

    Logger logger = LoggerFactory.getLogger(LoggingController.class);

    @RequestMapping("/log")
    public String index() {
        logger.trace("A TRACE Message");
        logger.debug("A DEBUG Message");
        logger.info("An INFO Message");
        logger.warn("A WARN Message");
        logger.error("An ERROR Message");

        return "Howdy! Check out the Logs to see the output...";
    }
}
EOL

# Crea la classe principale dell'applicazione
cat <<EOL > "$BASE_PATH/${PROJECT_NAME}Application.java"
package it.apuliadigital.$PROJECT_NAME;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ${PROJECT_NAME}Application {

    public static void main(String[] args) {
        SpringApplication.run(${PROJECT_NAME}Application.class, args);
    }
}
EOL

echo "Struttura dei package e delle classi per $ENTITY_NAME e la classe principale $PROJECT_NAMEApplication creata con successo in $BASE_PATH!"
