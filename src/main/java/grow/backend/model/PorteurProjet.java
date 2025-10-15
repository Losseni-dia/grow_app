package grow.backend.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "porteur_projets")
@NoArgsConstructor
public class PorteurProjet extends User {

    @OneToMany(mappedBy = "porteurProjet", cascade = CascadeType.ALL)
    private List<Projet> projets;


    public void addProjet(Projet projet) {
        projets.add(projet);
        if (projet.getPorteurProjet() != this) {
            projet.setPorteurProjet(this);
        }
    }

    public void removeProjet(Projet projet) {
        projets.remove(projet);
        if (projet.getPorteurProjet() != this) {
            projet.setPorteurProjet(null);
        }
    }
}
