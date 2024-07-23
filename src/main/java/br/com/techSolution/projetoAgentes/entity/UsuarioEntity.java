package br.com.techSolution.projetoAgentes.entity;


import br.com.techSolution.projetoAgentes.dto.UsuarioDTO;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import java.util.Objects;

@Data
@Entity
@Table(name = "TECH_USUARIO")
public class UsuarioEntity {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String documentType;

    @Column(nullable = false)
    private String documentNumber;

//    @Column(nullable = false, unique = true)
//    private String login;

    @Column(nullable = false)
    private String senha;

    @Column(nullable = false)
    private String email;

    public UsuarioEntity(UsuarioDTO usuario) {
        BeanUtils.copyProperties(usuario, this);
    }

    public UsuarioEntity() {}


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UsuarioEntity that = (UsuarioEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(nome, that.nome) && Objects.equals(senha, that.senha) && Objects.equals(email, that.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, senha, email);
    }

}
