package br.com.techSolution.projetoAgentes.repository;

import br.com.techSolution.projetoAgentes.entity.AgenteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AgenteRepository extends JpaRepository<AgenteEntity,Long> {

}
