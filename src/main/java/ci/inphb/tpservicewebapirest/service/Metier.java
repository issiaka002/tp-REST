package ci.inphb.tpservicewebapirest.service;

import ci.inphb.tpservicewebapirest.models.Client;
import ci.inphb.tpservicewebapirest.models.Commande;
import ci.inphb.tpservicewebapirest.models.DetailCom;
import ci.inphb.tpservicewebapirest.models.Produit;
import ci.inphb.tpservicewebapirest.repositories.ClientRepository;
import ci.inphb.tpservicewebapirest.repositories.CommandeRepository;
import ci.inphb.tpservicewebapirest.repositories.DetailComRepository;
import ci.inphb.tpservicewebapirest.repositories.ProduitRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service // indique que cette classe contient la logique metier de notre application
@Transactional // Toute les methodes doit etre transactionnelles
@AllArgsConstructor //genere contructeur avec tous les parametres (injection des dependances)
public class Metier {

    private ClientRepository clientRepository;
    private CommandeRepository commandeRepository;
    private DetailComRepository detailComRepository;
    private ProduitRepository produitRepository;

    /**
     * Cette méthode calcule le montant total d'une commande pour un client donné
     * @param numCl Numero identifiant du client
     * @return le montant de la commande du client
     */
    public double montantCmd(Long numCl) {
        // Initialisation du montant à zéro
        double montant = 0;

        // Recherche du client par son identifiant
        Client client = clientRepository.findById(numCl)
                .orElseThrow(() -> new RuntimeException("Client non trouvé .."));
        /*Commande command = commandeRepository.findById(numCom)
                .orElseThrow(() -> new RuntimeException("Commande non trouvé .."));*/
        // Parcours des commandes du client
        for (Commande commande : client.getCommandes()) {
            // Parcours des détails de chaque commande
            for (DetailCom detailCom : commande.getDetailComs()) {
                // Calcul du montant en ajoutant le prix unitaire multiplié par la quantité
                System.out.println("prix unit="+detailCom.getProduit().getPrixUnit());System.out.println("prix unit="+detailCom.getProduit().getPrixUnit());
                System.out.println("quantite="+detailCom.getQteCom());
                montant += detailCom.getProduit().getPrixUnit() * detailCom.getQteCom();
            }
        }
        // Retour du montant total calculé
        System.out.println(montant);
        return montant;
    }

    /**
     * Cette méthode permet à un client de passer une et une seule commande
     * @param numCl Numero identifiant du client
     * @param detailsCommande Detail de la commande a passée
     * @return la nouvelle commande
     */
    public Commande passerCommande(Long numCl, List<DetailCom> detailsCommande) {
        // Recherche du client par son identifiant
        Client client = clientRepository.findById(numCl)
                .orElseThrow(() -> new RuntimeException("Client non trouvé .."));
        // Création d'une nouvelle commande
        Commande nouvelleCommande = new Commande();
        nouvelleCommande.setDateCom(new Date()); // Date actuelle
        // Association de la commande au client
        nouvelleCommande.setClient(client);
        // Association des détails de commande
        for (DetailCom detailCom : detailsCommande) {
            // Association de la commande au détail
            detailCom.setCommande(nouvelleCommande);
        }
        // Ajout de la commande à la liste des commandes du client
        client.getCommandes().add(nouvelleCommande);
        // Sauvegarde du client avec la nouvelle commande
        clientRepository.save(client);
        return nouvelleCommande;
    }



}
