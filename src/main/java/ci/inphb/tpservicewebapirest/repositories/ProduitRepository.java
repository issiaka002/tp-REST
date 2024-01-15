package ci.inphb.tpservicewebapirest.repositories;

import ci.inphb.tpservicewebapirest.models.Produit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProduitRepository extends JpaRepository<Produit, Long> {
}
