package br.com.techSolution.projetoAgentes.repository;

import br.com.techSolution.projetoAgentes.entity.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Long> {

}
