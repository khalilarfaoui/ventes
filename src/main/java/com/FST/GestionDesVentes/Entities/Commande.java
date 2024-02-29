package com.FST.GestionDesVentes.Entities;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "t_Commande")
public class Commande {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotNull(message = "La date est obligatoire")
    @Column(name = "Date")
    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date date;

    @NotNull(message = "Le total est obligatoire")
    @Column(name = "Total")
    private Double total;

    @NotBlank(message = "Le statut est obligatoire")
    @Column(name = "Statut")
    private String statut;

    @NotBlank(message = "L'adresse est obligatoire")
    @Column(name = "AdresseClient")
    private String adresseClient;


    @NotBlank(message = "La méthode de paiement est obligatoire")
    @Column(name = "MethodePaiement")
    private String methodePaiement;







    public Commande(Date date, Double total, String statut, String adresseClient, String methodePaiement) {
        super();
        this.date = date;
        this.total = total;
        this.statut = statut;
        this.adresseClient = adresseClient;
        this.methodePaiement = methodePaiement;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public String getAdresseClient() {
        return adresseClient;
    }

    public void setAdresseClient(String adresseClient) {
        this.adresseClient = adresseClient;
    }

    public String getMethodePaiement() {
        return methodePaiement;
    }

    public void setMethodePaiement(String methodePaiement) {
        this.methodePaiement = methodePaiement;
    }


    public Commande() {
        super();
    }


}
