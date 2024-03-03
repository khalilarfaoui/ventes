package com.FST.GestionDesVentes.Entities;


import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "t_Facture")
public class Facture {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private long numFacture ;

    private LocalDateTime dateFacture ;

    @ManyToOne
    private Payement payment ;
}
