package grow.backend.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Entity
@Table(name = "porteur_projets")
@Data
@NoArgsConstructor
public class PorteurProjet extends User {

    @OneToMany(mappedBy = "porteurProjet", cascade = CascadeType.ALL)
    private List<Projet> projets;
}
