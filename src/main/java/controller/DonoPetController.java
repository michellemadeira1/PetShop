package controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import model.DonoPet;
import service.DonoPetService;

public class DonoPetController {

	private DonoPetService donoPetService;
	
	
	//criar um dono
	@PostMapping
	public ResponseEntity<List<DonoPet>> criarDonoPet( @RequestBody DonoPet donoPet){
		return donoPetService.postarDonoPet(donoPet);
	}
	
	
	//pega uma lista de dono pelo id
	 @GetMapping("/{id}")
	 public ResponseEntity<DonoPet> obterDonoPetPorId(@PathVariable Long id) {
		return donoPetService.findDonoPetById(id);
		 
	 }
	
	//obter uma lista de dono
	 @GetMapping("/donos")
	 public ResponseEntity<List<DonoPet>> obterTodosDonoPet(){
		return donoPetService.findAllDonoPet();
	
    }
	 
	// Buscar dono de pet pelo nome
		@GetMapping("/donos/nome")
		public ResponseEntity<List<DonoPet>> obterDonoPetPorNome(@RequestParam String nome) {
			return donoPetService.findDonoPetByName(nome);
		}
	 
		
		// Deletar um dono pelo id
		@GetMapping("/donos/{id}")
	 public ResponseEntity<Object>deletar(@PathVariable Long id){
			return donoPetService.deletar(id);
		}
}