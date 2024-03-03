package com.FST.GestionDesVentes.Entities;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;


@Data
@Entity
@Table(name = "t_Payement")
public class Payement {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private double montant ;

    private LocalDateTime dateDePayment ;

    @OneToOne
    private Panier panier ;

    private PaymentType paymentType;
}
