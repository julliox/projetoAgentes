package br.com.techSolution.projetoAgentes.service;



import br.com.techSolution.projetoAgentes.dto.AgenteDTO;
import br.com.techSolution.projetoAgentes.entity.AgenteEntity;
import br.com.techSolution.projetoAgentes.repository.AgenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AgenteService {

    @Autowired
    private AgenteRepository agenteRepository;

    public List<AgenteDTO> listarTodos() {
        List<AgenteEntity> agentes = agenteRepository.findAll();
        return agentes.stream().map(AgenteDTO::new).toList();
    }

    public String criaAgente(AgenteDTO agente) {
        AgenteEntity agenteEntity = new AgenteEntity(agente);
        agenteRepository.save(agenteEntity);
        return "User registered successfully";
    }

}
