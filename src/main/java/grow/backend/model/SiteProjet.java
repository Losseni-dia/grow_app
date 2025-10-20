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

    private String adresse;

    private String contact;

    private String responsable;

    @ManyToOne
    @JoinColumn(name = "localite_id", nullable=false)
    private Localite localite;

    @OneToMany(mappedBy = "siteProjet")
    private List<Projet> projets;


    public void setLocalite(Localite localite) {
        this.localite.removeSite(this); // déménager de l’ancienne localité
        this.localite = localite;
        this.localite.addSite(this); // emménager dans la nouvelle localité
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
