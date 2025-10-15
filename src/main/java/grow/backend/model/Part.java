package grow.backend.model;

import java.util.List;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "parts")
@Data
@NoArgsConstructor
public class Part {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int nombreParts;
    private double pourcentEquity;
    private double valeurInitiale;
    @Enumerated(EnumType.STRING)
    private StatutPart statutPart;

    @OneToOne
    @JoinColumn(name = "investissement_id")
    private Investissement investissement;

    @OneToMany(mappedBy = "part", cascade = CascadeType.ALL)
    private List<Dividende> dividendes;


    public void setInvestissement(Investissement invest) {
        this.investissement = invest;
        if (invest != null && !invest.getPart().equals(this)) {
            invest.setPart(this);
        }
    }

    public void addDividende(Dividende dividende) {
        dividendes.add(dividende);
        if (dividende.getPart() != this) {
            dividende.setPart(this);
        }
    }

    public void removeProje(Dividende dividende) {
        dividendes.remove(dividende);
        if (dividende.getPart() != this) {
            dividende.setPart(null);
        }
    }
}