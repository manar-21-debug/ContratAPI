package ma.bkam.contratapi.common.dto.zone;




import java.util.List;

public class ZoneDTO  {

    private long id;
    private String abrev;
    private String libelle;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    private List<VilleDTO> villes;

    public List<VilleDTO> getVilles() {
        return villes;
    }

    public void setVilles(List<VilleDTO> villes) {
        this.villes = villes;
    }

    public String getAbrev() {
        return abrev;
    }

    public void setAbrev(String abrev) {
        this.abrev = abrev;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }





}