package ma.bkam.contratapi.service.implementation;

import ma.bkam.contratapi.common.client.MsZoneApi;
import ma.bkam.contratapi.common.dto.ContratDTO;
import ma.bkam.contratapi.common.dto.naturePrestation.NaturePrestationDTO;
import ma.bkam.contratapi.common.dto.zone.ZoneDTO;
import ma.bkam.contratapi.common.utils.MessagesCodes;
import ma.bkam.contratapi.common.utils.Utilities;
import ma.bkam.contratapi.dao.repository.ContratRepository;
import ma.bkam.contratapi.service.ContratService;
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
public class ContratServiceImpl implements ContratService {

    private  MsZoneApi zoneApi;

    @Autowired
    private ContratRepository repository;

    public ContratServiceImpl(MsZoneApi zoneApi) {
        this.zoneApi = zoneApi;
    }

    @Override
    public ContratDTO add(ContratDTO contrat) {
        if(contrat != null){
            long id=contrat.getIdZone();
                Optional<ZoneDTO> theExisted=Optional.empty();
                 theExisted=getZoneByID(id);
            if(getZoneByID(id).isPresent()){
                return   repository.save(contrat.convertToEntity()).convertToDto();
            }
            throw Utilities.raiseError(MessagesCodes.ZONE_NOT_FOUND);
        }
        throw  Utilities.raiseError(MessagesCodes.BODY_REQUIRED);
    }

    @Override
    public List<ContratDTO> getAll() {

        List<ContratDTO> contrats =new ArrayList<>();

        repository.findAll().forEach(contrat ->
                contrats.add(contrat.convertToDto())
        );
        return contrats;
    }

    @Override
    public ContratDTO update(ContratDTO contrat) {
        return null;
    }

    @Override
    public Boolean deleteById(Optional<Long> id) {
        return null;
    }

    @Override
    public Optional<ContratDTO> getByID(long id) {
        return Optional.empty();
    }

    @Override
    public List<ZoneDTO> getZones() {
        ResponseEntity<List<ZoneDTO>> response=zoneApi.getAll();
        if(response.getStatusCode().is2xxSuccessful()){
            return response.getBody();
        }
        throw Utilities.raiseError("NO_DATA");
    }

    @Override
    public Optional<ZoneDTO> getZoneByID(long id) {
        ResponseEntity<Optional<ZoneDTO>> response=zoneApi.getById(id);
        if(response.getStatusCode().is2xxSuccessful()){
            return response.getBody();
        }
        throw Utilities.raiseError("NO_DATA");
    }


}
