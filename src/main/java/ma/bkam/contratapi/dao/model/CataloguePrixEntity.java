package ma.bkam.contratapi.dao.model;



import javax.persistence.*;

@Entity(name="CATALOGUE_PRIX")
public class CataloguePrixEntity{



    private long id;
    private String nature;
    private String article;
    private String critere;
    private String limiteChargeBanque;
    private double prix;
    private int quantite;
    private long numeroContrat;
    private String zone;

    

    @Id
    @SequenceGenerator(
            name = "CATPRIX_GENERATOR",
            sequenceName = "CATPRIX_SEQ",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CATPRIX_GENERATOR")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNature() {
        return nature;
    }

    public void setNature(String nature) {
        this.nature = nature;
    }

    public String getArticle() {
        return article;
    }

    public void setArticle(String article) {
        this.article = article;
    }

    public String getCritere() {
        return critere;
    }

    public void setCritere(String critere) {
        this.critere = critere;
    }

    public String getLimiteChargeBanque() {
        return limiteChargeBanque;
    }

    public void setLimiteChargeBanque(String limiteChargeBanque) {
        this.limiteChargeBanque = limiteChargeBanque;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public long getNumeroContrat() {
        return numeroContrat;
    }

    public void setNumeroContrat(long numeroContrat) {
        this.numeroContrat = numeroContrat;
    }

    public String getZone() {
        return zone;
    }

    public void setZone(String zone) {
        this.zone = zone;
    }


}
