package repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;

import model.DonoPet;

public interface DonoPetRepository extends JpaRepository<DonoPet, Long>{

	List<DonoPet> findAllWithPet();
	
	List<DonoPet> findByPetId(Long petId);
	
	List<DonoPet> findByNome(String nome);
	
	
}
