package cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n01.S05T01N01GognomsNom.Model.Dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SucursalDto {

    private int pk_SucursalID;
    private String nomSucursal;
    private String paisSucursal;
    private String tipoSucursal;


    private List<String> paisos = new ArrayList<String>(Arrays.asList("Alemania","Bélgica","Croacia","Dinamarca","España","Francia", "Irlanda", "Letonia", "Luxemburgo", "Países Bajos",
            "Suecia","Bulgaria", "Eslovaquia", "Estonia", "Grecia", "Malta", "Polonia", "República Checa", "Austria", "Chipre", "Eslovenia", "Finlandia", "Hungría", "Italia",
            "Lituania", "Portugal" , "Rumanía"));

    public String getTipoSucursal(){

        int i = 0;
        int posPais = -1;
        String ue = "UE";
        String foraUe = "Fora UE";
        boolean esc = false;

        while(i < this.getPaisos().size() && !esc){
            String pais = this.getPaisos().get(i);

            if(this.getPaisSucursal().equalsIgnoreCase(pais)){
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
