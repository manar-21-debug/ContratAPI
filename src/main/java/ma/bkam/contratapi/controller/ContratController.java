package ma.bkam.contratapi.controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import ma.bkam.contratapi.common.dto.ContratDTO;
import ma.bkam.contratapi.common.dto.zone.ZoneDTO;
import ma.bkam.contratapi.common.swagger.SwaggerDocConst;
import ma.bkam.contratapi.service.ContratService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Api(tags = {SwaggerDocConst.CONTRAT_CONTROLLER_TAG})
@RestController
@RequestMapping("/contrat")
public class ContratController {


    @Autowired
    private ContratService service;


    @ApiOperation(SwaggerDocConst.CREATE)
    @PostMapping(value = "/add")
    public ResponseEntity<ContratDTO> create(@RequestBody ContratDTO contrat) {
        ContratDTO x = service.add(contrat);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(x);
    }



    @GetMapping(value=("/getZones"), produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(SwaggerDocConst.GET_ZONES)
    public ResponseEntity<List<ZoneDTO>> getZones() {
        return ResponseEntity.ok()
                .body(service.getZones());
    }

    @GetMapping(value=("/getZoneById/{id}"), produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(SwaggerDocConst.GET_ZONE_BT_ID)
    public ResponseEntity<Optional<ZoneDTO>> getZones(@PathVariable long id) {
        return ResponseEntity.ok()
                .body(service.getZoneByID(id));
    }


    @ApiOperation(SwaggerDocConst.LIST)
    @GetMapping(value = "/getAll", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ContratDTO>> getAll() {

        List<ContratDTO> response = service.getAll();

        return ResponseEntity.status(HttpStatus.OK)
                .body(response);
    }
}
