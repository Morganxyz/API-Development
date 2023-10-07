package cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n03.S05T01N03AmatDaniel.Model.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.domain.EntityScan;


@Data
@AllArgsConstructor
@NoArgsConstructor
@EntityScan
public class Flor {

    private int pk_FlorID;
    private String nomFlor;
    private String PaisFlor;

}
