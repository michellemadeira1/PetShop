package model;

public class Pet {

	private Long id;
	private String nomePet;
	private String raca;
	private String peso;
	private String idade;
	
	
	public Pet () {};
	
	public Pet(Long id, String nomePet, String raca, String peso, String idade) {
		super();
		this.id = id;
		this.nomePet = nomePet;
		this.raca = raca;
		this.peso = peso;
		this.idade = idade;
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
	
	
	
}
