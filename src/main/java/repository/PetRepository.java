package repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import model.Pet;


public interface PetRepository extends JpaRepository<Pet, Long>{

	List<Pet> findByDonoPetId(Long DonoPetId);
	
	List<Pet> findByPetIgnoreCase(String nomePet);

	List<Pet> findByNomePet(String nomePet);
}
