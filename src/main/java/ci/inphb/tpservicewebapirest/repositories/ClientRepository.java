package ci.inphb.tpservicewebapirest.repositories;

import ci.inphb.tpservicewebapirest.models.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
