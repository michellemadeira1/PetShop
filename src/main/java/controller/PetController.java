package controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import model.DonoPet;
import model.Pet;
import service.PetService;

public class PetController {

	
	private PetService petService;
	
	//criar um pet
	 @PostMapping
	public ResponseEntity<Pet> criarPet(Pet pet){
		Pet novoPet = petService.savePet(pet);
		return new ResponseEntity<>(novoPet, HttpStatus.CREATED);
	}
	 
	 
	//pega uma lista de dono pelo id
		 @GetMapping("/{id}")
		 public ResponseEntity<Pet> obterDonoPetPorId(@PathVariable Long id) {
			return petService.findPetById(id);
			 
		 }
	 
		// Buscar pet pelo nome
			@GetMapping("/pets/nome")
			public ResponseEntity<List<Pet>> obterPetPorNome(@RequestParam String nomePet) {
				return petService.findPetByName(nomePet);
			}
	 
	 
	 
			// Deletar um pet pelo id
	 
			@GetMapping("/pets/{id}")
			 public ResponseEntity<Object>deletar(@PathVariable Long id){
					return petService.deletar(id);
				}
	 
	 
	 
	 
}
