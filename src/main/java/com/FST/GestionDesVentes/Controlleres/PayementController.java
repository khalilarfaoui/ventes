package com.FST.GestionDesVentes.Controlleres;

import com.FST.GestionDesVentes.Entities.Payement;
import com.FST.GestionDesVentes.Repositories.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("payement")
public class PayementController {

    @Autowired
    PaymentRepository payementRepository ;

    @GetMapping("list")
    public List<Payement> getAll(){
        return payementRepository.findAll();
    }

    @PostMapping("create")
    public Payement create(@RequestBody Payement payement){
        return payementRepository.save(payement);
    }

    @DeleteMapping("delete/{id}")
    public void deleteItem(@PathVariable long id){
         payementRepository.deleteById(id);

    }

    @PutMapping("edit/{id}")
    public ResponseEntity<Payement> updateItem(@PathVariable long id , @RequestBody Payement payement){
        Payement p = payementRepository.findById(id).orElse(null);
        if(p==null){
            return ResponseEntity.badRequest().build() ;
        }
        p.setId(id);
        p.setMontant(payement.getMontant());
        p.setDateDePayment(payement.getDateDePayment());
        payementRepository.save(p);
        return ResponseEntity.ok(p);
    }
}
