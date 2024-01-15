package ci.inphb.tpservicewebapirest.web;


import ci.inphb.tpservicewebapirest.models.Commande;
import ci.inphb.tpservicewebapirest.models.DetailCom;
import ci.inphb.tpservicewebapirest.service.Metier;
import lombok.AllArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*") // permet d'eviter le probleme CORS
@RestController // Indique qu'on creer veut creer une application REST (@Controller pour une appliction)
@Transactional // Toute les methodes doit etre transactionnelles
@AllArgsConstructor //genere contructeur avec tous les parametres (injection des dependances)
public class MetierController {

    private Metier metier;

    @PutMapping("/passerCommande/{idClient}")
    public Commande passerCommande(@PathVariable Long idClient, @RequestBody List<DetailCom> detailsCommande){
        return metier.passerCommande(idClient,detailsCommande);
    }

    @PutMapping("/montantTotal/{idClient}")
    public double montantTotalClient(@PathVariable Long idClient){
        return metier.montantCmd(idClient);
    }
}
