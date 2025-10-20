package grow.backend.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "localites")
@Data
@NoArgsConstructor
public class Localite {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String codePostal;

    private String nom;

    @ManyToOne
    @JoinColumn(name = "pays_id")
    private Pays pays;

    @OneToMany(mappedBy = "localite")
    private List<SiteProjet> sites  = new ArrayList<>();


    public void setPays(Pays pays) {
        this.pays = pays;
        if (pays != null && !pays.getLocalites().contains(this)) {
            pays.getLocalites().add(this);
        }
    }


    public void addSite(SiteProjet site) {
        sites.add(site);
        if (site.getLocalite() != this) {
            site.setLocalite(this);
        }
    }

    public void removeSite(SiteProjet site) {
        sites.remove(site);
        if (site.getLocalite() != this) {
            site.setLocalite(null);
        }
    }
}
