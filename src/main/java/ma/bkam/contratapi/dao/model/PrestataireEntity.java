package ma.bkam.contratapi.dao.model;


import ma.bkam.contratapi.common.dto.PrestatireDTO;
import org.springframework.lang.NonNull;

import javax.persistence.*;

@Entity(name = "PRESTATIRE")
public class PrestataireEntity extends GenericEntity{

    @Id
    @SequenceGenerator(
            name = "PRESTATIRE_GENERATOR",
            sequenceName = "PRESTATIRE_SEQ",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PRESTATIRE_GENERATOR")
    @Override
    public Long getId() {
        return super.getId();
    }

@NonNull
private String libelle;
    private long idPrestation;


    private ContratEntity contrat;

    @OneToOne(mappedBy = "prestataire")
    public ContratEntity getContrat() {
        return contrat;
    }

    public void setContrat(ContratEntity contrat) {
        this.contrat = contrat;
    }

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
    public PrestatireDTO convertToDto() {
        PrestatireDTO prestataire=new PrestatireDTO();
        prestataire.setId(this.id);
        prestataire.setLibelle(this.libelle);
        prestataire.setIdPrestation(this.idPrestation);
        return prestataire;
    }
}
