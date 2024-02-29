package com.FST.GestionDesVentes.Entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;


@Data
@Entity
@Table(name = "t_Categorie")
public class Categorie {


	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

	@NotBlank(message = "Le nom est obligatoire")
	@Column (name="Nom")
    private String nom;


	@Column (name="Description")
    private String description ;

	@JsonIgnore
	@OneToMany
    private List<Produit> produits;



}
