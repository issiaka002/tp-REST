package ci.inphb.tpservicewebapirest.web;

import ci.inphb.tpservicewebapirest.models.Produit;
import ci.inphb.tpservicewebapirest.repositories.ProduitRepository;
import lombok.AllArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*") // permet d'eviter le probleme CORS
@RestController // Indique qu'on creer veut creer une application REST (@Controller pour une appliction)
@Transactional // Toute les methodes doit etre transactionnelles
@AllArgsConstructor //genere contructeur avec tous les parametres (injection des dependances)
public class ProduitController {
    private ProduitRepository produitRepository;

    @PostMapping("/produit")
    public Produit ajouterProduit(@RequestBody Produit produit){
        return produitRepository.save(produit);
    }
    @DeleteMapping("/produit/{idProduit}")
    public String supprimerProduit(@PathVariable Long idProduit){
        produitRepository.deleteById(idProduit);
        return "Produit has been deleted succefully !!!";
    }
    @PutMapping("/produit/{idProduit}")
    public Produit modifierProduit(@PathVariable Long idProduit,@RequestBody Produit produit){
        Produit _produit = this.chercherProduit(idProduit);
        _produit.setDesignation(produit.getDesignation());
        _produit.setPrixUnit(produit.getPrixUnit());
        _produit.setQteStock(produit.getQteStock());
        return produitRepository.save(_produit);
    }

    @GetMapping("/produit/{idProduit}")
    public Produit chercherProduit(Long idProduit){
        return produitRepository.findById(idProduit).orElseThrow(()->
                    new RuntimeException("Produit not found !!!"));
    }
    @GetMapping("/produit")
    public List<Produit> listeProduit(){
        return produitRepository.findAll();
    }
}
