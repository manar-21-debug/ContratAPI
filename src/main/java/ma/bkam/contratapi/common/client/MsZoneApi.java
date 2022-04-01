package ma.bkam.contratapi.common.client;



import ma.bkam.contratapi.common.dto.naturePrestation.NaturePrestationDTO;
import ma.bkam.contratapi.common.dto.zone.ZoneDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@PropertySource(value = "classpath:application.properties")
@FeignClient(
        name = "zoneapi",
        url = "${url.ms.zoneApi}")
public interface MsZoneApi {


    @GetMapping(value = "/zone/getAll", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ZoneDTO>> getAll();


    @GetMapping(value = "zone/getbyid/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Optional<ZoneDTO>> getById(@PathVariable long id);


    @GetMapping(value = "/naturePrestation/getAll", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<NaturePrestationDTO>> getAllNaturePrestation();


    @GetMapping(value = "naturePrestation/getbyid/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Optional<NaturePrestationDTO>> getNaturePresatationById(@PathVariable long id);



}
