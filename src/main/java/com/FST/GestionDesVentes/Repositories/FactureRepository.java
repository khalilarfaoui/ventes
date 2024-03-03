package com.FST.GestionDesVentes.Repositories;

import com.FST.GestionDesVentes.Entities.Facture;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FactureRepository extends JpaRepository<Facture , Long> {
}
