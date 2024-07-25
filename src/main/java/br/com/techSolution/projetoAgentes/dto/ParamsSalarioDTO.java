package br.com.techSolution.projetoAgentes.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ParamsSalarioDTO {

    private Long codAgente;
    private LocalDate dataContratacao;
    private float valorBolsaIdioma;
    private float valorPlanoSaude;

}
