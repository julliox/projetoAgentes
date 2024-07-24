package br.com.techSolution.projetoAgentes.dto;


import br.com.techSolution.projetoAgentes.entity.AgenteEntity;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import java.time.LocalDate;

@Data
public class AgenteDTO {

    private Long id;
    private String nome;
    private String email;
    private LocalDate dataContratacao;
    private float salarioBase;
    private boolean direitoBolsaIdioma;
    private boolean direitoPlanoSaude;



    public AgenteDTO(AgenteEntity agente) {
        BeanUtils.copyProperties(agente, this);
    }

    public AgenteDTO() {}

}
