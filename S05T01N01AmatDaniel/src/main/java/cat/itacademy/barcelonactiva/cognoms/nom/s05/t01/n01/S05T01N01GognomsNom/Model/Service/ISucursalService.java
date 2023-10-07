package cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n01.S05T01N01GognomsNom.Model.Service;

import cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n01.S05T01N01GognomsNom.Model.Dto.SucursalDto;
import cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n01.S05T01N01GognomsNom.Model.Entity.Sucursal;

import java.util.List;

public interface ISucursalService {

    Sucursal crearSucursal(Sucursal sucursal);
    SucursalDto veureUnaSucursal(int id);
    List<SucursalDto> veureTotesSucursals();
    Sucursal modificarSucursal(int id,Sucursal sucursal);
    Sucursal eliminarSucursal(int id);

}
