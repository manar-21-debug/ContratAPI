package ma.bkam.contratapi.service;

import ma.bkam.contratapi.dao.model.BorederexDePrixEntity;
import ma.bkam.contratapi.dao.model.CataloguePrixEntity;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface BordereuxDePrixService {

    public void save(MultipartFile file);
    public List<BorederexDePrixEntity> getAllBordereuxDePrix();
}
