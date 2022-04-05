package ma.bkam.contratapi.service.implementation;

import ma.bkam.contratapi.common.Helper.ExcelHelper;
import ma.bkam.contratapi.dao.model.BorederexDePrixEntity;
import ma.bkam.contratapi.dao.repository.BordereuxDePrixRepository;
import ma.bkam.contratapi.service.BordereuxDePrixService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.io.IOException;
import java.util.List;

@Service
@Transactional
public class BordereuxDePrixServiceImpl implements BordereuxDePrixService {
    @Autowired
    private BordereuxDePrixRepository repository;

    @Override
    public void save(MultipartFile file) {

        try {
            List<BorederexDePrixEntity> bordereux = ExcelHelper.excelToBoredereuxDePrix(file.getInputStream());
            for(BorederexDePrixEntity bor: bordereux) {
                    repository.save(bor);
                }
        }catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public List<BorederexDePrixEntity> getAllBordereuxDePrix() {
        return repository.findAll();
    }
}
