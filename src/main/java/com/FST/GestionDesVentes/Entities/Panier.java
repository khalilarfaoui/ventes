package com.FST.GestionDesVentes.Entities;

import java.util.List;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "t_Panier")
public class Panier {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
	
	@NotNull(message = "La quantité est obligatoire")
	@Min(value = 0, message = "La quantité ne peut pas être négative")
	@Column (name="Quantité")
	private int quantite;
	
	


	
	

}