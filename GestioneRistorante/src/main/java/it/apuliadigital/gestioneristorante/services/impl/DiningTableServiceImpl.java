package it.apuliadigital.gestioneristorante.services.impl;

import it.apuliadigital.gestioneristorante.entities.DiningTable;
import it.apuliadigital.gestioneristorante.entitiesdto.DiningTableDTO;
import it.apuliadigital.gestioneristorante.repositories.DiningTableRepository;
import it.apuliadigital.gestioneristorante.services.DiningTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiningTableServiceImpl implements DiningTableService {

    @Autowired
    private DiningTableRepository tableRepository;

    @Override
    public boolean addTable(DiningTableDTO tableDTO) {
        try {
            DiningTable table = fromDTOToTable(tableDTO);
            tableRepository.save(table);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean getTables(List<DiningTableDTO> tableDTOList) {
        try {
            List<DiningTable> tables = tableRepository.findAll();
            for (DiningTable table : tables) {
                tableDTOList.add(fromTableToDTO(table));
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean getTableById(Long id, DiningTableDTO tableDTO) {
        if (tableRepository.existsById(id)) {
            try {
                DiningTable table = tableRepository.findById(id).get();
                tableDTO.setSeats(fromTableToDTO(table).getSeats());
                return true;
            } catch (Exception e) {
                return false;
            }
        }
        return false;
    }

    @Override
    public boolean updateTable(Long id, DiningTableDTO tableDTO) {
        if (tableRepository.existsById(id)) {
            try {
                DiningTable foundTable = tableRepository.findById(id).get();
                foundTable = fromDTOToTable(tableDTO);
                tableRepository.save(foundTable);
                return true;
            } catch (Exception e) {
                return false;
            }
        }
        return false;
    }

    @Override
    public boolean deleteTable(Long id) {
        if (tableRepository.existsById(id)) {
            try {
                tableRepository.deleteById(id);
                return true;
            } catch (Exception e) {
                return false;
            }
        }
        return false;
    }

    private DiningTableDTO fromTableToDTO(DiningTable table) {
        DiningTableDTO tableDTO = new DiningTableDTO();
        tableDTO.setSeats(table.getSeats());
        return tableDTO;
    }

    private DiningTable fromDTOToTable(DiningTableDTO tableDTO) {
        DiningTable table = new DiningTable();
        table.setSeats(tableDTO.getSeats());
        return table;
    }


}
