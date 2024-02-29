package com.FST.GestionDesVentes.Entities;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;


@Data
@Entity
@Table (name = "t_Produit")
public class Produit {

	@Id
	@GeneratedValue( strategy= GenerationType.AUTO)
	private long id ;
	
	@NotBlank(message = "Le nom est obligatoire")
	@Column (name="Nom")
	private String nom;
	
	@Column (name="Description")
	private String description;
	
	@NotNull(message = "Le prix est obligatoire")
	@Column (name="Prix")
	private Double prix ;
	
	@NotNull(message = "Le stock est obligatoire")
	@Column (name="Stock")
	private int stock ;
	

	@Column (name="DateCreation")
	@JsonFormat(pattern = "dd-MM-yyyy")
	private Date dateCreation ;



	@ManyToOne
	private Categorie category;
	@Column (name="Image")
	private String image  ;
	


}
