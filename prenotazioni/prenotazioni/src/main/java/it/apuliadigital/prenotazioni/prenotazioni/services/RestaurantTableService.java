package it.apuliadigital.prenotazioni.prenotazioni.services;

import java.util.List;

import it.apuliadigital.prenotazioni.prenotazioni.entities.RestaurantTable;
import it.apuliadigital.prenotazioni.prenotazioni.entitiesDTO.RestaurantTableDTO;

public interface RestaurantTableService {
    public boolean addTable(RestaurantTableDTO tableDTO);

    public boolean removeTable(long id);

    public RestaurantTableDTO getTable(long id);

    public List<RestaurantTableDTO> getTables();

    public boolean updateTable(long id, RestaurantTableDTO tableDTO);

    public RestaurantTableDTO fromTabletoDTO(RestaurantTable table, RestaurantTableDTO tableDTO);

    public RestaurantTable fromDTOtoTable(RestaurantTableDTO tableDTO, RestaurantTable table);
}
