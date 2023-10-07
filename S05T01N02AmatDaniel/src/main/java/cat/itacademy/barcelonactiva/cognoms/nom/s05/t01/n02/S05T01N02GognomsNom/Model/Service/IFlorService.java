package cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n02.S05T01N02GognomsNom.Model.Service;

import cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n02.S05T01N02GognomsNom.Model.Entity.Flor;
import cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n02.S05T01N02GognomsNom.Model.FlorDto.FlorDto;

import java.util.List;

public interface IFlorService {

    Flor crearFlor(Flor flor);

    FlorDto veureUnaFlor(int id);

    List<FlorDto> veureTotesFlors();

    Flor modificarFlor(int id, Flor flor);

    Flor eliminarFlor(int id);

}