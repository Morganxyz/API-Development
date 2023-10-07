package cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n02.S05T01N02GognomsNom.Model.Entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@jakarta.persistence.Entity
@Table(name="Flor")
public class Flor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int pk_FlorID;
    @Column
    private String nomFlor;
    @Column
    private String PaisFlor;

}
