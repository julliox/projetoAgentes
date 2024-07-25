package br.com.techSolution.projetoAgentes.controller;

import br.com.techSolution.projetoAgentes.dto.ParamsSalarioDTO;
import br.com.techSolution.projetoAgentes.service.SalarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.Period;

@RestController
@RequestMapping("/api/salarios")
public class SalarioController {

    @Autowired
    private SalarioService salarioService;

    @GetMapping("/calcular")
    public float calcularSalarioMensal(@RequestBody ParamsSalarioDTO paramsDTO) {

        float valorBaseDia;
        float valorBaseNoite;
        float adicionalFeriado = 0f;
        float descontoPorMinuto;
        float valorBolsaIdioma;
        float valorPlanoSaude;
        // Valores base e adicionais fixos, você pode configurá-los conforme necessário
        if (Period.between(paramsDTO.getDataContratacao(), LocalDate.now()).getYears() >= 1) {
             valorBaseDia = 37.2f;
             valorBaseNoite = 57.4f;
             descontoPorMinuto = 0f;
             valorBolsaIdioma = 50f;
             valorPlanoSaude = 50f;
        } else {
             valorBaseDia = 33.6f;
             valorBaseNoite = 44.8f;
             descontoPorMinuto = 0f;
             valorBolsaIdioma = 0f;
             valorPlanoSaude = 0f;
        }


        return salarioService.calcularSalarioMensal(paramsDTO.getCodAgente() , valorBaseDia, valorBaseNoite, adicionalFeriado, descontoPorMinuto, valorBolsaIdioma, valorPlanoSaude);
    }
}
