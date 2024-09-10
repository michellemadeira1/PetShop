package com.PetShop.PetShop.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
@Schema(description = "Representa um dono de pet")
public class DonoPet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "ID único do dono do pet", example = "1")
    private Long id;
    
    @Schema(description = "Nome do dono do pet", example = "João da Silva")
    private String nome;
    
    @Schema(description = "Telefone do dono do pet", example = "(11) 99999-9999")
    private String telefone;
    
    @Schema(description = "Endereço do dono do pet", example = "Rua das Flores, 123")
    private String endereco;
    
    @OneToMany(mappedBy = "donoPet", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonIgnoreProperties("donoPet")
    @Schema(description = "Lista de pets pertencentes ao dono")
    private List<Pet> pet;

  
    public DonoPet() {}

    public DonoPet(Long id, String nome, String telefone, String endereco, List<Pet> pet) {
        this.id = id;
        this.nome = nome;
        this.telefone = telefone;
        this.endereco = endereco;
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

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endreco) {
        this.endereco = endreco;
    }

    public List<Pet> getPet() {
        return pet;
    }

    public void setPet(List<Pet> pet) {
        this.pet = pet;
    }
}
