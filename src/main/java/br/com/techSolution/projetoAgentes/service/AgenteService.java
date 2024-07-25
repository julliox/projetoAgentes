package br.com.techSolution.projetoAgentes.service;



import br.com.techSolution.projetoAgentes.dto.AgenteDTO;
import br.com.techSolution.projetoAgentes.entity.AgenteEntity;
import br.com.techSolution.projetoAgentes.repository.AgenteRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
@Service
public class AgenteService {

    @Autowired
    private AgenteRepository agenteRepository;

    public List<AgenteDTO> listarTodos() {
        List<AgenteEntity> agentes = agenteRepository.findAll();
        return agentes.stream().map(AgenteDTO::new).toList();
    }

    public AgenteEntity criaAgente(AgenteDTO agenteDTO) {
        AgenteEntity agenteEntity = new AgenteEntity();
        BeanUtils.copyProperties(agenteDTO, agenteEntity);
        agenteEntity.setSalarioBase(0);

        // Verificar se o agente tem mais de um ano de serviço
        if (Period.between(agenteEntity.getDataContratacao(), LocalDate.now()).getYears() > 1) {
            agenteEntity.setDireitoBolsaIdioma(true);
            agenteEntity.setDireitoPlanoSaude(true);
        } else {
            agenteEntity.setDireitoBolsaIdioma(false);
            agenteEntity.setDireitoPlanoSaude(false);
        }

        return agenteRepository.save(agenteEntity);
    }

}
