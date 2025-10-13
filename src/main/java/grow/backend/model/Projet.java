package grow.backend.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

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
    private SiteProjet site;
}
