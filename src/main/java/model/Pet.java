package model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public class Pet {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nomePet;
	private String raca;
	private String peso;
	private String idade;
	
	@ManyToOne
    @JsonIgnore
    @JoinColumn(name = "donoPet_id")
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
