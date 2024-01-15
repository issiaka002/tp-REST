package ci.inphb.tpservicewebapirest.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity   // Cette classe doit etre une table dans la base de donnée
@AllArgsConstructor // Genere un contructeur avec tous les parametres
@NoArgsConstructor  // Genere un contructeur sans parametres
@Getter   // Genere tous les getters
@Setter   // Genere tous les getters
@Table(name = "detail-com") // Nom de table dans la BDD
public class DetailCom {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) // id autoincrement
    private Long idDetailCom;

    private int qteCom;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ManyToOne(cascade = CascadeType.ALL)
    private Commande commande;

    @ManyToOne(cascade = CascadeType.ALL)
    private Produit produit;
}
