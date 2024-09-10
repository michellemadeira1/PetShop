package com.PetShop.PetShop.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import com.PetShop.PetShop.model.Pet;
import com.PetShop.PetShop.repository.PetRepository;

@Service
public class PetService {

	  @Autowired
	private PetRepository  petRepository;
	
	public Pet savePet(Pet pet) {
		return petRepository.save(pet);
	}


	public ResponseEntity <Pet> findPetById(Long id){
		return petRepository.findById(id)
				.map(idExiste-> ResponseEntity.status(200).body(idExiste))
		.orElse(ResponseEntity.status(404).build());
	}
	

			public ResponseEntity<List<Pet>> findPetByName(String nomePet) {
			    List<Pet> pets = petRepository.findByNomePetIgnoreCase(nomePet);
			    if (pets.isEmpty()) {
			        return ResponseEntity.status(404).build();
			    } else {
			        return ResponseEntity.status(200).body(pets);
			    }
			}
			
			
			

			public ResponseEntity<Pet> atualizar(Long id, Pet petAtualizado) {
			    Optional<Pet> petOptional = petRepository.findById(id);
			    if (petOptional.isPresent()) {
			        Pet pet = petOptional.get();
			        if (petAtualizado.getNomePet() != null) {
			            pet.setNomePet(petAtualizado.getNomePet());
			        }
			        if (petAtualizado.getRaca() != null) {
			            pet.setRaca(petAtualizado.getRaca());
			        }
			        if (petAtualizado.getPeso() != null) {
			            pet.setPeso(petAtualizado.getPeso());
			        }
			        if (petAtualizado.getIdade() != null) {
			            pet.setIdade(petAtualizado.getIdade());
			        }
			        
			        Pet petAtualizadoSalvo = petRepository.save(pet);
			        return ResponseEntity.ok(petAtualizadoSalvo); 
			    } else {
			        return ResponseEntity.status(HttpStatus.NOT_FOUND).build(); 
			    }
			}

			
			
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
