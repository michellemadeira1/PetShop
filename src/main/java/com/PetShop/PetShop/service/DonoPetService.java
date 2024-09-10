package com.PetShop.PetShop.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.PetShop.PetShop.model.DonoPet;
import com.PetShop.PetShop.repository.DonoPetRepository;

@Service
public class DonoPetService {
	
	  @Autowired
	private DonoPetRepository donoPetRepository;
	
	

	public ResponseEntity<List<DonoPet>> postarDonoPet(DonoPet donoPet) {
		List<DonoPet> usuarioPetExist = donoPetRepository.findByNome(donoPet.getNome());
		
		if(usuarioPetExist.isEmpty()) {
			return ResponseEntity.status(406).build();
		}else {
			return ResponseEntity.status(200).body(usuarioPetExist);
			
		}	
	}
	
	
	public ResponseEntity <DonoPet> findDonoPetById(Long id){
		return donoPetRepository.findById(id)
				.map(idExiste-> ResponseEntity.status(200).body(idExiste))
		.orElse(ResponseEntity.status(404).build());
	}
	 

	
	public ResponseEntity <List<DonoPet>> findAllDonoPet(){
		List<DonoPet> listaDeUsuario = donoPetRepository.findAll();
		
		if (listaDeUsuario.isEmpty()) {
            return ResponseEntity.status(204).build();
        } else {
        	return ResponseEntity.status(200).body(listaDeUsuario);
        }
		
	}
	


		public ResponseEntity<List<DonoPet>> findDonoPetByName(String nome) {
		    List<DonoPet> donos = donoPetRepository.findByNome(nome);
		    if (donos.isEmpty()) {
		        return ResponseEntity.status(404).build();
		    } else {
		        return ResponseEntity.status(200).body(donos);
		    }
		}
		
		
		
		public ResponseEntity<DonoPet> atualizar(Long id, DonoPet donoPetAtualizado) {
		    Optional<DonoPet> donoPetOptional = donoPetRepository.findById(id);
		    if (donoPetOptional.isPresent()) {
		        DonoPet donoPet = donoPetOptional.get();
		        donoPet.setNome(donoPetAtualizado.getNome());
		        donoPet.setTelefone(donoPetAtualizado.getTelefone());
		        donoPet.setEndereco(donoPetAtualizado.getEndereco());
		        // Atualizar outros campos conforme necessário
		        DonoPet donoPetAtualizadoSalvo = donoPetRepository.save(donoPet);
		        return ResponseEntity.ok(donoPetAtualizadoSalvo);
		    } else {
		        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		    }
		}


	
	public ResponseEntity<Object> deletar(Long id) {
	    Optional<DonoPet> idExistente = donoPetRepository.findById(id);
	    if (idExistente.isEmpty()) {
	        return ResponseEntity.status(400).build();
	    } else {
	        donoPetRepository.deleteById(id);
	        return ResponseEntity.status(200).build();
	    }
	}
	
	
}
