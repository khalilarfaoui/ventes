package com.FST.GestionDesVentes.Controlleres;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.FST.GestionDesVentes.Entities.Categorie;
import com.FST.GestionDesVentes.Entities.Produit;
import com.FST.GestionDesVentes.Repositories.CategorieRepository;
import com.FST.GestionDesVentes.Repositories.ProduitRepository;

import jakarta.validation.Valid;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/categories")
public class CategorieController {

    @Autowired
    private CategorieRepository categorierepository;

    @Autowired
    private ProduitRepository produitrepository;


    @GetMapping("/list")
    public List<Categorie> getCategories() {
        return (List<Categorie>) categorierepository.findAll();
    }


    @PostMapping("/add")
    public Categorie createCategorie(@Valid @RequestBody Categorie categorie) {
        return categorierepository.save(categorie);
    }


    @GetMapping("/findById/{id}")
    public ResponseEntity<Categorie> getCategoryById(@PathVariable long id){
        Categorie categorie = categorierepository.findById(id).orElse(null) ;
        if(categorie == null){
            return ResponseEntity.noContent().build();
        }else{
            return ResponseEntity.ok(categorie);
        }
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<?> updateCategorie(@PathVariable long id , @RequestBody Categorie categorie){
        if(!categorierepository.existsById(id)){
            return ResponseEntity.notFound().build();
        }else{
            categorie.setId(id);
            Categorie updatedCategory = categorierepository.save(categorie);
            return ResponseEntity.ok(updatedCategory);
        }
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCategory(@PathVariable long id) {
        List<Produit> listProduit = produitrepository.findByCategoryId(id);
        if (listProduit.isEmpty()) {
            categorierepository.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).build();
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("On peux pas la supprimer");
        }
    }


}