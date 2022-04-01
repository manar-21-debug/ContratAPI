package ma.bkam.contratapi.dao.model;

import ma.bkam.contratapi.common.dto.GenericDTO;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class GenericEntity {

    Long id;


    public abstract  <T extends GenericDTO> T convertToDto();

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
