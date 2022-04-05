package ma.bkam.contratapi.dao.model;


import javax.persistence.*;

@Entity(name="BOREDEREUX_DE_PRIX")
public class BorederexDePrixEntity {

    private long id;
    private long numContrat;
    private String batiment;
    private String lot;
    private String familleEquipement;
    private String quantiteReel;
    private String puissance;
    private long pU;


    @Id
    @SequenceGenerator(
            name = "BOR_GENERATOR",
            sequenceName = "BOR_SEQ",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "BOR_GENERATOR")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getNumContrat() {
        return numContrat;
    }

    public void setNumContrat(long numContrat) {
        this.numContrat = numContrat;
    }

    public String getBatiment() {
        return batiment;
    }

    public void setBatiment(String batiment) {
        this.batiment = batiment;
    }

    public String getLot() {
        return lot;
    }

    public void setLot(String lot) {
        this.lot = lot;
    }

    public String getFamilleEquipement() {
        return familleEquipement;
    }

    public void setFamilleEquipement(String familleEquipement) {
        this.familleEquipement = familleEquipement;
    }

    public String getQuantiteReel() {
        return quantiteReel;
    }

    public void setQuantiteReel(String quantiteReel) {
        this.quantiteReel = quantiteReel;
    }

    public String getPuissance() {
        return puissance;
    }

    public void setPuissance(String puissance) {
        this.puissance = puissance;
    }

    public long getpU() {
        return pU;
    }

    public void setpU(long pU) {
        this.pU = pU;
    }
}
