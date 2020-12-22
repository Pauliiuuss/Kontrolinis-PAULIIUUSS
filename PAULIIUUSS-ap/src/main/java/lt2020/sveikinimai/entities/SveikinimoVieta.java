package lt2020.sveikinimai.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="SveikinimoVietos")
public class SveikinimoVieta {

    @OneToMany(mappedBy = "id")
    public Set<Sveikinimas> sveikinimai;

    @OneToMany(mappedBy = "id")
    public Set<SveikinimoAdresas> sveikinimoAdresai;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int id;

    public String pavadinimas;


}
