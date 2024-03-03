package com.FST.GestionDesVentes.Controlleres;


import com.FST.GestionDesVentes.Entities.Facture;
import com.FST.GestionDesVentes.Entities.Payement;
import com.FST.GestionDesVentes.Repositories.FactureRepository;
import com.FST.GestionDesVentes.Repositories.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("facture")
public class FactureController {
    @Autowired
    FactureRepository factureRepository ;

    @GetMapping("list")
    public List<Facture> getAll(){
        return factureRepository.findAll();
    }
    @PostMapping("create")
    public Facture create(@RequestBody Facture facture){
        return factureRepository.save(facture);
    }

    @DeleteMapping("delete/{id}")
    public void deleteItem(@PathVariable long id){
        factureRepository.deleteById(id);

    }

    @PutMapping("edit/{id}")
    public ResponseEntity<Facture> updateItem(@PathVariable long id , @RequestBody Facture facture){
        Facture f = factureRepository.findById(id).orElse(null);
        if(f==null){
            return ResponseEntity.badRequest().build() ;
        }
        f.setId(id);
        f.setDateFacture(facture.getDateFacture());
        f.setNumFacture(facture.getNumFacture());
        factureRepository.save(f);
        return ResponseEntity.ok(f);
    }
}
