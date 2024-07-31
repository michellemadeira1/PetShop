package service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;

import model.Pet;
import repository.PetRepository;

public class PetService {

	private PetRepository  petRepository;
	
	public Pet savePet(Pet pet) {
		return petRepository.save(pet);
	}

	// Pega uma lista de dono pelo id
	public ResponseEntity <Pet> findPetById(Long id){
		return petRepository.findById(id)
				.map(idExiste-> ResponseEntity.status(200).body(idExiste))
		.orElse(ResponseEntity.status(404).build());
	}
	
	// Buscar dono de pet pelo nome
			public ResponseEntity<List<Pet>> findPetByName(String nomePet) {
			    List<Pet> pets = petRepository.findByNomePet(nomePet);
			    if (pets.isEmpty()) {
			        return ResponseEntity.status(404).build();
			    } else {
			        return ResponseEntity.status(200).body(pets);
			    }
			}
			
			// Deletar um pet pelo id
			public ResponseEntity<Object> deletar(Long id) {
			    Optional<Pet> idExistente = petRepository.findById(id);
			    if (idExistente.isEmpty()) {
			        return ResponseEntity.status(400).build();
			    } else {
			        petRepository.deleteById(id);
			        return ResponseEntity.status(200).build();
			    }
			}
}
