package com.FST.GestionDesVentes.Repositories;

import com.FST.GestionDesVentes.Entities.Payement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payement, Long> {
}
