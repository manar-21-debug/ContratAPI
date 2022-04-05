package ma.bkam.contratapi.controller;

import ma.bkam.contratapi.common.Helper.ExcelHelper;
import ma.bkam.contratapi.common.dto.SimpleMessageResponseModel;
import ma.bkam.contratapi.dao.model.CataloguePrixEntity;
import ma.bkam.contratapi.service.CataloguePrixService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Controller
@RequestMapping("/catalogue")
public class CataloguePrixController {
    @Autowired
    private CataloguePrixService service ;

    @PostMapping("/upload")
    public ResponseEntity<SimpleMessageResponseModel> uploadFile(@RequestParam("file") MultipartFile file) {
        String message = "";
        if (ExcelHelper.hasExcelFormat(file)) {
            try {
                service.save(file);
                message = "Uploaded the file successfully: " + file.getOriginalFilename();
                return ResponseEntity.status(HttpStatus.OK).body(new SimpleMessageResponseModel(message));
            } catch (Exception e) {
                message = "Could not upload the file: " + file.getOriginalFilename() + "!";
                return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new SimpleMessageResponseModel(message));
            }
        }
        message = "Please upload an excel file!";
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new SimpleMessageResponseModel(message));
    }

    @GetMapping("/getAllCatalogues")
    public ResponseEntity<List<CataloguePrixEntity>> getAllCatalogues() {
        try {
            List<CataloguePrixEntity> tutorials = service.getAllCataloguePrixEntities();
            if (tutorials.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(tutorials, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
