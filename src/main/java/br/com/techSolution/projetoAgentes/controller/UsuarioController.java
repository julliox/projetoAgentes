package br.com.techSolution.projetoAgentes.controller;

import br.com.techSolution.projetoAgentes.dto.UsuarioDTO;
import br.com.techSolution.projetoAgentes.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public List<UsuarioDTO> listraTodos(){
        return usuarioService.listarTodos();
    }

    @PostMapping
    public void inserirUsuario(@RequestBody UsuarioDTO usuario){
        usuarioService.inserir(usuario);
    }

    @PutMapping
    public UsuarioDTO alterarUsuario(@RequestBody UsuarioDTO usuario){
        return usuarioService.alterar(usuario);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<String> excluirUsuario(@PathVariable Long id){
        usuarioService.excluir(id);
        return ResponseEntity.ok().build();
    }
}
