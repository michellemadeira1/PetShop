package service;

import java.util.List;


import org.springframework.http.ResponseEntity;


import model.DonoPet;
import repository.DonoPetRepository;

public class DonoPetService {
	

	private DonoPetRepository donoPetRepository;
	
	
//criar um dono
	public ResponseEntity<List<DonoPet>> postarDonoPet(DonoPet donoPet) {
		List<DonoPet> usuarioPetExist = donoPetRepository.findByNome(donoPet.getNome());
		
		if(usuarioPetExist.isEmpty()) {
			return ResponseEntity.status(406).build();
		}else {
			return ResponseEntity.status(200).body(usuarioPetExist);
			
		}	
	}
	
	// Obtém uma lista de dono pelo id
	public ResponseEntity <DonoPet> findDonoPetById(Long id){
		return donoPetRepository.findById(id)
				.map(idExiste-> ResponseEntity.status(200).body(idExiste))
		.orElse(ResponseEntity.status(404).build());
	}
	 
	//obter uma lista de dono
	public ResponseEntity <List<DonoPet>> findAllDonoPet(){
		List<DonoPet> listaDeUsuario = donoPetRepository.findAll();
		
		if (listaDeUsuario.isEmpty()) {
            return ResponseEntity.status(204).build();
        } else {
        	return ResponseEntity.status(200).body(listaDeUsuario);
        }
		
	}

	
	
	
	
	
}
