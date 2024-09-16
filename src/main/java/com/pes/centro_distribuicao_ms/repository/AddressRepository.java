package com.pes.centro_distribuicao_ms.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.pes.centro_distribuicao_ms.domain.Address;

public interface AddressRepository extends JpaRepository<Address,Long>{
    
    Optional<Address> findById(Long id);
}
