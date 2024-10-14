package it.apuliadigital.Museo.service.impl;

import it.apuliadigital.Museo.entity.OperaEntity;
import it.apuliadigital.Museo.mapper.OperaMapper;
import it.apuliadigital.Museo.model.Opera;
import it.apuliadigital.Museo.repository.OperaRepository;
import it.apuliadigital.Museo.service.OperaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OperaServiceImpl implements OperaService {

    @Autowired
    private OperaRepository operaRepository;

    @Autowired
    private OperaMapper operaMapper;

    @Override
    public Opera getOperaById(Long idOpera) {
        return operaRepository.findById(idOpera).map(operaMapper::toDto).orElse(null);
    }

    @Override
    public Opera createOpera(Opera opera) {
       OperaEntity entity = operaMapper.toEntity(opera);
         operaRepository.save(entity);
            opera.setIdOpera(entity.getIdOpera());
            return opera;
    }

    @Override
    public boolean updateOpera(Long id, Opera opera) {
        if (operaRepository.existsById(id)) {
            OperaEntity entity = operaMapper.toEntity(opera);
            entity.setIdOpera(id);
            operaRepository.save(entity);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteOpera(Long id) {
        if (operaRepository.existsById(id)) {
            operaRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public List<Opera> getAllOperas() {
        return operaRepository.findAll().stream().map(operaMapper::toDto).collect(Collectors.toList());
    }
}
