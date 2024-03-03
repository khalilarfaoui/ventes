package com.FST.GestionDesVentes.Entities;

import java.util.List;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity
@Table(name = "t_Panier")
public class Panier {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;




	@OneToMany
	private List<Commande> commandeList;


	public void addCommande(Commande commande){
		this.commandeList.add(commande);
	}

	public void removeCommande(Commande commande){
		this.commandeList.remove(commande);
	}
	
	

}