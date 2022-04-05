package ma.bkam.contratapi.dao.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import ma.bkam.contratapi.common.dto.ContratDTO;
import ma.bkam.contratapi.common.dto.PrestatireDTO;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity(name="CONTRAT")
public class ContratEntity extends GenericEntity{


    @Id
    @SequenceGenerator(
            name = "CONTRAT_GENERATOR",
            sequenceName = "CONTRAT_SEQ",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CONTRAT_GENERATOR")
    @Override
    public Long getId() {
        return super.getId();
    }

    @NonNull
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date dateDebut;
    @NonNull
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date dateFin;

    private PrestataireEntity prestataire;

    @OneToOne
    @JoinColumn(name = "idPrestatire", referencedColumnName = "id")
    public PrestataireEntity getPrestataire() {
        return prestataire;
    }

    public void setPrestataire(PrestataireEntity prestataire) {
        this.prestataire = prestataire;
    }

    private long idZone;

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
    public ContratDTO convertToDto()
    {
        ContratDTO contrat=new ContratDTO();
        contrat.setId(this.id);
        contrat.setDateDebut(this.dateDebut);
        contrat.setDateFin(this.dateFin);
        contrat.setIdZone(this.idZone);
        contrat.setPrestataire(Objects.isNull(this.prestataire)? new PrestatireDTO():this.prestataire.convertToDto());
        return contrat;
    }
}
