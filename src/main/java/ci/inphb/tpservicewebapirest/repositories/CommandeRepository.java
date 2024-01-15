package ci.inphb.tpservicewebapirest.repositories;

import ci.inphb.tpservicewebapirest.models.Commande;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommandeRepository extends JpaRepository<Commande, Long> {
}
