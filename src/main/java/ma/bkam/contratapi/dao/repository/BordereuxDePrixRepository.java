package ma.bkam.contratapi.dao.repository;

import ma.bkam.contratapi.dao.model.BorederexDePrixEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BordereuxDePrixRepository extends JpaRepository<BorederexDePrixEntity,Long> {
}
