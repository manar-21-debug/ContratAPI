package ma.bkam.contratapi.common.dto;


import ma.bkam.contratapi.dao.model.PrestataireEntity;

public class PrestatireDTO extends GenericDTO {

    private long idPrestation;
    private String libelle;

    public long getIdPrestation() {
        return idPrestation;
    }

    public void setIdPrestation(long idPrestation) {
        this.idPrestation = idPrestation;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    @Override
    public PrestataireEntity convertToEntity() {
        PrestataireEntity prestataire=new PrestataireEntity();
        prestataire.setId(this.id);
        prestataire.setLibelle(this.libelle);
        prestataire.setIdPrestation(this.idPrestation);
        return prestataire;
    }
}
