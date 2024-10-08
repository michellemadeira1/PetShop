package com.PetShop.PetShop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.PetShop.PetShop.model.Pet;

@Repository
public interface PetRepository extends JpaRepository<Pet, Long> {

    
    List<Pet> findByDonoPetId(Long donoPetId);
    

    List<Pet> findByNomePetIgnoreCase(String nomePet);

}
