package grow.backend.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Entity
@Table(name = "localités")
@Data
@NoArgsConstructor
public class Localite {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;

    @ManyToOne
    @JoinColumn(name = "pays_id")
    private Pays pays;

    @OneToMany(mappedBy = "localite")
    private List<SiteProjet> sites;


    public void setPays(Pays pays) {
        this.pays = pays;
        if (pays != null && !pays.getLocalites().contains(this)) {
            pays.getLocalites().add(this);
        }
    }


    public void addSiteProjet(SiteProjet site) {
        sites.add(site);
        if (site.getLocalite() != this) {
            site.setLocalite(this);
        }
    }

    public void removesite(SiteProjet site) {
        sites.remove(site);
        if (site.getLocalite() != this) {
            site.setLocalite(null);
        }
    }
}
