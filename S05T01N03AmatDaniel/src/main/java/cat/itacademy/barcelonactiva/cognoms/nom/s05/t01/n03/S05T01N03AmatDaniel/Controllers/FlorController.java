package cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n03.S05T01N03AmatDaniel.Controllers;

import cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n03.S05T01N03AmatDaniel.Model.Dto.FlorDto;
import cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n03.S05T01N03AmatDaniel.Model.Entity.Flor;
import cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n03.S05T01N03AmatDaniel.Model.Service.FlorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/flor")
public class FlorController {

    @Autowired
    private FlorService florService;

    @PostMapping("/clientFlorsAdd")
    public Mono<ResponseEntity<Flor>> add(@RequestBody Flor flor) {

        return florService.crearFlorMono(flor).map(creada -> new ResponseEntity<>(creada,HttpStatus.CREATED));
    }

    @GetMapping("/clientFlorsGetAll")
    public Flux<FlorDto> florDtoList() {
        ;
        return florService.veureTotesFlorsFlux();
    }

    @GetMapping("/clientFlorsGetOne/{id}")
    public Mono<FlorDto>getOne(@PathVariable(name = "id") Integer id) {

        Mono florDto = florService.veureUnaFlorMono(id);

        return florDto;
    }

    @DeleteMapping("/clientFlorsDelete/{id}")
    public Mono<Flor> delete(@PathVariable(name = "id") Integer id) {

        Mono florEliminada = florService.eliminarFlorMono(id);

        return florEliminada;
    }

    @PutMapping("/clientFlorsUpdate/{id}")

    public ResponseEntity<Mono<Flor>> update(@PathVariable(name = "id") Integer id, @RequestBody Flor flor) {

        Mono florMod = florService.modificarFlorMono(id,flor);

        return new ResponseEntity<>(florMod, HttpStatus.OK);
    }

}

