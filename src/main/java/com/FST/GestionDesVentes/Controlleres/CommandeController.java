package com.FST.GestionDesVentes.Controlleres;

import java.util.List;
import java.util.Optional;

import com.FST.GestionDesVentes.Entities.Produit;
import com.FST.GestionDesVentes.Repositories.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.FST.GestionDesVentes.Entities.Commande;
import com.FST.GestionDesVentes.Repositories.CommandeRepository;

import jakarta.validation.Valid;


@RestController
@RequestMapping("/commandes")
@CrossOrigin(origins = "*")
public class CommandeController {


    @Autowired
    private CommandeRepository commanderepository;

    @Autowired
    private ProduitRepository produitRepository;


    @GetMapping("/list")
    public List<Commande> getAllCommandes() {
        return commanderepository.findAll();
    }


    @PostMapping("/add")
    public ResponseEntity<Commande> createCommande(@RequestBody Commande commande) {
        Produit p = produitRepository.findById(commande.getProduit().getId()).orElse(null);
        int restQuantity = p.getStock() - commande.getQuantity();
        if (restQuantity < 0) {
            return ResponseEntity.badRequest().build();
        }
        p.setStock(restQuantity);
        p.setId(p.getId());
        try {
            produitRepository.save(p);

        } catch (Error e) {
            return ResponseEntity.badRequest().build();
        }
        try {
            Commande c = commanderepository.save(commande);
            return ResponseEntity.ok(c);
        } catch (Error e) {
            return ResponseEntity.badRequest().build();
        }
    }


    @DeleteMapping("/{commandeId}")
    public ResponseEntity<?> deleteClient(@PathVariable Long commandeId) {
        return commanderepository.findById(commandeId).map(commande -> {
            commanderepository.delete(commande);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new IllegalArgumentException("CommandeId" + "commandeId" + " not found"));
    }


    @GetMapping("/{commandeId}")
    public Commande getCommande(@PathVariable Long commandeId) {
        Optional<Commande> c = commanderepository.findById(commandeId);
        return c.get();

    }

    @GetMapping("/increaseQuantity/{commandeId}")
    public Commande increaseQuantity(@PathVariable Long commandeId) {
        Commande c = commanderepository.findById(commandeId).orElse(null);

        c.setQuantity(c.getQuantity() + 1);
        c.setId(commandeId);
        return commanderepository.save(c);

    }

    @GetMapping("/decreaseQuantity/{commandeId}")
    public Commande decreaseQuantity(@PathVariable Long commandeId) {
        Commande c = commanderepository.findById(commandeId).orElse(null);
        if (c.getQuantity() == 1) {
            return c;
        }
        c.setQuantity(c.getQuantity() - 1);
        c.setId(commandeId);
        return commanderepository.save(c);

    }


}