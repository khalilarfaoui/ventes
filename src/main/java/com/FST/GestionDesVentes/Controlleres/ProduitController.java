package com.FST.GestionDesVentes.Controlleres;

import java.util.List;

import com.FST.GestionDesVentes.Entities.Categorie;
import com.FST.GestionDesVentes.Repositories.CategorieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import com.FST.GestionDesVentes.Entities.Produit;
import com.FST.GestionDesVentes.Repositories.ProduitRepository;

import jakarta.validation.Valid;

@RestController
//@RequestMapping({"/produits", "/home*"})
@RequestMapping("/produits")
@CrossOrigin(origins = "*")
public class ProduitController {


    @Autowired
    private ProduitRepository produitrepository;

    @Autowired
    private CategorieRepository categorieRepository;

    @GetMapping("/list")
    public List<Produit> getallProduits() {
        return produitrepository.findAll();
    }

    @PostMapping("/add/{id}")
    public ResponseEntity<Produit> createProduit(@Valid @RequestBody Produit produit, @PathVariable long id) {
        Categorie categorie = categorieRepository.findById(id).orElse(null);
        if (categorie != null) {
            produit.setCategory(categorie);
            Produit produitsaved = produitrepository.save(produit);
            return ResponseEntity.ok(produitsaved);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }


    @GetMapping("/findById/{id}")
    public ResponseEntity<Produit> getProductById(@PathVariable long id){
        Produit produit = produitrepository.findById(id).orElse(null) ;
        if(produit == null){
            return ResponseEntity.noContent().build();
        }else{
            return ResponseEntity.ok(produit);
        }
    }



    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable long id) {
        produitrepository.deleteById(id);
    }


    @PutMapping("/edit/{id}")
    public ResponseEntity<?> updateCategorie(@PathVariable long id, @RequestBody Produit produit) {
        if (!produitrepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        } else {
            produit.setId(id);
            Produit updatedProduit = produitrepository.save(produit);
            return ResponseEntity.ok(updatedProduit);
        }
    }

    @GetMapping("/byCategory/{categoryId}")
    public List<Produit> getProduitsByCategoryId(@PathVariable long categoryId) {
        return produitrepository.findByCategoryId(categoryId);
    }


}

	

	
