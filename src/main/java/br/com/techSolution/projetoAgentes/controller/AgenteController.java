package br.com.techSolution.projetoAgentes.controller;

import br.com.techSolution.projetoAgentes.dto.AgenteDTO;
import br.com.techSolution.projetoAgentes.repository.AgenteRepository;
import br.com.techSolution.projetoAgentes.service.AgenteService;
import br.com.techSolution.projetoAgentes.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/agentes")
public class AgenteController {

    @Autowired
    private AgenteService agenteService;

    @GetMapping
    public List<AgenteDTO> listarAgentes() {
        return agenteService.listarTodos();
    }

    @PostMapping
    public void criarAgente(@RequestBody AgenteDTO agente) {
        agenteService.criaAgente(agente);
    }
}
