package ma.bkam.contratapi.common.dto;

import ma.bkam.contratapi.dao.model.GenericEntity;

public abstract class GenericDTO {


    Long id;


    public abstract  <T extends GenericEntity>  T convertToEntity();


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
