package cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n02.S05T01N02GognomsNom.Model.Service;
import cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n02.S05T01N02GognomsNom.Model.Exception.FlorNoData;
import cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n02.S05T01N02GognomsNom.Model.Exception.FlorNoListFoundException;
import cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n02.S05T01N02GognomsNom.Model.Entity.Flor;
import cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n02.S05T01N02GognomsNom.Model.Exception.FlorNotFoundException;
import cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n02.S05T01N02GognomsNom.Model.FlorDto.FlorDto;
import cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n02.S05T01N02GognomsNom.Model.Repository.IFlorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class FlorService implements IFlorService{

    @Autowired
    private IFlorRepository florRepo;

    public FlorDto pasaraDto(Flor flor){

        FlorDto florNovaDto = new FlorDto();
        florNovaDto.setPk_FlorID(flor.getPk_FlorID());
        florNovaDto.setNomFlor(flor.getNomFlor());
        florNovaDto.setPaisFlor(flor.getPaisFlor());

        return florNovaDto;
    }

    public Flor pasaraEntity(FlorDto florDto){

        Flor florNovaEntity = new Flor();
        florNovaEntity.setPk_FlorID(florDto.getPk_FlorID());
        florNovaEntity.setNomFlor(florDto.getNomFlor());
        florNovaEntity.setPaisFlor(florDto.getPaisFlor());

        return florNovaEntity;
    }

    public Flor crearFlor(Flor flor) {

        Flor florNova = florRepo.save(new Flor(flor.getPk_FlorID(),flor.getNomFlor(),flor.getPaisFlor()));

        if(florNova == null){
            throw new FlorNoData();
        }else{
            System.out.println("P-200" + HttpStatus.CREATED);
        }
        return florNova;
    }


    public FlorDto veureUnaFlor(int id){

        FlorDto florDataDto = florRepo.findById(id)
                .map(this::pasaraDto)
                .orElseThrow(()-> new FlorNotFoundException("Id de la flor no trovada"));

        if(florDataDto == null){
            throw new FlorNotFoundException();
        }else{
            System.out.println("P-200" + HttpStatus.OK);
        }

        return florDataDto;
    }

    public List<FlorDto> veureTotesFlors(){

        List<FlorDto> florDataDtoList = florRepo.findAll()
                .stream()
                .map(this::pasaraDto)
                .collect(Collectors.toList());
        if(florDataDtoList.isEmpty()){
            throw new FlorNoListFoundException("No s´ha trovat cap flor");
        }else{
            System.out.println("P-200" + HttpStatus.OK);
        }

        return florDataDtoList;
    }

    public Flor modificarFlor(int id,Flor flor){

        FlorDto florProv = veureUnaFlor(id);

        if(florProv == null){
            throw new FlorNotFoundException("Id de la flor no trovada");
        }

        Flor florMod = new Flor();
        florMod.setPk_FlorID(florProv.getPk_FlorID());
        florMod.setNomFlor(flor.getNomFlor());
        florMod.setPaisFlor(flor.getPaisFlor());;

        if(florProv.getPk_FlorID()<1 && florProv.getNomFlor() == null && florProv.getPaisFlor()== null){
            throw new FlorNoData("Dades incorrectes, la flor está buida");
        }else {
            florRepo.save((florMod));
            System.out.println("P-200" + HttpStatus.CREATED);
        }
        return florMod;
    }

    public Flor eliminarFlor(int id) {

        FlorDto florDto = veureUnaFlor(id);

        if(florDto == null){
            throw new FlorNotFoundException("Id de la flor no trovada");
        }else {
            florRepo.delete(pasaraEntity(florDto));
            System.out.println("P-200" + HttpStatus.OK);
        }
        return (pasaraEntity(florDto));
    }

}
