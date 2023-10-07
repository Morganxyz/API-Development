package cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n01.S05T01N01GognomsNom.Model.Service;
import cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n01.S05T01N01GognomsNom.Model.Dto.SucursalDto;
import cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n01.S05T01N01GognomsNom.Model.Entity.Sucursal;
import cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n01.S05T01N01GognomsNom.Model.Excepcion.SucursalExcepcion;
import cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n01.S05T01N01GognomsNom.Model.Repository.SucursalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SucursalService implements ISucursalService{

    @Autowired
    private SucursalRepository sucursalRepo;

    public SucursalDto pasaraDto(Sucursal sucursal){

        SucursalDto sucursalNovaDto = new SucursalDto();
        sucursalNovaDto.setPk_SucursalID(sucursal.getPk_SucursalID());
        sucursalNovaDto.setNomSucursal(sucursal.getNomSucursal());
        sucursalNovaDto.setPaisSucursal(sucursal.getPaisSucursal());

        return sucursalNovaDto;
    }

    public Sucursal pasaraEntity(SucursalDto sucursalDto){

        Sucursal sucursalNovaEntity = new Sucursal();
        sucursalNovaEntity .setPk_SucursalID(sucursalDto.getPk_SucursalID());
        sucursalNovaEntity .setNomSucursal(sucursalDto.getNomSucursal());
        sucursalNovaEntity .setPaisSucursal(sucursalDto.getPaisSucursal());

        return sucursalNovaEntity;
    }

    public Sucursal crearSucursal(Sucursal sucursal) {

        Sucursal sucursalNova = sucursalRepo.save(new Sucursal(sucursal.getPk_SucursalID(),sucursal.getNomSucursal(),sucursal.getPaisSucursal()));

        return sucursalNova;
    }


    public SucursalDto veureUnaSucursal(int id){

        SucursalDto sucursalDataDto = sucursalRepo.findById(id)
                     .map(this::pasaraDto)
                .orElseThrow(()-> new SucursalExcepcion("La Id no corresponde a ninguna sucursal"));

        return sucursalDataDto;
    }

    public List<SucursalDto> veureTotesSucursals(){

        List<SucursalDto> sucursalDataDtoList = sucursalRepo.findAll()
                .stream()
                .map(this::pasaraDto)
                .collect(Collectors.toList());

        return sucursalDataDtoList;
    }

    public Sucursal modificarSucursal(int id,Sucursal sucursal){

        SucursalDto sucursalProv = veureUnaSucursal(id);

        Sucursal sucursalMod = new Sucursal();
        sucursalMod.setPk_SucursalID(sucursalProv.getPk_SucursalID());
        sucursalMod.setNomSucursal(sucursal.getNomSucursal());
        sucursalMod.setPaisSucursal(sucursal.getPaisSucursal());;

        sucursalRepo.save((sucursalMod));

        return sucursalMod;

    }

    public Sucursal eliminarSucursal(int id) {

        SucursalDto sucursalDto = veureUnaSucursal(id);
        sucursalRepo.delete(pasaraEntity(sucursalDto));

        return (pasaraEntity(sucursalDto));

    }

}


