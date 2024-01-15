package ci.inphb.tpservicewebapirest.web;


import ci.inphb.tpservicewebapirest.models.Commande;
import ci.inphb.tpservicewebapirest.repositories.CommandeRepository;
import lombok.AllArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*") // permet d'eviter le probleme CORS
@RestController // Indique qu'on creer veut creer une application REST (@Controller pour une appliction)
@Transactional // Toute les methodes doit etre transactionnelles
@AllArgsConstructor //genere contructeur avec tous les parametres (injection des dependances)
public class CommandeController {

    private CommandeRepository commandeRepository;

    @PostMapping("/commande")
    public Commande ajouterCommande(@RequestBody Commande commande){
        return commandeRepository.save(commande);
    }
    @DeleteMapping("/commande/{idCommande}")
    public String supprimerCommande(@PathVariable Long idCommande){
        commandeRepository.deleteById(idCommande);
        return "Commande has been deleted !!";
    }
    @GetMapping("/commande")
    public List<Commande> listeCommande(){
        return commandeRepository.findAll();
    }
    @PutMapping("/commande/{idCommande}")
    public Commande modifierCommande(@PathVariable Long idCommande,@RequestBody Commande commande){
        Commande _commande = this.chercherCommnade((idCommande));
        _commande.setDateCom(commande.getDateCom());
        return _commande;
    }

    @GetMapping("/commande/{idCommande}")
    public Commande chercherCommnade(@PathVariable Long idCommande){
        return commandeRepository.findById(idCommande).orElseThrow(()->
                new RuntimeException("Commande not found !!!"));
    }

}
