package it.apuliadigital.gestioneristorante.services;

import it.apuliadigital.gestioneristorante.entitiesdto.DiningTableDTO;

import java.util.List;

public interface DiningTableService {
    boolean addTable(DiningTableDTO tableDTO);
    boolean getTables(List<DiningTableDTO> tableDTOList);
    boolean getTableById(Long id, DiningTableDTO tableDTO);
    boolean updateTable(Long id, DiningTableDTO tableDTO);
    boolean deleteTable(Long id);
}
