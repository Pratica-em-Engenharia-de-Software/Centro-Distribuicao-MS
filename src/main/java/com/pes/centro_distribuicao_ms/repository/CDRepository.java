package com.pes.centro_distribuicao_ms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.pes.centro_distribuicao_ms.domain.CentroDistribuicao;
import java.util.Optional;


public interface CDRepository extends JpaRepository<CentroDistribuicao,Long>{

    Optional<CentroDistribuicao> findByCode(long id);

    Optional<CentroDistribuicao> findByName(String name);
}
