package cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n03.S05T01N03AmatDaniel.Model.Service;

import cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n03.S05T01N03AmatDaniel.Model.Dto.FlorDto;
import cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n03.S05T01N03AmatDaniel.Model.Entity.Flor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.reactive.function.client.ClientResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


public interface IFlorService {

    Mono<Flor> crearFlorMono(Flor flor);

    Mono<FlorDto> veureUnaFlorMono(int id);

    Flux<FlorDto> veureTotesFlorsFlux();

    Mono<Flor> modificarFlorMono(int id, Flor flor);

    Mono<Flor> eliminarFlorMono(int id);
}
