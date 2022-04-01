package ma.bkam.contratapi.dao.repository;

import ma.bkam.contratapi.dao.model.ContratEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContratRepository extends JpaRepository<ContratEntity, Long> {
}
