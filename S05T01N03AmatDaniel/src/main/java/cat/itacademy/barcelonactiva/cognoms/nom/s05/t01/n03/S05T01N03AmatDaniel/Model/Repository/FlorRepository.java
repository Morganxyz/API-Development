package cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n03.S05T01N03AmatDaniel.Model.Repository;

import cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n03.S05T01N03AmatDaniel.Model.Dto.FlorDto;
import cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n03.S05T01N03AmatDaniel.Model.Entity.Flor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Repository;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public class FlorRepository {

    private final WebClient webClient;

    @Autowired
    public FlorRepository(WebClient.Builder webClientBuilder){
        this.webClient = webClientBuilder
                .baseUrl("http://localhost:9001")
                .build();
    }

    public Mono<Flor> saveFlower(Flor flor) {

        return this.webClient.post()
                .uri("/flor/add")
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .body(Mono.just(flor),Flor.class)
                .retrieve()
                .bodyToMono(Flor.class);
    }

    public Mono<FlorDto> getOneFlower(int id) {

        return this.webClient.get()
                .uri("/flor/getOne/{id}")
                .retrieve()
                .bodyToMono(FlorDto.class);
    }

    public Flux<FlorDto> getAllFlowers() {

        return this.webClient.get()
                .uri("/flor/getAll")
                .retrieve()
                .bodyToFlux(FlorDto.class);
    }

    public Mono<Flor> updateFlower(int id, Flor flor) {

        return this.webClient.put()
                .uri("/flor/update/{id}")
                .header(HttpHeaders.CONTENT_TYPE,MediaType.APPLICATION_JSON_VALUE)
                .body(Mono.just(flor),Flor.class)
                .retrieve()
                .bodyToMono(Flor.class);
    }

    public Mono deleteFlor(int id) {

        return this.webClient.delete()
                .uri("/flor/delete/{id}")
                .retrieve()
                .bodyToMono(Flor.class);
    }
}
