package cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n02.S05T01N02GognomsNom.Controller;
import cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n02.S05T01N02GognomsNom.Model.Entity.Flor;
import cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n02.S05T01N02GognomsNom.Model.FlorDto.FlorDto;
import cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n02.S05T01N02GognomsNom.Model.Service.FlorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Book;
import java.util.List;
@RestController
@CrossOrigin(origins = "http://localhost:9001")
@RequestMapping("/flor")
public class FlorController {

    @Autowired
    private FlorService florService;

    @PostMapping("/add")
    public ResponseEntity<Flor> add(@RequestBody Flor flor) {

        return new ResponseEntity<>(florService.crearFlor(flor), HttpStatus.CREATED);
        }

    @GetMapping("/getAll")
    public ResponseEntity<List> florDtoList() {

        List<FlorDto> florDtoList = florService.veureTotesFlors();
        ;
        return new ResponseEntity<>(florDtoList, HttpStatus.FOUND);
    }

    @GetMapping("/getOne/{id}")
    public ResponseEntity<FlorDto> getOne(@PathVariable(name = "id") Integer id) {

        FlorDto florDto = florService.veureUnaFlor(id);

        return new ResponseEntity<>(florDto, HttpStatus.FOUND);
        }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Flor> delete(@PathVariable(name = "id") Integer id) {

        Flor florEliminada = florService.eliminarFlor(id);

        return new ResponseEntity<>(florEliminada, HttpStatus.OK);
    }

    @PutMapping("/update/{id}")

    public ResponseEntity<Flor> update(@PathVariable(name = "id") Integer id, @RequestBody Flor flor) {

        Flor florMod = florService.modificarFlor(id, flor);

        return new ResponseEntity<>(florMod, HttpStatus.OK);
        }

    }
