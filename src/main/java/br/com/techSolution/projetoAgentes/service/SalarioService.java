package br.com.techSolution.projetoAgentes.service;

import br.com.techSolution.projetoAgentes.entity.AgenteEntity;
import br.com.techSolution.projetoAgentes.entity.TurnoEntity;
import br.com.techSolution.projetoAgentes.repository.AgenteRepository;
import br.com.techSolution.projetoAgentes.repository.TurnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalarioService {

    @Autowired
    private TurnoRepository turnoRepository;

    @Autowired
    private AgenteRepository agenteRepository;

    public float calcularSalarioMensal(Long codAgente, float valorBaseDia, float valorBaseNoite, float adicionalFeriado, float descontoPorMinuto,float valorBolsaIdioma, float valorPlanoSaude) {
        List<TurnoEntity> turnos = turnoRepository.findByCodAgente(codAgente);
        AgenteEntity agente = agenteRepository.findById(codAgente).orElseThrow(() -> new RuntimeException("Agente não encontrado"));

        float salarioTotal = 0;

        for (TurnoEntity turno : turnos) {
            float valorBase;

            if (turno.isTurnoDia()) {
                valorBase = valorBaseDia;
                adicionalFeriado = valorBaseDia*2;
            } else {
                valorBase = valorBaseNoite;
                adicionalFeriado = valorBaseNoite*2;
            }
            float adicional = turno.isFeriado() ? adicionalFeriado : 0;
            float desconto = turno.getMinutosPerdidos() * descontoPorMinuto;

            float salarioTurno = valorBase + adicional - desconto;

            if (agente.isDireitoBolsaIdioma()) {
                salarioTurno += valorBolsaIdioma;
            }

            if (agente.isDireitoPlanoSaude()) {
                salarioTurno += valorPlanoSaude;
            }

            salarioTotal += salarioTurno;
        }

        // Adicionar custo de câmbio
        salarioTotal *= 1.05;

        return salarioTotal;
    }
}