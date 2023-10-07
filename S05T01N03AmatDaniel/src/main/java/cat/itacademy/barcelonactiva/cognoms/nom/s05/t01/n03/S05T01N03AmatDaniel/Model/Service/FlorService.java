package cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n03.S05T01N03AmatDaniel.Model.Service;

import cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n03.S05T01N03AmatDaniel.Model.Dto.FlorDto;
import cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n03.S05T01N03AmatDaniel.Model.Entity.Flor;
import cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n03.S05T01N03AmatDaniel.Model.Repository.FlorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FlorService implements IFlorService{

    @Autowired
    private FlorRepository florRepository;


    public Mono<Flor> crearFlorMono(Flor flor) {

        return florRepository.saveFlower(flor);
    }

    public Mono<FlorDto> veureUnaFlorMono(int id){

        return florRepository.getOneFlower(id);
    }

    public Flux<FlorDto> veureTotesFlorsFlux(){

        return florRepository.getAllFlowers();
    }

    public Mono<Flor> modificarFlorMono(int id,Flor flor) {

      return florRepository.updateFlower(id,flor);
    }

    public Mono<Flor> eliminarFlorMono(int id) {

     return florRepository.deleteFlor(id);
    }


}
