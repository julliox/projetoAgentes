package br.com.techSolution.projetoAgentes.entity;

import br.com.techSolution.projetoAgentes.dto.AgenteDTO;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import java.time.LocalDate;
import java.time.Period;
import java.util.Objects;

@Data
@Entity
@Table(name = "TECH_AGENTES")
public class AgenteEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codAgente;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate dataContratacao;

    @Column()
    private float salarioBase;


    //TODO VERIFICAR ESSES CAMPOS
    @Column(nullable = false)
    private boolean direitoBolsaIdioma;

    @Column(nullable = false)
    private boolean direitoPlanoSaude;

    public AgenteEntity(AgenteDTO agente) {
        BeanUtils.copyProperties(agente, this);
    }

    public AgenteEntity() {}

    public int getTempoServicoEmAnos() {
        return Period.between(this.dataContratacao, LocalDate.now()).getYears();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AgenteEntity that = (AgenteEntity) o;
        return Float.compare(that.salarioBase, salarioBase) == 0 && direitoBolsaIdioma == that.direitoBolsaIdioma && direitoPlanoSaude == that.direitoPlanoSaude && Objects.equals(codAgente, that.codAgente) && Objects.equals(nome, that.nome) && Objects.equals(email, that.email) && Objects.equals(dataContratacao, that.dataContratacao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codAgente, nome, email, dataContratacao, salarioBase, direitoBolsaIdioma, direitoPlanoSaude);
    }
}
