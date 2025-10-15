package grow.backend.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Entity
@Table(name = "dividendes")
@Data
@NoArgsConstructor
public class Dividende {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double montantParPart;
    @Enumerated(EnumType.STRING)
    private StatutDividende statutDividende;
    @Enumerated(EnumType.STRING)
    private MoyenPaiement moyenPaiement;
    private LocalDateTime datePaiement;

    @ManyToOne
    @JoinColumn(name = "part_id")
    private Part part;


    public void setPart(Part part) {
        this.part = part;
        if (part!= null && !part.getDividendes().contains(this)) {
            part.getDividendes().add(this);
        }
    }
}
