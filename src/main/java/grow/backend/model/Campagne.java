package grow.backend.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import grow.backend.model.Campagne;

@Entity
@Table(name = "campagnes")
@Data
@NoArgsConstructor
public class Campagne {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer reference;

    private String libelle;
    
    private double objectifFinancement;

    @Column(name= "financement_debut")
    private LocalDateTime dateDebut;

    @Column(name = "financement_fin")
    private LocalDateTime dateFin;

    private int partsDisponible;

    private double pourcentParts;

    @Column(name = "medias_url")
    private String mediasUrl; // vidéos, docs etc.

    private String docProjetPath; // chemin ou référence fichier

    @ManyToOne()
    @JoinColumn(name = "projet_id")
    private Projet projet;

    @OneToMany(mappedBy = "campagne", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Investissement> investissements = new ArrayList<>();

    // Méthode utile pour gérer la relation bidirectionnelle
    public void setProjet(Projet projet) {
        this.projet.removeCampagne(this);
        this.projet.addCampagne(this);
    }

    public void addInvestissement(Investissement investissement) {
        investissements.add(investissement);
        if (investissement.getCampagne() != this) {
            investissement.setCampagne(this);
        }
    }

    public void removeInvestissement(Investissement investissement) {
        investissements.remove(investissement);
        if (investissement.getCampagne() == this) {
            investissement.setCampagne(null);
        }
    }

   
}
