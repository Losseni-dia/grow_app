package grow.backend.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "projets")
@Getter
@Setter
@NoArgsConstructor
public class Projet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String libelle;

    private String description;

    private double valuation;

    private String secteur;

    private double roiProjete;

    @Enumerated(EnumType.STRING)
    private StatutProjet statutProjet;

    @Column(name = "business_plan")
    private int businessPlan;

    @ManyToOne
    @JoinColumn(name = "porteur_projet_id")
    private PorteurProjet porteurProjet;

    @ManyToOne
    @JoinColumn(name = "site_id")
    private SiteProjet siteProjet;

    @OneToMany(mappedBy = "projet", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Campagne> campagnes = new ArrayList<>();


    public void setPorteurProjet(PorteurProjet porteurProjet) {
        this.porteurProjet = porteurProjet;
        if (porteurProjet != null && !porteurProjet.getProjets().contains(this)) {
            porteurProjet.getProjets().add(this);
        }
    }
    
    public void setSiteProjet(SiteProjet site) {
        this.siteProjet = site;
        if (siteProjet != null && !siteProjet.getProjets().contains(this)) {
            siteProjet.getProjets().add(this);
        }
    }

    public void addCampagne(Campagne campagne) {
        campagnes.add(campagne);
        if (campagne.getProjet() != this) {
            campagne.setProjet(this);
        }
    }

    public void removeCampagne(Campagne campagne) {
        campagnes.remove(campagne);
        if (campagne.getProjet() == this) {
            campagne.setProjet(null);
        }
    }
}
