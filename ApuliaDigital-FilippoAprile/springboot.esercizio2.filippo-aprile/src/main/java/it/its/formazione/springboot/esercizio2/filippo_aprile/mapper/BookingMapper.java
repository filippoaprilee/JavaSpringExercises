package it.its.formazione.springboot.esercizio2.filippo_aprile.mapper;

import it.its.formazione.springboot.esercizio2.filippo_aprile.entity.BookingEntity;
import it.its.formazione.springboot.esercizio2.filippo_aprile.model.BookingDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface BookingMapper {

    // Mapping da Entity a DTO
    @Mapping(source = "guest", target = "guestName")
    BookingDTO toDTO(BookingEntity entity);

    // Mapping da DTO a Entity
    @Mapping(source = "guestName", target = "guest")
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    BookingEntity toEntity(BookingDTO dto);
}
