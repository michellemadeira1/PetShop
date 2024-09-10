package com.PetShop.PetShop.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
@Schema(description = "Modelo de dados para Pet")
public class Pet {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "ID do Pet", example = "1")
	private Long id;
    
    @Schema(description = "Nome do Pet", example = "Rex")
	private String nomePet;
    
    @Schema(description = "Raça do Pet", example = "Labrador")
	private String raca;
    
    @Schema(description = "Peso do Pet", example = "15kg")
	private String peso;
    
    @Schema(description = "Idade do Pet", example = "2 anos")
	private String idade;
	
	@ManyToOne
    @JsonIgnore
    @JoinColumn(name = "donoPet_id")
	@Schema(description = "Dono do Pet")
	private DonoPet donoPet;
	
	
	public Pet () {};
	
	public Pet(Long id, String nomePet, String raca, String peso, String idade, DonoPet donoPet) {
		super();
		this.id = id;
		this.nomePet = nomePet;
		this.raca = raca;
		this.peso = peso;
		this.idade = idade;
		this.donoPet = donoPet;
	}

	
	
	


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomePet() {
		return nomePet;
	}

	public void setNomePet(String nomePet) {
		this.nomePet = nomePet;
	}

	public String getRaca() {
		return raca;
	}

	public void setRaca(String raca) {
		this.raca = raca;
	}

	public String getPeso() {
		return peso;
	}

	public void setPeso(String peso) {
		this.peso = peso;
	}

	public String getIdade() {
		return idade;
	}

	public void setIdade(String idade) {
		this.idade = idade;
	}
	
	public DonoPet getDonoPet() {
		return donoPet;
	}

	public void setDonoPet(DonoPet donoPet) {
		this.donoPet = donoPet;
	}

	
}
