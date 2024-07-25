package br.com.techSolution.projetoAgentes.service;

import br.com.techSolution.projetoAgentes.dto.TurnoDTO;
import br.com.techSolution.projetoAgentes.entity.AgenteEntity;
import br.com.techSolution.projetoAgentes.entity.TurnoEntity;
import br.com.techSolution.projetoAgentes.repository.AgenteRepository;
import br.com.techSolution.projetoAgentes.repository.TurnoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TurnoService {

    @Autowired
    private TurnoRepository turnoRepository;

    @Autowired
    private AgenteRepository agenteRepository;

    public List<TurnoDTO> listarTodos() {
        List<TurnoEntity> turno = turnoRepository.findAll();
        return turno.stream().map(TurnoDTO::new).toList();
    }

    public TurnoEntity criarTurno(TurnoDTO turnoDTO) {
        AgenteEntity agente = agenteRepository.findById(turnoDTO.getCodAgente())
                .orElseThrow(() -> new RuntimeException("Agente não encontrado"));

        TurnoEntity turnoEntity = new TurnoEntity();
        turnoEntity.setCodAgente(agente.getCodAgente()); // Define explicitamente a relação

        // Copia as demais propriedades do DTO para a entidade
        turnoEntity.setTipoTurno(turnoDTO.getTipoTurno());
        turnoEntity.setDataInicio(turnoDTO.getDataInicio());
        turnoEntity.setDataFim(turnoDTO.getDataFim());
        turnoEntity.setExtra(turnoDTO.isExtra());
        turnoEntity.setFeriado(turnoDTO.isFeriado());
        turnoEntity.setMinutosPerdidos(turnoDTO.getMinutosPerdidos());

        return turnoRepository.save(turnoEntity);
    }

}
