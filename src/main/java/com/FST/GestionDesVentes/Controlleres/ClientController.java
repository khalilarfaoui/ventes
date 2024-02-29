package com.FST.GestionDesVentes.Controlleres;

import java.util.List;
import java.util.Optional;

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

import com.FST.GestionDesVentes.Entities.Client;
import com.FST.GestionDesVentes.Entities.Commande;
import com.FST.GestionDesVentes.Repositories.ClientRepository;
import com.FST.GestionDesVentes.Repositories.CommandeRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping({"/clients", "/home*"})
@CrossOrigin(origins = "*")
public class ClientController {

    private final ClientRepository clientrepository;
    private final CommandeRepository commanderepository;

    public ClientController(ClientRepository clientrepository, CommandeRepository commanderepository) {
        this.clientrepository = clientrepository;
        this.commanderepository = commanderepository;
    }


    @GetMapping("/list")
    public List<Client> getAllClients() {
        return (List<Client>) clientrepository.findAll();
    }


    @PostMapping("/add")
    public Client createClient(@Valid @RequestBody Client client) {

        for (Commande commande : client.getCommandes()) { // Sauvegarder les commandes associées
            commanderepository.save(commande);
        }
        client.setCommandes(client.getCommandes());// Associer les commandes sauvegardées au client
        return clientrepository.save(client); // Sauvegarder le client avec les commandes associées
    }


    @DeleteMapping("/{clientId}")
    public ResponseEntity<?> deleteClient(@PathVariable Long clientId) {
        return clientrepository.findById(clientId).map(client -> {
            clientrepository.delete(client);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new IllegalArgumentException("ClientId " +
                clientId + " not found"));
    }


    @GetMapping("/{clientId}")
    public Client getClient(@PathVariable Long clientId) {

        Optional<Client> c = clientrepository.findById(clientId);

        return c.get();


    }
}