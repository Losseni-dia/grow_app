package grow.backend.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
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

    @NotBlank(message = "Le nom du projet ne peut être vide.")
    @Size(min = 2, max = 60, message = "La taille du nom du projet doit être compris entre 2 et 60 caractères .")
    private String libelle;

    @NotBlank(message = "La description du projet ne peut être vide.")
    @Size(min = 2, max = 60, message = "La description du projet doit être comprise entre 2 et 60 caractères .")
    private String description;

    @DecimalMin(value = "0.0", inclusive = false, message = "La valuation doit être un nombre positif")
    private double valuation;

    @NotBlank(message = "Le secteur du projet ne peut être vide.")
    private String secteur;

    
    @DecimalMin(value = "0.0", inclusive = true, message = "Le ROI projeté doit être positif ou nul")
    @DecimalMax(value = "100.0", message = "Le ROI projeté ne peut pas dépasser 100%")
    private double roiProjete;

    @Enumerated(EnumType.STRING)
    private StatutProjet statutProjet;
    
    @NotBlank(message = "Le nom du projet ne peut être vide.")
    @Column(name = "business_plan")
    private String businessPlan;

    @ManyToOne
    @JoinColumn(name = "porteur_projet_id" )
    private PorteurProjet porteurProjet;

    @ManyToOne
    @JoinColumn(name = "site_id")
    private SiteProjet siteProjet;

    @OneToMany(mappedBy = "projet",cascade = CascadeType.ALL, orphanRemoval = true)
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
