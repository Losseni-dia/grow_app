package grow.backend.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "investisseurs")
@Data
@NoArgsConstructor
public class Investisseur extends User {
    private double portefeuilleTotal;
    private boolean diaspora;

    @OneToMany(mappedBy = "investisseur", cascade = CascadeType.ALL)
    private List<Investissement> investissements;

    public void addInvestissement(Investissement investissement) {
        investissements.add(investissement);
        if (investissement.getInvestisseur() != this) {
            investissement.setInvestisseur(this);
        }
    }

    public void removeInvestissement(Investissement investissement) {
        investissements.remove(investissement);
        if (investissement.getInvestisseur() == this) {
            investissement.setInvestisseur(null);
        }
    }
}