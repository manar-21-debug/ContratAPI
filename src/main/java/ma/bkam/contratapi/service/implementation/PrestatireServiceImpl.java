package ma.bkam.contratapi.service.implementation;


import ma.bkam.contratapi.common.client.MsZoneApi;
import ma.bkam.contratapi.common.dto.PrestatireDTO;
import ma.bkam.contratapi.common.dto.naturePrestation.NaturePrestationDTO;
import ma.bkam.contratapi.common.utils.MessagesCodes;
import ma.bkam.contratapi.common.utils.Utilities;
import ma.bkam.contratapi.dao.model.PrestataireEntity;
import ma.bkam.contratapi.dao.repository.PrestataireRepository;
import ma.bkam.contratapi.service.PrestatireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@PropertySource(value = "classpath:application.properties")
@Service
@Transactional
public class PrestatireServiceImpl implements PrestatireService {

    private  MsZoneApi api;

    @Autowired
    private PrestataireRepository repository;

    public PrestatireServiceImpl(MsZoneApi api) {
        this.api = api;
    }

    @Override
    public PrestatireDTO add(PrestatireDTO prestatire) {
        if(prestatire != null){
            long id=prestatire.getIdPrestation();
            Optional<NaturePrestationDTO> theExisted;
            theExisted=getNaturePrestationsById(id);
            if(theExisted.isPresent()){
                return   repository.save(prestatire.convertToEntity()).convertToDto();
            }
            throw Utilities.raiseError(MessagesCodes.ZONE_NOT_FOUND);
        }
        throw  Utilities.raiseError(MessagesCodes.BODY_REQUIRED);
    }

    @Override
    public List<PrestatireDTO> getAll() {
        List<PrestatireDTO> prestatire=new ArrayList<>();

        repository.findAll().forEach(pres ->
            prestatire.add(pres.convertToDto())
        );
        return prestatire;
    }

    @Override
    public PrestatireDTO update(PrestatireDTO prestatire) {
        if(prestatire !=null) {
            long id = prestatire.getId();
            Optional<PrestataireEntity> theExisted = repository.findById(id);
            if(theExisted.isPresent()) {
                theExisted.get().setId(prestatire.getId());
                theExisted.get().setLibelle(prestatire.getLibelle());
                return repository.save(prestatire.convertToEntity()).convertToDto();
            }
            throw Utilities.raiseError(MessagesCodes.NOT_FOUND);

        }
        throw Utilities.raiseError(MessagesCodes.BODY_REQUIRED);
    }

    @Override
    public Boolean deleteById(Optional<Long> id) {
        Optional<PrestataireEntity> theExisted;
        if (id.isPresent()) {
            theExisted = repository.findById(id.get());
        }
        else{
            throw Utilities.raiseError(MessagesCodes.ID_ERROR);
        }
        if(theExisted.isPresent()){
            repository.deleteById(theExisted.get().getId());
            return true;
        }else{

            throw Utilities.raiseError(MessagesCodes.NOT_FOUND);
        }
    }

    @Override
    public Optional<PrestatireDTO> getByID(long id) {
        Optional<PrestataireEntity> theExisted=repository.findById(id);

        if(theExisted.isPresent()){
            return theExisted.map(PrestataireEntity::convertToDto);
        }
        throw Utilities.raiseError(MessagesCodes.NOT_FOUND);

    }

    @Override
    public List<NaturePrestationDTO> getNaturePrestations() {

        ResponseEntity<List<NaturePrestationDTO>> response = api.getAllNaturePrestation();
        if(response.getStatusCode().is2xxSuccessful()){
            return  response.getBody();
        }

        throw Utilities.raiseError("NO_DATA");

    }

    @Override
    public Optional<NaturePrestationDTO> getNaturePrestationsById(long id) {
        ResponseEntity<Optional<NaturePrestationDTO>> response= api.getNaturePresatationById(id);
        if(response.getStatusCode().is2xxSuccessful()){
            return response.getBody();

        }
        throw Utilities.raiseError("NO_DATA");
    }
    }

