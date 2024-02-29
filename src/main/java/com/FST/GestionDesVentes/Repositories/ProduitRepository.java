package com.FST.GestionDesVentes.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.FST.GestionDesVentes.Entities.Produit;

import java.util.List;


@Repository
public interface ProduitRepository extends JpaRepository < Produit, Long> {
    List<Produit> findByCategoryId(long categoryId);
}


