package com.PetShop.PetShop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.PetShop.PetShop.model.DonoPet;
import com.PetShop.PetShop.service.DonoPetService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;



@RestController
@RequestMapping("/donoPet")
@Tag(name = "DonoPet", description = "API para gerenciar donos de pets")
public class DonoPetController {

	private DonoPetService donoPetService;
	
	
	@Autowired
    public DonoPetController(DonoPetService donoPetService) {
        this.donoPetService = donoPetService;
    }

	
	@Operation(description = "Cria um novo dono de pet com as informações fornecidas.")
	@PostMapping
	public ResponseEntity<List<DonoPet>> criarDonoPet( @RequestBody DonoPet donoPet){
		return donoPetService.postarDonoPet(donoPet);
	}
	
	
	 @Operation(description = "Obtém as informações do dono de pet com o ID fornecido.")
	 @GetMapping("/{id}")
	 public ResponseEntity<DonoPet> obterDonoPetPorId(@PathVariable Long id) {
		return donoPetService.findDonoPetById(id);
		 
	 }
	
	 @Operation(description = "Obtém uma lista de todos os donos de pets.")
	 @GetMapping("/donos")
	 public ResponseEntity<List<DonoPet>> obterTodosDonoPet(){
		return donoPetService.findAllDonoPet();
	
    }
	 
	    @Operation(description = "Busca donos de pets com o nome fornecido.")
		@GetMapping("/donos/nome")
		public ResponseEntity<List<DonoPet>> obterDonoPetPorNome(@RequestParam String nome) {
			return donoPetService.findDonoPetByName(nome);
		}
	 
	
	     @Operation(description = "Atualiza as informações do dono de pet com o ID fornecido.")
		 @PutMapping("/atualizar/{id}")
		    public ResponseEntity<DonoPet> atualizar(@PathVariable Long id, @RequestBody DonoPet donoPetAtualizado) {
		        return donoPetService.atualizar(id, donoPetAtualizado);
		    }
		
	
	    @Operation(description = "Deleta o dono de pet com o ID fornecido.")
		@GetMapping("/donos/{id}")
	 public ResponseEntity<Object>deletar(@PathVariable Long id){
			return donoPetService.deletar(id);
		}
}