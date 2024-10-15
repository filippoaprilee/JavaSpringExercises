package it.apuliadigital.Museo.mapper;

import it.apuliadigital.Museo.entity.OperaEntity;
import it.apuliadigital.Museo.model.Opera;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OperaMapper {

    // Mappa da Entity a DTO
    Opera toDto(OperaEntity operaEntity);

    // Mappa da DTO a Entity
    OperaEntity toEntity(Opera operaDTO);
}