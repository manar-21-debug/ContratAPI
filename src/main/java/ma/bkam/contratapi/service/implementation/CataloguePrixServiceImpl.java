package ma.bkam.contratapi.service.implementation;

import ma.bkam.contratapi.common.Helper.ExcelHelper;
import ma.bkam.contratapi.common.dto.zone.ZoneDTO;
import ma.bkam.contratapi.common.utils.Utilities;
import ma.bkam.contratapi.dao.model.CataloguePrixEntity;
import ma.bkam.contratapi.dao.repository.CataloguePrixRepository;
import ma.bkam.contratapi.service.CataloguePrixService;
import ma.bkam.contratapi.service.ContratService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class CataloguePrixServiceImpl implements CataloguePrixService {

    @Autowired
    private CataloguePrixRepository repository;

    @Autowired
    private ContratService service;

    @Override
    public void save(MultipartFile file) {
        List<String> zonesNames=new ArrayList<>();
        for(ZoneDTO zone:service.getZones()){
            zonesNames.add(zone.getLibelle());
        }
        try {
            List<CataloguePrixEntity> catalogues = ExcelHelper.excelToCataloguePrix(file.getInputStream());
            for(CataloguePrixEntity cat: catalogues) {
               if(zonesNames.contains(cat.getZone())){
                   repository.save(cat);

               }
            }


        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<CataloguePrixEntity> getAllCataloguePrixEntities() {
        return repository.findAll();
    }
}
