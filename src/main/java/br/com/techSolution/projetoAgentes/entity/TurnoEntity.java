package br.com.techSolution.projetoAgentes.entity;

import br.com.techSolution.projetoAgentes.dto.TurnoDTO;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import org.springframework.beans.BeanUtils;

import java.time.LocalDateTime;
import java.util.Objects;

@Data
@Entity
@Table(name = "TECH_TURNOS")
public class TurnoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long agentId;

    @Column(nullable = false)
    private String tipoTurno;

    @Column(nullable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDateTime dataInicio;

    @Column(nullable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDateTime dataFim;

    @Column(nullable = false)
    private boolean extra;

    @Getter
    private boolean feriado;

    private int minutosPerdidos;

    public TurnoEntity() {}

    public boolean isTurnoDia() {
        return "diurno".equalsIgnoreCase(this.tipoTurno);
    }

    public TurnoEntity(TurnoDTO turno) {
        BeanUtils.copyProperties(turno, this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TurnoEntity that = (TurnoEntity) o;
        return extra == that.extra && feriado == that.feriado && minutosPerdidos == that.minutosPerdidos && Objects.equals(id, that.id) && Objects.equals(agentId, that.agentId) && Objects.equals(tipoTurno, that.tipoTurno) && Objects.equals(dataInicio, that.dataInicio) && Objects.equals(dataFim, that.dataFim);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, agentId, tipoTurno, dataInicio, dataFim, extra, feriado, minutosPerdidos);
    }
}
