package ci.inphb.tpservicewebapirest.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@Entity   // Cette classe doit etre une table dans la base de donnée
@AllArgsConstructor // Genere un contructeur avec tous les parametres
@NoArgsConstructor  // Genere un contructeur sans parametres
@Getter   // Genere tous les getters
@Setter   // Genere tous les getters
@Table(name = "client")  // Nom de table dans la BDD
public class Client {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) // id autoincrement
    private Long numCl;

    @Column(nullable = false)   //nom ne doit pas etre vide
    private String nom;

    @Column(nullable = false)  //ville ne doit pas etre vide
    private String ville;

    @OneToMany(mappedBy = "client", fetch = FetchType.EAGER, cascade = CascadeType.ALL) // Un client a plusieurs commandes
    private List<Commande> commandes;

}
