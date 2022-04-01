package ma.bkam.contratapi.service;

import ma.bkam.contratapi.common.dto.PrestatireDTO;
import ma.bkam.contratapi.common.dto.naturePrestation.NaturePrestationDTO;

import java.util.List;
import java.util.Optional;

public interface PrestatireService {

    PrestatireDTO add(PrestatireDTO prestatire);

    List<PrestatireDTO> getAll();


    PrestatireDTO update(PrestatireDTO prestatire);


    Boolean deleteById(Optional<Long> id);


    Optional<PrestatireDTO> getByID(long id);

    List<NaturePrestationDTO> getNaturePrestations();

    Optional<NaturePrestationDTO> getNaturePrestationsById(long id);
}
