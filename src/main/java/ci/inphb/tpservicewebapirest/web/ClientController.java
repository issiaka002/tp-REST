package ci.inphb.tpservicewebapirest.web;

import ci.inphb.tpservicewebapirest.models.Client;
import ci.inphb.tpservicewebapirest.repositories.ClientRepository;
import lombok.AllArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*") // permet d'eviter le probleme CORS
@RestController // Indique qu'on creer veut creer une application REST (@Controller pour une appliction)
@Transactional // Toute les methodes doit etre transactionnelles
@AllArgsConstructor //genere contructeur avec tous les parametres (injection des dependances)
public class ClientController {

    private ClientRepository clientRepository;

    @PostMapping("/client")
    public Client ajouterClient(@RequestBody Client client){
        return clientRepository.save(client);
    }

    @GetMapping("/client")
    public List<Client> listeClient(){
        return clientRepository.findAll();
    }

    @DeleteMapping("/client/{idClient}")
    public String supprimerClient(@PathVariable Long idClient){
        clientRepository.deleteById(idClient);
        return "Client deleted ..!!";
    }

    @PutMapping("/client/{idClient}")
    public Client modifierClient(@PathVariable Long idClient,@RequestBody Client client){
        Client _client = clientRepository.findById(idClient).orElseThrow(() -> new RuntimeException("Client non trouvé ... !!!"));
        _client.setNom(client.getNom());
        _client.setVille(client.getVille());
        return _client;
    }

    @GetMapping("/client/{idClient}")
    public Client chercherClient(@PathVariable Long idClient){
        return clientRepository.findById(idClient).orElseThrow(() -> new RuntimeException("Client non trouvé ... !!!"));
    }
}
