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
	
	private String nom;
	
	private String description;
	
	private Double prix ;
	
	private int stock ;
	

	private Date dateCreation ;



	@ManyToOne
	private Categorie category;

	private String image  ;
	


}
