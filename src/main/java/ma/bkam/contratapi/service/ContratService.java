package ma.bkam.contratapi.service;

import ma.bkam.contratapi.common.dto.ContratDTO;
import ma.bkam.contratapi.common.dto.naturePrestation.NaturePrestationDTO;
import ma.bkam.contratapi.common.dto.zone.ZoneDTO;

import java.util.List;
import java.util.Optional;

public interface ContratService {

    ContratDTO add(ContratDTO contrat);

    List<ContratDTO> getAll();


    ContratDTO update(ContratDTO contrat);


    Boolean deleteById(Optional<Long> id);


    Optional<ContratDTO> getByID(long id);

    List<ZoneDTO> getZones();

    Optional<ZoneDTO> getZoneByID(long id);


}
