package ma.bkam.contratapi.common.dto;

import ma.bkam.contratapi.dao.model.ContratEntity;

import java.util.Date;
import java.util.Objects;

public class ContratDTO extends GenericDTO{


    private long idZone;
    private Date dateDebut;
    private Date dateFin;
    private PrestatireDTO prestataire;

    public PrestatireDTO getPrestataire() {
        return prestataire;
    }

    public void setPrestataire(PrestatireDTO prestataire) {
        this.prestataire = prestataire;
    }

    public long getIdZone() {
        return idZone;
    }

    public void setIdZone(long idZone) {
        this.idZone = idZone;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }


    @Override
    public ContratEntity convertToEntity()
    {
        ContratEntity contrat=new ContratEntity();
        contrat.setId(this.id);
        contrat.setDateFin(this.dateFin);
        contrat.setDateDebut(this.dateDebut);
        contrat.setIdZone(this.idZone);
        contrat.setPrestataire(Objects.isNull(this.prestataire) ? null : this.prestataire.convertToEntity());
        return contrat;
    }

}
