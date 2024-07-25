package br.com.techSolution.projetoAgentes.repository;

import br.com.techSolution.projetoAgentes.entity.TurnoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TurnoRepository extends JpaRepository<TurnoEntity, Long> {
    List<TurnoEntity> findByCodAgente(Long codAgente);
}
