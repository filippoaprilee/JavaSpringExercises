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

@RestController
public class ${ENTITY_NAME}Controller {
    // TODO: Aggiungi i metodi del controller qui
    // TODO: Ricordati di implementare l'API dal generated-sources (tipo NomeDTOApi)
}
EOL

# Crea la classe del repository
cat <<EOL > "$BASE_PATH/repository/${ENTITY_NAME}Repository.java"
package $BASE_PACKAGE.repository;


public interface ${ENTITY_NAME}Repository extends JpaRepository<${ENTITY_NAME}Entity, Long> {
    // Aggiungi query personalizzate qui se necessario
}
EOL

# Crea la classe del service
cat <<EOL > "$BASE_PATH/service/${ENTITY_NAME}Service.java"
package $BASE_PACKAGE.service;

public interface ${ENTITY_NAME}Service {
    // TODO: Aggiungi metodi del service qui
}
EOL

# Crea la classe del service implementation
cat <<EOL > "$BASE_PATH/service/serviceImpl/${ENTITY_NAME}ServiceImpl.java"
package $BASE_PACKAGE.service.serviceImpl;

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

@Mapper(componentModel = "spring")
public interface ${ENTITY_NAME}Mapper {
    // TODO: Aggiungi metodi di mapping qui se necessario
    // Mappa da Entity a DTO
    // Mappa da DTO a Entity
}
EOL

echo "Struttura dei package e delle classi per $ENTITY_NAME e la classe principale $PROJECT_NAMEApplication creata con successo in $BASE_PATH!"
