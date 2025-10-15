package grow.backend.model;

import java.time.LocalDateTime;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "investissements")
@Data
@NoArgsConstructor
public class Investissement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double montant;

    private LocalDateTime date;

    @Enumerated(EnumType.STRING)
    private MoyenPaiement moyenPaiement;

    private double frais; // 3-5%

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "campagne_id")
    private Campagne campagne;

    @ManyToOne
    @JoinColumn(name = "investisseur_id")
    private Investisseur investisseur;

    @OneToOne(mappedBy = "investissement", cascade = CascadeType.ALL)
    private Part part;


        
    public void setCampagne(Campagne campagne) {
        this.campagne = campagne;
        if (campagne != null && !campagne.getInvestissements().contains(this)) {
            campagne.getInvestissements().add(this);
        }
    }

    public void setInvestisseur(Investisseur investisseur) {
        this.investisseur = investisseur;
        if (investisseur != null && !investisseur.getInvestissements().contains(this)) {
            investisseur.getInvestissements().add(this);
        }
    }

    public void setPart(Part part) {
        this.part = part;
        if (part != null && !part.getInvestissement().equals(this)) {
            part.setInvestissement(this);
        }
    }


}
