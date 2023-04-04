//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package ch.etml.pl.commerceapi.dao;

import ch.etml.pl.commerceapi.entity.ClientsEntity;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientsRepository extends JpaRepository<ClientsEntity, Integer> {
    Optional<ClientsEntity> findClientEntitiesByPrenomEquals(String prenom);

    ClientsEntity findByPrenom(String prenom);
}
