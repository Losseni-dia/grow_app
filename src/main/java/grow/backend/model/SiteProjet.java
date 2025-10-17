package grow.backend.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Entity
@Table(name = "siteprojets")
@Data
@NoArgsConstructor
public class SiteProjet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;

    @ManyToOne
    @JoinColumn(name = "localite_id")
    private Localite localite;

    @OneToMany(mappedBy = "siteProjet")
    private List<Projet> projets;

    public void setLocalite(Localite localite) {
        this.localite = localite;
        if (localite != null && !localite.getSites().contains(this)) {
            localite.getSites().add(this);
        }
    }

    public void addProjet(Projet projet) {
        projets.add(projet);
        if (projet.getSiteProjet() != this) {
            projet.setSiteProjet(this);
        }
    }

    public void removeProjet(Projet projet) {
        if (projet.getSiteProjet() != this) {
            projet.setSiteProjet(null);
        }
    }
}
