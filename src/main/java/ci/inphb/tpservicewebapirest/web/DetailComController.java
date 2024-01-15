package ci.inphb.tpservicewebapirest.web;


import ci.inphb.tpservicewebapirest.models.DetailCom;
import ci.inphb.tpservicewebapirest.repositories.DetailComRepository;
import lombok.AllArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*") // permet d'eviter le probleme CORS
@RestController // Indique qu'on creer veut creer une application REST (@Controller pour une appliction)
@Transactional // Toute les methodes doit etre transactionnelles
@AllArgsConstructor //genere contructeur avec tous les parametres (injection des dependances)
public class DetailComController {

    private DetailComRepository detailComRepository;

    @PostMapping("/detailCom")
    public DetailCom ajouterDetailCom(@RequestBody DetailCom detailCom){
        return detailComRepository.save(detailCom);
    }

    @GetMapping("/detailCom/{idDetailCom}")
    public DetailCom chercherDetailCom(@PathVariable Long idDetailCom){
        return detailComRepository.findById(idDetailCom).orElseThrow(()->
                new RuntimeException("DetailCom not found with id="+idDetailCom));
    }

    @PutMapping("/detailCom/{idDetailCom}")
    public DetailCom modifierDetailCom(@PathVariable Long idDetailCom,@RequestBody DetailCom detailCom){
        DetailCom detailCom1 = this.chercherDetailCom(idDetailCom);
        detailCom1.setQteCom(detailCom.getQteCom());
        return detailComRepository.save(detailCom1);
    }

    @GetMapping("/detailCom")
    public List<DetailCom> listeDetailCom(){
        return detailComRepository.findAll();
    }

    @DeleteMapping("/detailCom/{idDetailCom}")
    public String supprimerDetailCom(@PathVariable Long idDetailCom){
        detailComRepository.deleteById(idDetailCom);
        return "DetailCom has been deleted !!!";
    }
}
