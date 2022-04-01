package ma.bkam.contratapi.dao.repository;

import ma.bkam.contratapi.dao.model.PrestataireEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PrestataireRepository extends JpaRepository<PrestataireEntity, Long> {
}
