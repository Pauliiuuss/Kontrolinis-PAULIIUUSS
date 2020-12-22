package lt2020.sveikinimai.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Sveikinimai")
public class Sveikinimas {

    @ManyToOne
    @JoinColumn(name = "SveikinimoVieta_id")
    public SveikinimoVieta sveikinimoVieta;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int id;
    public String pilnasVardas;
    public String tekstas;

}
