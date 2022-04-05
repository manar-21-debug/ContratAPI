package ma.bkam.contratapi.dao.repository;

import ma.bkam.contratapi.dao.model.CataloguePrixEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CataloguePrixRepository extends JpaRepository<CataloguePrixEntity, Long> {
}
