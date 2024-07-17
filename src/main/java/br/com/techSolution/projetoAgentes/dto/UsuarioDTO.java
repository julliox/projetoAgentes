package br.com.techSolution.projetoAgentes.dto;

import br.com.techSolution.projetoAgentes.entity.UsuarioEntity;
import lombok.Data;
import org.springframework.beans.BeanUtils;

@Data
public class UsuarioDTO {

    private Long id;
    private String nome;
    private String login;
    private String senha;
    private String email;

    public UsuarioDTO(UsuarioEntity usuario) {
        BeanUtils.copyProperties(usuario, this);
    }

    public UsuarioDTO() {}

}
