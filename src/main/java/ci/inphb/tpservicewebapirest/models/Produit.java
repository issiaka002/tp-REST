package ci.inphb.tpservicewebapirest.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
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
@Table(name = "produit") // Nom de table dans la BDD
public class Produit {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) // id autoincrement
    private Long numProd;

    @Column(nullable = false) // designation ne doit pas etre vide
    private String designation;

    @Column(nullable = false) // prixUnit ne doit pas etre vide
    private double prixUnit;

    @Column(nullable = false) @Min(0) // qteStock ne doit pas etre null et min=0
    private int qteStock;
}
