package grow.backend.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Entity
@Table(name = "pays")
@Data
@NoArgsConstructor
public class Pays {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;

    @OneToMany(mappedBy = "pays")
    private List<Localite> localites;

    public void addLocalite(Localite localite) {
        localites.add(localite);
        if (localite.getPays() != this) {
            localite.setPays(this);
        }
    }

    public void removeProjet(Localite localite) {
        localites.remove(localite);
        if (localite.getPays() != this) {
            localite.setPays(null);
        }
    }
}
