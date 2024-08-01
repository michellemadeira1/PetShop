package model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

public class DonoPet {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String telefone;
	private String endreco;
	
	@OneToMany(mappedBy = "donopet", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonIgnoreProperties
	private List<Pet>pet;
	
	public DonoPet() {};
	
	public DonoPet(Long id, String nome, String telefone, String endreco, List<Pet> pet) {
		super();
		this.id = id;
		this.nome = nome;
		this.telefone = telefone;
		this.endreco = endreco;
		this.pet = pet;
	}


	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEndreco() {
		return endreco;
	}

	public void setEndreco(String endreco) {
		this.endreco = endreco;
	}
	
	public List<Pet> getPet() {
		return pet;
	}

	public void setPet(List<Pet> pet) {
		this.pet = pet;
	}

	
}
