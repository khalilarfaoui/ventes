package com.FST.GestionDesVentes.Entities;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@Entity
@Table(name = "t_client")
public class Client {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

	@NotBlank(message = "Le nom est obligatoire")
	@Column (name="Nom")
    private String nom;
	
	@NotBlank(message = "Le prenom est obligatoire")
	@Column (name="Prenom")
    private String prenom;
	
	@NotBlank(message = "Email est obligatoire")
	@Column (name="Email")
    private String email;
	
	@NotBlank(message = "L'adresse est obligatoire")
	@Column (name="Adresse")
    private String adresse;
	
	
	@NotNull(message = "Le numéro de téléphone est obligatoire")
    @Positive(message = "Le numéro de téléphone doit être positif")
	@Column (name="Telephone")
    private String telephone;
    
    @OneToMany
    private List<Commande> commandes;
   
    
	public List<Commande> getCommandes() {
		return commandes;
	}
	public void setCommandes(List<Commande> commandes) {
		this.commandes = commandes;
	}
	public Client(String nom, String prenom, String email, String adresse, String telephone) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.adresse = adresse;
		this.telephone = telephone;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public Client() {
		super();
	}
}
