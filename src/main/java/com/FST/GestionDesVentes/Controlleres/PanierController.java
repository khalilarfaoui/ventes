package com.FST.GestionDesVentes.Controlleres;

import com.FST.GestionDesVentes.Entities.Commande;
import com.FST.GestionDesVentes.Entities.Panier;
import com.FST.GestionDesVentes.Entities.Produit;
import com.FST.GestionDesVentes.Repositories.CommandeRepository;
import com.FST.GestionDesVentes.Repositories.PanierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("panier")
@RestController
public class PanierController {

    @Autowired
    PanierRepository panierRepository;

    @Autowired
    CommandeRepository commandeRepository;

    @GetMapping("/all")
    public List<Panier> getAllPanier(){
        return panierRepository.findAll();
    }

    @PostMapping("/add")
    public Panier createPanier(@RequestBody Panier panier){
        return panierRepository.save(panier);
    }

    @DeleteMapping("/delete/{id}")
    public void deletePanier(@PathVariable long id){
        panierRepository.deleteById(id);
    }

    @GetMapping("addCommandeToPanier/{idPanier}/{idCommande}")
    public Panier addCommandeToPanier(@PathVariable long idPanier , @PathVariable long idCommande){
        Panier panier = panierRepository.findById(idPanier).orElse(null);
        Commande commande = commandeRepository.findById(idCommande).orElse(null);

        panier.addCommande(commande);
        panier.setId(idPanier);
        return panierRepository.save(panier);
    }


}
