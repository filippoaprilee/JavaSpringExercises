package it.apuliadigital.prenotazioni.prenotazioni.services.impls;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.apuliadigital.prenotazioni.prenotazioni.entities.RestaurantTable;
import it.apuliadigital.prenotazioni.prenotazioni.entitiesDTO.RestaurantTableDTO;
import it.apuliadigital.prenotazioni.prenotazioni.repositories.RestaurantTableRepository;
import it.apuliadigital.prenotazioni.prenotazioni.services.RestaurantTableService;

@Service
public class TableServiceImpl implements RestaurantTableService {

    @Autowired
    private RestaurantTableRepository tableRepository;

    @Override
    public boolean addTable(RestaurantTableDTO tableDTO) {

        try {
            RestaurantTable table = new RestaurantTable();
            table.setSeats(tableDTO.getSeats());
            table.setTableType(tableDTO.getTableType());
            tableRepository.save(table);
            return true;
        } catch (Exception e) {
            return false;
        }

    }

    @Override
    public boolean removeTable(long id) {

        try {
            tableRepository.findById(id).get(); // risolto ma bruttino
            tableRepository.deleteById(id); // TODO torna sempre true perchè ignora se non trova l'entità 
            return true;
        } catch (Exception e) {
            return false;
        }

    }

    @Override
    public RestaurantTableDTO getTable(long id) {

        try {
            return fromTabletoDTO(tableRepository.findById(id).get(), new RestaurantTableDTO());
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<RestaurantTableDTO> getTables() {
        try {
            List<RestaurantTable> listTable = tableRepository.findAll();
            List<RestaurantTableDTO> listTableDTO = new ArrayList<RestaurantTableDTO>();

            // listTable.stream().forEach(x->listTableDTO.add(fromTabletoDTO(x, new TableDTO()))); TODO test

            for (RestaurantTable x : listTable) {
                listTableDTO.add(fromTabletoDTO(x, new RestaurantTableDTO()));
            }
            return listTableDTO;

        } catch (Exception e) {
            return null;
        }

    }

    @Override
    public boolean updateTable(long id, RestaurantTableDTO tableDTO) {

        try {
            tableRepository.save(fromDTOtoTable(tableDTO, tableRepository.findById(id).get()));
            return true;
        } catch (Exception e) {
            return false;
        }

    }

    public RestaurantTableDTO fromTabletoDTO(RestaurantTable table, RestaurantTableDTO tableDTO) {
        tableDTO.setSeats(table.getSeats());
        tableDTO.setTableType(table.getTableType());
        return tableDTO;
    }

    /// <summary>
    /// metodo che prende in input un DTO e un oggetto e ritorna l'oggetto aggiornato con i dati del DTO.
    /// </summary>  
    //TODO esistono questo tipo di commenti in java?
    public RestaurantTable fromDTOtoTable(RestaurantTableDTO tableDTO, RestaurantTable table) {
        table.setSeats(tableDTO.getSeats());
        table.setTableType(tableDTO.getTableType());
        return table;
    }
}
