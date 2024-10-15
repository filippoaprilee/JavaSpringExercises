package it.apuliadigital.Museo.service;

import it.apuliadigital.Museo.model.Opera;

import java.util.List;

public interface OperaService {
    List<Opera> getAllOperas();
    Opera getOperaById(Long idOpera);
    Opera createOpera(Opera opera);
    boolean updateOpera(Long id, Opera opera);
    boolean deleteOpera(Long id);
}
