package com.PetShop.PetShop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.PetShop.PetShop.model.DonoPet;

@Repository
public interface DonoPetRepository extends JpaRepository<DonoPet, Long> {

    
    List<DonoPet> findByNome(String nome);

}
