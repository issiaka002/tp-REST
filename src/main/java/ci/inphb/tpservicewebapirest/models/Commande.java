package ci.inphb.tpservicewebapirest.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Entity // Cette classe doit etre une table dans la base de donnée
@AllArgsConstructor // Genere un contructeur avec tous les parametres
@NoArgsConstructor  // Genere un contructeur sans parametres
@Getter   // Genere tous les getters
@Setter   // Genere tous les getters
@Table(name = "commande") // Nom de table dans la BDD
public class Commande {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)  // id autoincrement
    private Long numCom;

    private Date dateCom;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ManyToOne(cascade = CascadeType.ALL)   // Plusieurs Commande pour un Client
    private Client client;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @OneToMany(mappedBy = "commande", cascade = CascadeType.ALL) // Un Commande a plusieurs DetailCom
    private List<DetailCom> detailComs;

}
