package br.com.techSolution.projetoAgentes.dto;

import br.com.techSolution.projetoAgentes.entity.AgenteEntity;
import br.com.techSolution.projetoAgentes.entity.TurnoEntity;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import java.time.LocalDateTime;

@Data
public class TurnoDTO {

    private Long agentId;
    private String tipoTurno;
    private LocalDateTime dataInicio;
    private LocalDateTime dataFim;
    private boolean extra;
    private boolean feriado;
    private int minutosPerdidos;

    public TurnoDTO(TurnoEntity Turno) {
        BeanUtils.copyProperties(Turno, this);
    }

    public TurnoDTO() {}


}
