package br.com.techSolution.projetoAgentes.controller;


import br.com.techSolution.projetoAgentes.dto.TurnoDTO;
import br.com.techSolution.projetoAgentes.service.TurnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/turnos")
public class TurnoController {

    @Autowired
    private TurnoService turnoService;

    @GetMapping
    public List<TurnoDTO> listaTurnos() {
        return turnoService.listarTodos();
    }

    @PostMapping
    public void criarTurno(@RequestBody TurnoDTO turno) {
        turnoService.criarTurno(turno);
    }
}
