package com.PetShop.PetShop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.PetShop.PetShop.model.Pet;
import com.PetShop.PetShop.service.PetService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/pet")
@Tag(name = "Pet", description = "Operações relacionadas a pets")
public class PetController {

	
	private PetService petService;
	
	 @Autowired
	    public PetController(PetService petService) {
	        this.petService = petService;
	    }

	
	 @Operation(description = "Cria um novo pet e retorna o pet criado.")
	 @PostMapping
	public ResponseEntity<Pet> criarPet(Pet pet){
		Pet novoPet = petService.savePet(pet);
		return new ResponseEntity<>(novoPet, HttpStatus.CREATED);
	}
	 
	 
	     @Operation(description = "Obtém os detalhes de um pet específico com base no ID.")
		 @GetMapping("/{id}")
		 public ResponseEntity<Pet> obterDonoPetPorId(@PathVariable Long id) {
			return petService.findPetById(id);
			 
		 }
	 
	        @Operation(description = "Busca uma lista de pets com base no nome fornecido.")
			@GetMapping("/pets/nome")
			public ResponseEntity<List<Pet>> obterPetPorNome(@RequestParam String nomePet) {
				return petService.findPetByName(nomePet);
			}
	 
	 
	        @Operation(description =  "Atualiza as informações de um pet existente com base no ID.")
			@PutMapping("/atualizar/{id}")
		    public ResponseEntity<Pet> atualizar(@PathVariable Long id, @RequestBody Pet petAtualizado) {
		        return petService.atualizar(id, petAtualizado);
		    }
	 
	 
	 
			
	        @Operation(description = "Remove um pet do sistema com base no ID fornecido.")
			@DeleteMapping("/deletar/{id}")
			 public ResponseEntity<Object>deletar(@PathVariable Long id){
					return petService.deletar(id);
				} 
}
