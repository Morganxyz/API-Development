package cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n03.S05T01N03AmatDaniel.Model.Dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EntityScan
public class FlorDto {

    private int pk_FlorID;
    private String nomFlor;
    private String paisFlor;
    private String tipoFlor;


    private List<String> paisos = new ArrayList<String>(Arrays.asList("Alemania","Bélgica","Croacia","Dinamarca","España","Francia", "Irlanda", "Letonia", "Luxemburgo", "Países Bajos",
            "Suecia","Bulgaria", "Eslovaquia", "Estonia", "Grecia", "Malta", "Polonia", "República Checa", "Austria", "Chipre", "Eslovenia", "Finlandia", "Hungría", "Italia",
            "Lituania", "Portugal" , "Rumanía"));

    public String getTipoFlor(){

        int i = 0;
        int posPais = -1;
        String ue = "UE";
        String foraUe = "Fora UE";
        boolean esc = false;

        while(i < this.getPaisos().size() && !esc){
            String pais = this.getPaisos().get(i);

            if(this.getPaisFlor().equalsIgnoreCase(pais)){
                posPais = 0;
            }
            i++;
        }

        if(posPais == 0){
            return ue;
        }else{
            return foraUe;
        }
    }
}
